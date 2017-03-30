package com.piyush.design.pattern.strategy.basic;

public class OperationAdd implements Strategy {

	@Override
	public int doOperation(int n1, int n2) {
		
		return n1 + n2;
	}

}
