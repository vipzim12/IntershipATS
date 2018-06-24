package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.POIType;
import com.tma.ats.api.dto.POITypeObject;
import com.tma.ats.api.dto.POITypeObjectDTO;

public class POITypeConverter implements Converter<POIType, POITypeObject> {
	@Override
	public POITypeObject convert(POIType value) {
		return new POITypeObjectDTO(value.getId(), value.getStamp(),
				value.getName(), value.getDescription());
	}
}
