package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.QueueObject;

public interface QueueService {
	public List<QueueObject> getQueues(String deviceId);
}
