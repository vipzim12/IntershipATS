package com.tma.ats.api.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tma.ats.api.core.db.entity.BaseEntity;
import com.tma.ats.api.dto.AlertObject;
import com.tma.ats.api.dto.AlertObjectDTO;

@Entity
@Table(name = "alert")
public class Alert extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "device_id")
	private String deviceId;

	@Enumerated(EnumType.STRING)
	@Column(name = "alertAckState")
	private AlertAckState alertAckState;

	private Date raisedTime;
	private String acknowledgedBy;
	private boolean resolved;
	private Date resolveTime;
	private String resolveMessage;

	@ManyToOne
	@JoinColumn(name = "alert_type")
	private AlertType alertType;

	@ManyToOne
	@JoinColumn(name = "alert_status")
	private AlertStatus alertStatus;

	private int stamp;

	public Alert() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public AlertAckState getAlertAckState() {
		return alertAckState;
	}

	public void setAlertAckState(AlertAckState alertAckState) {
		this.alertAckState = alertAckState;
	}

	public Date getRaisedTime() {
		return raisedTime;
	}

	public void setRaisedTime(Date raisedTime) {
		this.raisedTime = raisedTime;
	}

	public String getAcknowledgedBy() {
		return acknowledgedBy;
	}

	public void setAcknowledgedBy(String acknowledgedBy) {
		this.acknowledgedBy = acknowledgedBy;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public Date getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(Date resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getResolveMessage() {
		return resolveMessage;
	}

	public void setResolveMessage(String resolveMessage) {
		this.resolveMessage = resolveMessage;
	}

	public AlertType getAlertType() {
		return alertType;
	}

	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}

	public AlertStatus getAlertStatus() {
		return alertStatus;
	}

	public void setAlertStatus(AlertStatus alertStatus) {
		this.alertStatus = alertStatus;
	}
	
	public AlertObject toAlertObject() {
		return new AlertObjectDTO(id, stamp, deviceId, alertAckState,
				raisedTime, acknowledgedBy, resolved, resolveTime,
				resolveMessage, alertType.toAlertTypeObject(),
				alertStatus.toAlertStatusObject());
	}
	
}