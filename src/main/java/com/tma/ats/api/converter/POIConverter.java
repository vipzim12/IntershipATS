package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.POI;
import com.tma.ats.api.dto.POIObject;
import com.tma.ats.api.dto.POIObjectDTO;

public class POIConverter implements Converter<POI, POIObject> {
	POITypeConverter converter = new POITypeConverter();

	@Override
	public POIObject convert(POI value) {
		return new POIObjectDTO(value.getId(), value.getStamp(),
				value.getName(), value.getLatitude(), value.getLongitude(),
				value.getDescription(), converter.convert(value.getPoiType()));
	}
}
