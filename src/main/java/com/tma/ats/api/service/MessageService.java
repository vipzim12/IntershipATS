package com.tma.ats.api.service;

import java.util.Date;
import java.util.List;

import com.tma.ats.api.db.entity.BatteryLevel;
import com.tma.ats.api.db.entity.DeviceStatus;
import com.tma.ats.api.dto.Message;

public interface MessageService {
	public List<Message> getMessages(String deviceId);
	public void resolveMessage(Long messageId);
	public void resolveMessages(List<Long> messageIds);
	public void reportPosition(String deviceId, Double latitude, Double longitude, Integer speed, Date reportedTime);
	public void reportStatus(String deviceId, DeviceStatus deviceStatus, BatteryLevel batteryLevel);
}
