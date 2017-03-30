package com.piyush.design.pattern.observer.basic;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher implements IEventDispatcher {
	
	String message;
	private List<IEventListener> listeners;
	private final Object mutex = new Object();
	
	EventDispatcher() {
		listeners = new ArrayList<IEventListener>();
	}
	
	@Override
	public void registerListener(IEventListener eventListener) {
		synchronized (mutex) {
			if(!listeners.contains(eventListener))
				listeners.add(eventListener);
		}
	}

	@Override
	public void unregisterListener(IEventListener eventListener) {
		synchronized (mutex) {
			listeners.remove(eventListener);
		}
				
	}

	@Override
	public void notifyListeners() {
		synchronized (mutex) {
			for(IEventListener listener : listeners) {
				listener.onMessage(message);
			}
		}		
	}
	
	public String getMessage() {
		return message;
	}

	public void postMessage(String message) {
		this.message = message;
		notifyListeners();
	}

}
