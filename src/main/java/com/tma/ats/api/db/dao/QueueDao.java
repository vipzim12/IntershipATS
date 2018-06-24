package com.tma.ats.api.db.dao;

import java.util.List;

import com.tma.ats.api.core.db.dao.BaseDao;
import com.tma.ats.api.db.entity.Queue;

public interface QueueDao extends BaseDao<Queue> {
	public List<Queue> getQueues(String deviceId);
}