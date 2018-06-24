package com.tma.ats.api.converter;

import com.tma.ats.api.core.common.Converter;
import com.tma.ats.api.db.entity.AlertLog;
import com.tma.ats.api.dto.AlertLogObject;

public class AlertLogConverter implements Converter<AlertLog, AlertLogObject>{
	@Override
	public AlertLogObject convert(AlertLog value) {
		return value.toAlertLogObject();
	}
}