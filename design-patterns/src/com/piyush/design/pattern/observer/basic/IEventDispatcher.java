package com.piyush.design.pattern.observer.basic;

public interface IEventDispatcher {
	
	public void registerListener(IEventListener eventListener);
	
	public void unregisterListener(IEventListener eventListener);
	
	public void notifyListeners();

}
