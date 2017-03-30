package com.piyush.design.pattern.strategy.basic;

public class Context {

	public Strategy startegy;

	public Context(Strategy strategy) {
		this.startegy = strategy;
	}
	
	public void executeOperation(int n1, int n2) {
		System.out.println(startegy.doOperation(n1, n2));
	}
	
}
