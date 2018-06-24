package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessObject;
import com.tma.ats.api.db.entity.MessageType;

public interface QueueObject extends BusinessObject<Long> {

	public String getDeviceId();

	public MessageType getMessageType();

	public String getMessage();
}
