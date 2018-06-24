package com.tma.ats.api.dto;

import com.tma.ats.api.db.entity.MessageType;

public class QueueObjectDTO implements QueueObject {
	private static final long serialVersionUID = 1L;

	private Long objectId;

	private String deviceId;
	private MessageType messageType;
	private String message;

	/**
	 * IMPORTANT No-arg constructor is a MUST for GWT serializing/deserializing.
	 */
	public QueueObjectDTO() {
	}

	public QueueObjectDTO(Long objectId, String deviceId,
			MessageType messageType, String message) {
		super();
		this.objectId = objectId;
		this.deviceId = deviceId;
		this.messageType = messageType;
		this.message = message;
	}

	@Override
	public Long getObjectId() {
		return objectId;
	}

	@Override
	public String getDeviceId() {
		return deviceId;
	}
	
	@Override
	public MessageType getMessageType() {
		return messageType;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "AssetObjectDTO [objectId=" + objectId + ", deviceId="
				+ deviceId + ", messageTypes=" + messageType + ", message="
				+ message + "]";
	}

	@Override
	public int getStamp() {
		return 0;
	}
}
