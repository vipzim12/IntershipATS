package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.IdleDetection;
import com.tma.ats.api.dto.IdleDetectionObject;
import com.tma.ats.api.dto.IdleDetectionObjectDTO;

public class IdleDetectionConverter implements Converter<IdleDetection, IdleDetectionObject> {
	@Override
	public IdleDetectionObject convert(IdleDetection value) {
		return new IdleDetectionObjectDTO(value.getId(), value.getStamp(),
				value.getDeviceId(), value.getPriority(), value.getMessage(),
				value.getMail(), value.getAlertType().toAlertTypeObject(),
				value.isEnabled(), value.getRadius(), value.getDuration());
	}
}
