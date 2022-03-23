package com.gamecenter.sa.osgi.ComponentCrud;

import java.util.List;

import com.gamecenter.sa.osgi.dataStore.Computer;

public interface ComputerComponentCrudService {
	public String addComponent(String componentName, String componentBrand, Double componentPrice, Double componentDiscount);
	public String updateComponent(String componentName,String updateComponentName, String updateComponentBrand, Double updateComponentPrice, Double updateComponentDiscount);
	public String removeComponent(String componentName);
	public Computer searchComponent(String componentName);
	public List<Computer> computerList();
	

}
