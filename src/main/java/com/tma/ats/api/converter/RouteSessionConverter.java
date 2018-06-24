package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.RouteSession;
import com.tma.ats.api.dto.RouteSessionObject;
import com.tma.ats.api.dto.RouteSessionObjectDTO;

public class RouteSessionConverter implements Converter<RouteSession, RouteSessionObject> {
	RouteConverter converter = new RouteConverter();

	@Override
	public RouteSessionObject convert(RouteSession value) {
		return new RouteSessionObjectDTO(value.getId(), value.getStamp(), value.getName(), value.getDescription(),
				value.isCompleted(), value.getStartTime(), value.getEndTime(), value.getSafeDistance(),
				converter.convert(value.getRoute()));
	}
}
