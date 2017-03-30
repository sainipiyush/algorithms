package com.piyush.design.pattern.strategy.basic;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		
		Context con = new Context(new OperationAdd());
		con.executeOperation(20, 5);
		
		con = new Context(new OperationSubtract());
		con.executeOperation(20, 5);
		
		con = new Context(new OperationMultiply());
		con.executeOperation(20, 5);	

	}

}
