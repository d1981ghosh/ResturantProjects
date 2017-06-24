package com.tech.assign.restaurant;


public class Item {

	private int id;
	private String name;
	private int satisfactoryLimit;
	private int timeTaken;
	public Item(int id,String name)
	{
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSatisfactoryLimit() {
		return satisfactoryLimit;
	}
	public void setSatisfactoryLimit(int satisfactoryLimit) {
		this.satisfactoryLimit = satisfactoryLimit;
	}
	public int getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}



}
