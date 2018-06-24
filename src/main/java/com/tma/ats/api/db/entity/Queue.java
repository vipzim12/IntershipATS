package com.tma.ats.api.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;
import com.tma.ats.api.dto.QueueObject;
import com.tma.ats.api.dto.QueueObjectDTO;

@Entity
@Table(name = "queue")
public class Queue extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="device_id")
	private String deviceId;
    
    @Enumerated(EnumType.STRING)
    @Column(name="message_type")
    private MessageType messageType;
    
    private String message;
	
	public Queue() {
		
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public MessageType getMessageType() {
		return this.messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public QueueObject toQueueObject() {
		return new QueueObjectDTO(id, deviceId, messageType, message);
	}
	
}
