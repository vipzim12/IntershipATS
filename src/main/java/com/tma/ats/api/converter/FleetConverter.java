package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.Fleet;
import com.tma.ats.api.dto.FleetObject;
import com.tma.ats.api.dto.FleetObjectDTO;

public class FleetConverter implements Converter<Fleet, FleetObject> {
	@Override
	public FleetObject convert(Fleet value) {
		return new FleetObjectDTO(value.getId(), value.getStamp(),
				value.getName(), value.getDescription());
	}
}