package com.gamecenter.sa.osgi.componentBill;

import java.util.HashMap;
import java.util.List;

import com.gamecenter.sa.osgi.dataStore.Computer;

public interface ComputerComponentService {
	public List<Computer> displayComponent();
	public String addToCart(String componentName,int quantity);
	public int GenerateComponentsBill(int id,int quantity);
	public double displayBillTotal();
	public String[][] diisplayBill();
	public HashMap<Integer, Integer> displayCart();
	

}
