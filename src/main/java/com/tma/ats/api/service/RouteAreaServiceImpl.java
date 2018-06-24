package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.RouteAreaConverter;
import com.tma.ats.api.db.dao.RouteAreaDao;
import com.tma.ats.api.db.entity.RouteArea;
import com.tma.ats.api.dto.RouteAreaCreationAttributes;
import com.tma.ats.api.dto.RouteAreaModifiableAttributes;
import com.tma.ats.api.dto.RouteAreaObject;

@Service
public class RouteAreaServiceImpl implements RouteAreaService {

	@Autowired
	private RouteAreaDao routeAreaDao;

	private RouteAreaConverter converter = new RouteAreaConverter();

	@Override
	public List<RouteAreaObject> getAllRouteAreas() {
		List<RouteArea> routeAreaList = routeAreaDao.list();
		if (routeAreaList == null) {
			return null;
		}
		List<RouteAreaObject> result = new ArrayList<RouteAreaObject>();
		for (RouteArea routeArea : routeAreaList) {
			result.add(converter.convert(routeArea));
		}
		return result;
	}

	@Override
	public RouteAreaObject createRouteArea(RouteAreaCreationAttributes attributes) {
		RouteArea routeArea = new RouteArea();

		routeArea.setName(attributes.getName());
		routeArea.setDescription(attributes.getDescription());
		routeArea.setStamp(0);

		routeArea = routeAreaDao.create(routeArea);
		return converter.convert(routeArea);
	}

	@Override
	public RouteAreaObject modifyRouteArea(RouteAreaModifiableAttributes attributes) {
		RouteArea routeArea = routeAreaDao.read(attributes.getObjectId());
		if (routeArea == null) {
			return null;
		}

		routeArea.setName(attributes.getName());
		routeArea.setDescription(attributes.getDescription());
		routeArea.setStamp(attributes.getStamp() + 1);

		routeArea = routeAreaDao.update(routeArea);
		return converter.convert(routeArea);
	}

	@Override
	public void deleteRouteAreas(List<Long> objectIds) {
		for (Long objectId : objectIds) {
			RouteArea routeArea = routeAreaDao.read(objectId);
			if (routeArea != null) {
				routeAreaDao.delete(routeArea);
			}
		}
	}

}
