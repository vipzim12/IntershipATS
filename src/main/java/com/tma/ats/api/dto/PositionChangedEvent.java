package com.tma.ats.api.dto;

import com.tma.ats.api.core.BusinessEvent;

public class PositionChangedEvent implements BusinessEvent {
	
	private static final long serialVersionUID = 1L;
	private boolean isOutOfRoute;
	private PositionObject position;

	@SuppressWarnings("unused")
	private PositionChangedEvent() {
	}
	
	public PositionChangedEvent(PositionObject position
			, boolean isOutOfRoute) {
		this.isOutOfRoute = isOutOfRoute;
		this.position = position;
	}

	public boolean isOutOfRoute() {
		return isOutOfRoute;
	}

	public void setOutOfRoute(boolean isOutOfRoute) {
		this.isOutOfRoute = isOutOfRoute;
	}
	
	public PositionObject getPosition() {
		return position;
	}

	public void setPosition(PositionObject position) {
		this.position = position;
	}
}