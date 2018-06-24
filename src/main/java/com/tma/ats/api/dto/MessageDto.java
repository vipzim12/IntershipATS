package com.tma.ats.api.dto;

import java.io.Serializable;

public class MessageDto implements Message, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final Long messageId;
	private final String devideId;
	private final String message;
	
	public MessageDto(Long messageId, String devideId, String message) {
		this.messageId = messageId;
		this.devideId = devideId;
		this.message = message;
	}

	@Override
	public Long getMessageId() {
		return messageId;
	}

	@Override
	public String getDeviceId() {
		return devideId;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
