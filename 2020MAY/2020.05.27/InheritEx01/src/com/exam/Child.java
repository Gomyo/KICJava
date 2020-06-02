package com.exam;

public class Child extends Parent {
	private String c;

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	// @으로 시작하는 것을 Annotation : Compiler에게 알려줌
	@Override
	public void viewP() {
		// TODO Auto-generated method stub
		System.out.println("cviewP");
	}
	
	
}
