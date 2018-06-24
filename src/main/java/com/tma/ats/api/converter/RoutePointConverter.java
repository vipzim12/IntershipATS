package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.RoutePoint;
import com.tma.ats.api.dto.RoutePointObject;
import com.tma.ats.api.dto.RoutePointObjectDTO;

public class RoutePointConverter implements Converter<RoutePoint, RoutePointObject> {
	RouteConverter converter = new RouteConverter();

	@Override
	public RoutePointObject convert(RoutePoint value) {
		return new RoutePointObjectDTO(value.getId(), value.getStamp(),
				value.getLatitude(), value.getLongitude(),
				converter.convert(value.getRoute()));
	}
}
