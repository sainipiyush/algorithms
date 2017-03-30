package com.piyush.design.pattern.observer.basic;

public class ObserverTest {

	public static void main(String[] args) {
		
		EventDispatcher dispatcher = new EventDispatcher();
		
		EventListener listener1 = new EventListener();
		EventListener listener2 = new EventListener();
		EventListener listener3 = new EventListener();
		
		dispatcher.registerListener(listener1);
		dispatcher.registerListener(listener2);
		
		
		dispatcher.postMessage("hello");
		
		dispatcher.registerListener(listener3);
		
		dispatcher.postMessage("hello again");
	}

}
