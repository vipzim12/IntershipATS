package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.db.dao.QueueDao;
import com.tma.ats.api.db.entity.Queue;
import com.tma.ats.api.dto.QueueObject;

@Service
public class QueueServiceImpl implements QueueService {

	@Autowired
	private QueueDao queueDao;

	@Override
	public List<QueueObject> getQueues(String deviceId) {
		List<Queue> queues = queueDao.getQueues(deviceId);
		if (queues == null) {
			return null;
		}
		List<QueueObject> queueObjects = new ArrayList<QueueObject>();
		for (Queue queue : queues) {
			queueObjects.add(queue.toQueueObject());
		}
		return queueObjects;
	}

}
