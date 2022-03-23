package com.gamecenter.sa.osgi.ComponentCrud;

import java.util.List;

import com.gamecenter.sa.osgi.componentBill.DataStore;
import com.gamecenter.sa.osgi.dataStore.Computer;

public class ComputerComponentCrudServiceImpl implements ComputerComponentCrudService {

	@Override
	public String addComponent(String componentName, String componentBrand, Double componentPrice,
			Double componentDiscount) {
		// ADD new components to list
		int itemCount = DataStore.computerList.size();
		Computer component = new Computer(itemCount + 1, componentName, componentBrand, componentPrice, componentDiscount);
		DataStore.computerList.add(component);
		return componentName + "is added " + (itemCount + 1);
	}

	@Override
	public synchronized String updateComponent(String componentName, String updateComponentName, String updateComponentBrand, Double updateComponentPrice,
			Double updateComponentDiscount) {
		// update component details
		Computer componentUpdate = null;
		boolean value = false;
		int count = -1;
		for(Computer component : DataStore.computerList) {
			count ++;
			if(component.getComponentName().equals(componentName)) {
				componentUpdate = component;
				value = true;
				break;
			}
		}
		if(value) {
			componentUpdate.setComponentName(updateComponentName);
			componentUpdate.setComponentBrand(updateComponentBrand);
			componentUpdate.setComponentPrice(updateComponentPrice);
			componentUpdate.setComponentDiscount(updateComponentDiscount);
			
			DataStore.computerList.set(count, componentUpdate);
				
		}
		return "Component: " + componentName + "is updated!!";
	}

	@Override
	public synchronized  String removeComponent(String componentName) {
		// delete components from list
		int count = -1;
		for(Computer component : DataStore.computerList) {
			count ++;
			if(component.getComponentName().equals(componentName)) {
				DataStore.computerList.remove(count);
				break;
			}
		}
		return "Component: " +componentName + "is removed from store!!";
	}

	@Override
	public Computer searchComponent(String componentName) {
		// data search
		Computer searchResult = null;
		boolean value = false;
		for(Computer component : DataStore.computerList) {
			if(component.getComponentName().equals(componentName)) {
				searchResult = component;
				value = true;
				break;
			}
		}
		return searchResult;
	}

	@Override
	public List<Computer> computerList() {
		// TODO Auto-generated method stub
		return DataStore.computerList;
	}
	

}
