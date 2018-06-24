package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.Position;
import com.tma.ats.api.dto.PositionObject;
import com.tma.ats.api.dto.PositionObjectDto;

public class PositionConverter implements Converter<Position, PositionObject> {
	@Override
	public PositionObject convert(Position value) {
		return new PositionObjectDto(value.getId(), value.getDeviceId(),
				value.getLatitude(), value.getLongitude(), value.getSpeed(),
				value.getReceivedTime(), value.getReportedTime());
	}
}
