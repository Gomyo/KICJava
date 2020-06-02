package com.example;

public class Person {
	private String name;
	private int age;
	private double height;
	
	// Constructor
	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("default constructor");
	}
	// Overloaded Constructor
	public Person(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
		System.out.println("Overloaded Constructor");
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
	
	
	
}

