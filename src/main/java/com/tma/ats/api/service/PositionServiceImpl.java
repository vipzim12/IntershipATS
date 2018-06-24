package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.PositionConverter;
import com.tma.ats.api.db.dao.AlertDao;
import com.tma.ats.api.db.dao.AlertLogDao;
import com.tma.ats.api.db.dao.AlertStatusDao;
import com.tma.ats.api.db.dao.AlertTypeDao;
import com.tma.ats.api.db.dao.AssetDao;
import com.tma.ats.api.db.dao.IdleDetectionDao;
import com.tma.ats.api.db.dao.PositionDao;
import com.tma.ats.api.db.dao.RouteDao;
import com.tma.ats.api.db.dao.SafeAreaDao;
import com.tma.ats.api.db.dao.TheftDetectionDao;
import com.tma.ats.api.db.entity.Alert;
import com.tma.ats.api.db.entity.AlertAckState;
import com.tma.ats.api.db.entity.AlertLog;
import com.tma.ats.api.db.entity.AlertStatus;
import com.tma.ats.api.db.entity.AlertType;
import com.tma.ats.api.db.entity.Asset;
import com.tma.ats.api.db.entity.EventType;
import com.tma.ats.api.db.entity.IdleDetection;
import com.tma.ats.api.db.entity.Position;
import com.tma.ats.api.db.entity.Route;
import com.tma.ats.api.db.entity.RoutePoint;
import com.tma.ats.api.db.entity.RouteSession;
import com.tma.ats.api.db.entity.SafeArea;
import com.tma.ats.api.db.entity.TheftDetection;
import com.tma.ats.api.dto.PositionCreationAttributes;
import com.tma.ats.api.dto.PositionObject;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionDao positionDao;
	@Autowired
	private AssetDao assetDao;
	@Autowired
	private AlertDao alertDao;
	@Autowired
	private AlertTypeDao alertTypeDao;
	@Autowired
	private AlertStatusDao alertStatusDao;
	@Autowired
	private AlertLogDao alertLogDao;
	@Autowired
	private RouteDao routeDao;
	@Autowired
	private TheftDetectionDao theftDetecionDao;
	@Autowired
	private SafeAreaDao safeAreaDao;
	@Autowired
	private IdleDetectionDao idleDetectionDao;

	private PositionConverter positionConverter = new PositionConverter();

	@Override
	public List<PositionObject> getAllPositions() {
		List<Position> positions = positionDao.getAllPositions();
		if (positions == null) {
			return null;
		}
		List<PositionObject> assetPositionObjects = new ArrayList<PositionObject>();
		for (Position pos : positions) {
			assetPositionObjects.add(pos.toPositionObject());
		}
		return assetPositionObjects;
	}

	@Override
	public PositionObject getPositionByDeviceId(String deviceId) {
		Position position = positionDao.getPositionByDeviceId(deviceId);
		if (position == null)
			return null;
		return positionConverter.convert(position);
	}

	@Override
	public PositionObject createPosition(PositionCreationAttributes attributes) {
		Position position = new Position();

		position.setDeviceId(attributes.getDeviceId());
		position.setLatitude(attributes.getLatitude());
		position.setLongitude(attributes.getLongitude());
		position.setSpeed(30);

		Date date = new Date();
		position.setReceivedTime(date);
		position.setReportedTime(date);

		position = positionDao.create(position);

		Asset asset = assetDao.getAssetByDeviceId(position.getDeviceId());
		asset.setLastPositionId(position.getId());
		asset = assetDao.update(asset);

		PositionObject positionObject = position.toPositionObject();
		return positionObject;
	}

	@Override
	public List<PositionObject> getPositionsByDeviceIds(List<String> deviceIds) {
		System.out.println("ENTER: PositionManagementBean.getPositionsByDeviceIds");
		List<Position> positions = new ArrayList<Position>();
		positions = positionDao.getPositionsByDeviceIds(deviceIds);
		List<PositionObject> results = new ArrayList<PositionObject>();
		for (Position position : positions) {
			results.add(positionConverter.convert(position));
		}
		return results;
	}

	private void checkTheftDetection(PositionObject position) {
		// Check device was theft detection alert
		List<Alert> alerts = new ArrayList<Alert>();
		alerts = alertDao.getAlertsByDeviceId(position.getDeviceId());
		boolean isTheftDetectionAlert = false;

		if (alerts != null) {
			for (Alert alert : alerts) {
				if (alert.getAlertType().getId() == 1) {
					isTheftDetectionAlert = true;
					break;
				}
			}
		}

		if (!isTheftDetectionAlert) {
			// Get safe radius of device
			TheftDetection theftDetection = theftDetecionDao.getTheftDetection(position.getDeviceId());
			if (theftDetection.isEnabled()) {
				// Get Safe Areas of theft detection
				List<SafeArea> safeAreas = new ArrayList<SafeArea>();
				safeAreas = safeAreaDao.getSafeAreas(theftDetection.getId());
				if (safeAreas != null) {
					for (SafeArea safeArea : safeAreas) {
						if (safeArea.isEnabled()) {
							// Compare distance & safe radius
							double radius = safeArea.getRadius() / 1000;
							double distance = GpsHelper.calculateDistance(safeArea.getLatitude(),
									safeArea.getLongitude(), position.getLatitude(), position.getLongitude());
							if (distance > radius) {
								// Create Alert by theft detection
								AlertType alertType = new AlertType();
								AlertStatus alertStatus = new AlertStatus();
								long alertTypeId = 1;
								long alertStatusId = 1;
								alertType = alertTypeDao.read(alertTypeId);
								alertStatus = alertStatusDao.read(alertStatusId);
								Date date = new Date();
								Alert alert = new Alert();
								alert.setDeviceId(position.getDeviceId());
								alert.setStamp(0);
								alert.setAlertAckState(AlertAckState.Unacknowledged);
								alert.setRaisedTime(date);
								alert.setAlertType(alertType);
								alert.setAlertStatus(alertStatus);
								alertDao.create(alert);

								// Create Alert Log for Alert
								AlertLog alertLog = new AlertLog();
								alertLog.setEventType(EventType.Raised);
								alertLog.setEventTime(date);
								alertLog.setMessage("The device is out of safe area");
								alertLog.setAlert(alert);
								alertLog = alertLogDao.create(alertLog);
								break;
							}
						}
					}
				}
			}
		}
	}

	public void checkIdleDetection(PositionObject position) {
		// Get idle detection of device
		IdleDetection idleDetection = idleDetectionDao.getIdleDetection(position.getDeviceId());
		if (idleDetection != null && idleDetection.isEnabled()) {
			// Check device was idle alert
			List<Alert> alerts = new ArrayList<Alert>();
			alerts = alertDao.getAlertsByDeviceId(position.getDeviceId());
			boolean isIdleDetectionAlert = false;

			if (alerts != null) {
				for (Alert alert : alerts) {
					if (alert.getAlertType().getId() == 3) {
						isIdleDetectionAlert = true;
						break;
					}
				}
			}

			if (!isIdleDetectionAlert) {
				// Get received time of device
				Date receivedTime = position.getReceivedTime();
				// Get idle duration & radius of device
				double duration = idleDetection.getDuration();
				double radius = idleDetection.getRadius() / 1000;

				// Get Positions of device
				List<Position> positions = positionDao.getPositionsByDeviceId(position.getDeviceId());
				List<Position> positionsCheckIdle = new ArrayList<Position>();
				for (Position pos : positions) {
					long elapsedTime = TimeUnit.MILLISECONDS
							.toMinutes(receivedTime.getTime() - pos.getReceivedTime().getTime());
					if (elapsedTime < duration) {
						positionsCheckIdle.add(pos);
					}
				}

				boolean isIdle = true;
				for (Position posCheckIdle : positionsCheckIdle) {
					double distance = GpsHelper.calculateDistance(positionsCheckIdle.get(0).getLatitude(),
							positionsCheckIdle.get(0).getLongitude(), posCheckIdle.getLatitude(),
							posCheckIdle.getLongitude());
					if (distance > radius) {
						isIdle = false;
						break;
					}
				}

				if (isIdle) {
					double newDistance = GpsHelper.calculateDistance(positionsCheckIdle.get(0).getLatitude(),
							positionsCheckIdle.get(0).getLongitude(), position.getLatitude(), position.getLongitude());
					if (newDistance > radius)
						isIdle = false;
				}

				if (isIdle) {
					// Create Alert by Idle detection
					AlertType alertType = new AlertType();
					AlertStatus alertStatus = new AlertStatus();
					alertType = alertTypeDao.read(new Long(3));
					alertStatus = alertStatusDao.read(new Long(1));
					Date date = new Date();
					Alert alert = new Alert();
					alert.setDeviceId(position.getDeviceId());
					alert.setStamp(0);
					alert.setAlertAckState(AlertAckState.Unacknowledged);
					alert.setRaisedTime(date);
					alert.setAlertType(alertType);
					alert.setAlertStatus(alertStatus);
					alertDao.create(alert);

					// Create Alert Log for Alert
					AlertLog alertLog = new AlertLog();
					alertLog.setEventType(EventType.Raised);
					alertLog.setEventTime(date);
					alertLog.setMessage("The device is idle");
					alertLog.setAlert(alert);
					alertLog = alertLogDao.create(alertLog);
				}
			}
		}
	}

	private void checkOutOfRoute(PositionObject position) {
		// Check device is out of route alert
		List<Alert> alerts = new ArrayList<Alert>();
		alerts = alertDao.getAlertsByDeviceId(position.getDeviceId());
		boolean isOutOfRouteAlert = false;

		if (alerts != null) {
			for (Alert alert : alerts) {
				if (alert.getAlertType().getId() == 2) {
					isOutOfRouteAlert = true;
					break;
				}
			}
		}

		if (!isOutOfRouteAlert) {
			Asset asset = assetDao.getAssetByDeviceId(position.getDeviceId());
			List<RouteSession> routeSessions = asset.getRouteSessions();
			if (routeSessions.size() > 0) {
				for (RouteSession routeSession : routeSessions) {
					if (routeSession.getStartTime() != null && routeSession.getEndTime() == null) {
						double minDistance = 0;
						int minIndex = 0;

						// 3 edge of Triangle
						double a = 0;
						double b, b1, b2;
						double c, c1, c2;

						// Get Route Points of route
						List<RoutePoint> points = new ArrayList<RoutePoint>();
						Route route = routeDao.read(routeSession.getRoute().getId());
						points = route.getRoutePoints();

						// Calculate minimum distance from position to route
						for (int i = 0; i < points.size(); i++) {
							double distance = GpsHelper.calculateDistance(points.get(i).getLatitude(),
									points.get(i).getLongitude(), position.getLatitude(), position.getLongitude());
							if (a == 0 || distance < a) {
								a = distance;
								minIndex = i;
							}
						}

						if (minIndex == 0 || minIndex == points.size() - 1) {
							if (minIndex == 0) {
								b = GpsHelper.calculateDistance(points.get(minIndex).getLatitude(),
										points.get(minIndex).getLongitude(), points.get(minIndex + 1).getLatitude(),
										points.get(minIndex + 1).getLongitude());
								c = GpsHelper.calculateDistance(points.get(minIndex + 1).getLatitude(),
										points.get(minIndex + 1).getLongitude(), position.getLatitude(),
										position.getLongitude());
							} else {
								b = GpsHelper.calculateDistance(points.get(minIndex).getLatitude(),
										points.get(minIndex).getLongitude(), points.get(minIndex - 1).getLatitude(),
										points.get(minIndex - 1).getLongitude());
								c = GpsHelper.calculateDistance(points.get(minIndex - 1).getLatitude(),
										points.get(minIndex - 1).getLongitude(), position.getLatitude(),
										position.getLongitude());
							}
							int triangle = checkTriangle(c, a, b);
							if (triangle == 1) {
								minDistance = calculateDistance(b, a, c);
							} else
								minDistance = a;
						} else {
							b1 = GpsHelper.calculateDistance(points.get(minIndex).getLatitude(),
									points.get(minIndex).getLongitude(), points.get(minIndex - 1).getLatitude(),
									points.get(minIndex - 1).getLongitude());
							b2 = GpsHelper.calculateDistance(points.get(minIndex).getLatitude(),
									points.get(minIndex).getLongitude(), points.get(minIndex + 1).getLatitude(),
									points.get(minIndex + 1).getLongitude());
							c1 = GpsHelper.calculateDistance(points.get(minIndex - 1).getLatitude(),
									points.get(minIndex - 1).getLongitude(), position.getLatitude(),
									position.getLongitude());
							c2 = GpsHelper.calculateDistance(points.get(minIndex + 1).getLatitude(),
									points.get(minIndex + 1).getLongitude(), position.getLatitude(),
									position.getLongitude());

							int triangle1 = checkTriangle(c1, a, b1);
							int triangle2 = checkTriangle(c2, a, b2);

							if ((triangle1 == 3 && triangle2 == 3) || (triangle1 == 2 && triangle2 == 2)
									|| (triangle1 == 2 && triangle2 == 3) || (triangle1 == 3 && triangle2 == 2)) {
								minDistance = a;
							}

							if (triangle1 == 1 && triangle2 != 1) {
								minDistance = calculateDistance(b1, a, c1);
							}

							if (triangle1 != 1 && triangle2 == 1) {
								minDistance = calculateDistance(b2, a, c2);
							}

							if (triangle1 == 1 && triangle2 == 1) {
								if (calculateDistance(b1, a, c1) < calculateDistance(b2, a, c2))
									minDistance = calculateDistance(b1, a, c1);
								else
									minDistance = calculateDistance(b2, a, c2);
							}
						}

						// Check minimum distance & safe distance of route session
						double safeDistance = routeSession.getSafeDistance() / 1000;
						if (minDistance > safeDistance) {
							// Create Alert by out of route
							AlertType alertType = new AlertType();
							AlertStatus alertStatus = new AlertStatus();
							long alertTypeId = 2;
							long alertStatusId = 1;
							alertType = alertTypeDao.read(alertTypeId);
							alertStatus = alertStatusDao.read(alertStatusId);
							Date date = new Date();
							Alert alert = new Alert();
							alert.setDeviceId(position.getDeviceId());
							alert.setStamp(0);
							alert.setAlertAckState(AlertAckState.Unacknowledged);
							alert.setRaisedTime(date);
							alert.setAlertType(alertType);
							alert.setAlertStatus(alertStatus);
							alertDao.create(alert);

							// Create Alert Log for Alert
							AlertLog alertLog = new AlertLog();
							alertLog.setEventType(EventType.Raised);
							alertLog.setEventTime(date);
							alertLog.setMessage("The device is out of route");
							alertLog.setAlert(alert);
							alertLog = alertLogDao.create(alertLog);
						}
					}
				}
			}
		}
	}

	private int checkTriangle(double a, double b, double c) {
		double cosA = (b * b + c * c - a * a) / (2 * b * c);
		if (cosA > 0) // A < 90
			return 1;
		else {
			if (cosA == 0)
				return 2;
			else {
				return 3;
			}
		}
	}

	private double calculateDistance(double a, double b, double c) {
		double p = (a + b + c) / 2;
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		double h = (2 * s) / a;
		return h;
	}

	@Override
	public List<PositionObject> getPositionsByDeviceId(String deviceId) {
		List<Position> positions = new ArrayList<Position>();
		positions = positionDao.getPositionsByDeviceId(deviceId);
		List<PositionObject> results = new ArrayList<PositionObject>();
		for (Position position : positions) {
			results.add(positionConverter.convert(position));
		}
		return results;
	}

}
