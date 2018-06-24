package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.Asset;
import com.tma.ats.api.dto.AssetObject;
import com.tma.ats.api.dto.AssetObjectDTO;

public class AssetConverter implements Converter<Asset, AssetObject> {

	@Override
	public AssetObject convert(Asset value) {
		return new AssetObjectDTO(value.getId(), value.getStamp(),
				value.getIdentifier(), value.getSerialNo(),
				value.getDeviceId(), value.getDeviceStatus(),
				value.getBatteryLevel(), value.getProduct(),
				value.getDescription(), value.getFleet().toFleetObject());
	}
}
