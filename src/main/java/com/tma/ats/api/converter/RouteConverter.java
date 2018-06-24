package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.Route;
import com.tma.ats.api.dto.RouteObject;
import com.tma.ats.api.dto.RouteObjectDTO;

public class RouteConverter implements Converter<Route, RouteObject> {
	RouteAreaConverter converter = new RouteAreaConverter();

	@Override
	public RouteObject convert(Route value) {
		return new RouteObjectDTO(value.getId(), value.getStamp(),
				value.getName(), value.getLatitudeStart(),
				value.getLongitudeStart(), value.getLatitudeEnd(),
				value.getLongitudeEnd(), value.getDescription(),
				converter.convert(value.getRouteArea()));
	}
}
