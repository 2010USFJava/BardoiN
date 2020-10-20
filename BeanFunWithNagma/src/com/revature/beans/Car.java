package com.revature.beans;

import com.revature.beans.Engine;

public class Car {
	private String make;
	private String model;
	public String EngineType;
	private String color;
	
	public Car(String make, String model, String EngineType, String color) {
		this.make = make;
		this.model = model;
		this.EngineType = EngineType;
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getEngineType() {
		return EngineType;
	}

	public void setEngineType(String EngineType) {
		this.EngineType = EngineType;
	}
	
	@Override
	public String toString() {
		return "Car [Make = " + make + ", Model = " + model + ", Engine Type = " + EngineType + ", Color = " + color + "]" ;
	}
	
}
