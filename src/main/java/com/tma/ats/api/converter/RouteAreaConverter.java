package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.RouteArea;
import com.tma.ats.api.dto.RouteAreaObject;
import com.tma.ats.api.dto.RouteAreaObjectDTO;

public class RouteAreaConverter implements Converter<RouteArea, RouteAreaObject> {
	@Override
	public RouteAreaObject convert(RouteArea value) {
		return new RouteAreaObjectDTO(value.getId(), value.getStamp(),
				value.getName(), value.getDescription());
	}
}
