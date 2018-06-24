package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.Alert;
import com.tma.ats.api.dto.AlertObject;

public class AlertConverter implements Converter<Alert, AlertObject>{
	@Override
	public AlertObject convert(Alert value) {
		return value.toAlertObject();
	}
}