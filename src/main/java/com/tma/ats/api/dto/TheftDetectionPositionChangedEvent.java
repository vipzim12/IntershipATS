package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessEvent;

public class TheftDetectionPositionChangedEvent implements BusinessEvent {
	
	private static final long serialVersionUID = 1L;
	private boolean isOutOfSafeArea;
	private PositionObject position;

	@SuppressWarnings("unused")
	private TheftDetectionPositionChangedEvent() {
	}
	
	public TheftDetectionPositionChangedEvent(PositionObject position, boolean isOutOfSafeArea) {
		this.isOutOfSafeArea = isOutOfSafeArea;
		this.position = position;
	}

	public boolean isOutOfSafeArea() {
		return isOutOfSafeArea;
	}

	public void setOutOfSafeArea(boolean isOutOfSafeArea) {
		this.isOutOfSafeArea = isOutOfSafeArea;
	}
	
	public PositionObject getPosition() {
		return position;
	}

	public void setPosition(PositionObject position) {
		this.position = position;
	}
}