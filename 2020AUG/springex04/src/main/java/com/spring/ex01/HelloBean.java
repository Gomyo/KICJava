package com.spring.ex01;

public class HelloBean {
	
	private String name;
	
	public HelloBean() {
		// TODO Auto-generated constructor stub
	}
	
	public HelloBean(String name) {
		System.out.println("HelloBean(String name)");
		// 생성자를 통한 주입
		// 1. context에서 홍길동을 불러와서
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println(this.name + "님 안녕하세요.");
	}
}
