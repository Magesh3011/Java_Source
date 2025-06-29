package com.practice.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Car entity")
public class Car {
	@Schema(description = "The car's model number", example = "101")
	private int modelNumber;
	@Schema(description = "The car's model name", example = "AUDI")
	private String modelName;

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Car(int modelNumber, String modelName) {
		super();
		this.modelNumber = modelNumber;
		this.modelName = modelName;
	}

}
