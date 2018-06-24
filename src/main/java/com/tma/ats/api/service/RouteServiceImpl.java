package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.RouteConverter;
import com.tma.ats.api.db.dao.RouteAreaDao;
import com.tma.ats.api.db.dao.RouteDao;
import com.tma.ats.api.db.entity.Route;
import com.tma.ats.api.db.entity.RouteArea;
import com.tma.ats.api.dto.RouteCreationAttributes;
import com.tma.ats.api.dto.RouteObject;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao routeDao;
	@Autowired
	private RouteAreaDao routeAreaDao;

	private RouteConverter routeConverter = new RouteConverter();

	@Override
	public List<RouteObject> getRoutesByArea(Long objectId) {
		List<RouteObject> result = new ArrayList<RouteObject>();
		List<Route> routes = new ArrayList<Route>();
		if (objectId == null) {
			routes = routeDao.list();
		} else {
			RouteArea routeArea = routeAreaDao.read(objectId);
			if ((routeArea == null) || (routeArea.getRoutes() == null)) {
				return null;
			}
			routes = routeArea.getRoutes();
		}
		for (Route route : routes) {
			result.add(routeConverter.convert(route));
		}
		return result;
	}

	@Override
	public List<RouteObject> getAllRoutes() {
		List<RouteObject> result = new ArrayList<RouteObject>();
		List<Route> routes = routeDao.list();
		for (Route route : routes) {
			result.add(routeConverter.convert(route));
		}
		return result;
	}

	@Override
	public RouteObject createRoute(RouteCreationAttributes attributes) {
		Route route = new Route();

		route.setName(attributes.getName());
		route.setLatitudeStart(attributes.getLatitudeStart());
		route.setLongitudeStart(attributes.getLongitudeStart());
		route.setLatitudeEnd(attributes.getLatitudeEnd());
		route.setLongitudeEnd(attributes.getLongitudeEnd());
		route.setDescription(attributes.getDescription());
		route.setRouteArea(routeAreaDao.read(attributes.getRouteArea().getObjectId()));
		route.setStamp(0);

		route = routeDao.create(route);
		return routeConverter.convert(route);
	}

	@Override
	public RouteObject getRoute(long objectId) {
		Route route = routeDao.read(objectId);
		if (route == null) {
			return null;
		}
		return routeConverter.convert(route);
	}

	@Override
	public void deleteRoutes(List<Long> objectIds) {
		for (Long objectId : objectIds) {
			Route route = routeDao.read(objectId);
			if (route != null) {
				routeDao.delete(route);
			}
		}
	}

}
