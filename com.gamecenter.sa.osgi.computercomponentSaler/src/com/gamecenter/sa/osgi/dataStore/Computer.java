package com.gamecenter.sa.osgi.dataStore;

public class Computer {
	
	private int componentId;
	private String componentName;
	private String componentBrand;
	private double componentPrice;
	private double componentDiscount;
	
	public Computer(int componentId, String componentName, String componentBrand, double componentPrice,
			double componentDiscount) {
		super();
		this.componentId = componentId;
		this.componentName = componentName;
		this.componentBrand = componentBrand;
		this.componentPrice = componentPrice;
		this.componentDiscount = componentDiscount;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentBrand() {
		return componentBrand;
	}
	public void setComponentBrand(String componentBrand) {
		this.componentBrand = componentBrand;
	}
	public double getComponentPrice() {
		return componentPrice;
	}
	public void setComponentPrice(double componentPrice) {
		this.componentPrice = componentPrice;
	}
	public double getComponentDiscount() {
		return componentDiscount;
	}
	public void setComponentDiscount(double componentDiscount) {
		this.componentDiscount = componentDiscount;
	}
	
	

}
