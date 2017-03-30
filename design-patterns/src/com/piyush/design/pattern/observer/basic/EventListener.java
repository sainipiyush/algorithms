package com.piyush.design.pattern.observer.basic;

public class EventListener implements IEventListener {
	
	IEventDispatcher eventDispatcher;

	@Override
	public void onMessage(String message) {
		System.out.println("Event received : " + message);
		
	}

	@Override
	public void setEventDispatcher(IEventDispatcher eventDispatcher) {
		this.eventDispatcher = eventDispatcher;
		
	}

}
