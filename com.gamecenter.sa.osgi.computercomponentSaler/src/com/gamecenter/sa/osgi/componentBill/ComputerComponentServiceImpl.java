package com.gamecenter.sa.osgi.componentBill;

import java.awt.Component;
import java.util.HashMap;
import java.util.List;

import com.gamecenter.sa.osgi.dataStore.Computer;

public class ComputerComponentServiceImpl implements ComputerComponentService {
	
	private List<Computer> itemList = DataStore.computerList;
	private HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();

	@Override
	public List<Computer> displayComponent() {
		// TODO Auto-generated method stub
		return DataStore.computerList;
	}

	@Override
	public String addToCart(String componentName, int quantity) {
		// TODO Auto-generated method stub
		int count = -1;
		boolean value = false;
		for(Computer component : DataStore.computerList) {
			count ++;
			if(component.getComponentName().equals(componentName)) {
				cart.put(component.getComponentId(), quantity);
				break;
			}
		}
		if(value)
		return "You selected item cannot be found,please try again!";
		else
			return "Item is added!! ";
	}

	@Override
	public int GenerateComponentsBill(int id, int quantity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double displayBillTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[][] diisplayBill() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, Integer> displayCart() {
		// TODO Auto-generated method stub
		return cart;
	}

}
