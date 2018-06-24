package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.db.dao.AssetDao;
import com.tma.ats.api.db.dao.PositionDao;
import com.tma.ats.api.db.dao.QueueDao;
import com.tma.ats.api.db.entity.Asset;
import com.tma.ats.api.db.entity.BatteryLevel;
import com.tma.ats.api.db.entity.DeviceStatus;
import com.tma.ats.api.db.entity.Position;
import com.tma.ats.api.db.entity.Queue;
import com.tma.ats.api.dto.Message;
import com.tma.ats.api.dto.MessageDto;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private QueueDao queueDao;
	@Autowired
	private PositionDao positionDao;
	@Autowired
	private AssetDao assetDao;

	@Override
	public List<Message> getMessages(String deviceId) {
		List<Message> messages = new ArrayList<Message>();
		List<Queue> queues = queueDao.getQueues(deviceId);
		for (Queue queue : queues) {
			messages.add(new MessageDto(queue.getId(), queue.getDeviceId(), formatMsg(queue)));
		}
		return messages;
	}

	@Override
	public void resolveMessage(Long messageId) {
		queueDao.delete(queueDao.read(messageId));
	}

	@Override
	public void resolveMessages(List<Long> messageIds) {
		for (Long messageId : messageIds) {
			queueDao.delete(queueDao.read(messageId));
		}
	}

	@Override
	public void reportPosition(String deviceId, Double latitude, Double longitude, Integer speed, Date reportedTime) {
		Position pos = new Position();
		pos.setDeviceId(deviceId);
		pos.setLatitude(latitude);
		pos.setLongitude(longitude);
		pos.setSpeed(speed);
		pos.setReportedTime(reportedTime);
		pos.setReceivedTime(new Date());
		pos = positionDao.create(pos);
		Asset asset = assetDao.getAssetByDeviceId(pos.getDeviceId());
		asset.setLastPositionId(pos.getId());
		asset = assetDao.update(asset);
	}

	@Override
	public void reportStatus(String deviceId, DeviceStatus deviceStatus, BatteryLevel batteryLevel) {
		Asset asset = assetDao.getAssetByDeviceId(deviceId);
		if (asset != null) {
			asset.setDeviceStatus(deviceStatus);
			asset.setBatteryLevel(batteryLevel);
			assetDao.update(asset);
		}
	}

	private static String formatMsg(Queue queue) {
		StringBuilder msg = new StringBuilder();
		msg.append(queue.getDeviceId() + "|");
		switch (queue.getMessageType()) {
		case L:
			msg.append("L||");
			break;
		case T:
			msg.append("T||");
			break;
		case S:
			msg.append("S|");
			msg.append(queue.getMessage() + "|");
			break;
		case V:
			msg.append("V||");
			break;
		case NACK:
			msg.append("A|0|");
			break;
		case ACK:
			msg.append("A|1|");
			break;

		default:
			break;
		}
		return msg.toString();
	}

}
