package com.piyush.design.pattern.observer.basic;

public interface IEventListener {

	public void onMessage(String message);
	
	public void setEventDispatcher(IEventDispatcher eventDispatcher);
	
}
