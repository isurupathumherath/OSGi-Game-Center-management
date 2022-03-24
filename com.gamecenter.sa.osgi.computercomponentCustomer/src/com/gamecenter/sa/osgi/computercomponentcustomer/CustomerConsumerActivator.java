package com.gamecenter.sa.osgi.computercomponentcustomer;

import com.gamecenter.sa.osgi.componentBill.ComputerComponentService;
import com.gamecenter.sa.osgi.dataStore.Computer;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class CustomerConsumerActivator implements BundleActivator {
	
	ServiceReference computerCustomerServiceReference;
	Scanner scanner = new Scanner(System.in);
	Scanner optionScanner = new Scanner(System.in);
	boolean exit = false;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("==================Welcome to the Computer Parts Area=================");
		ServiceReference<?> componentCustomerServiceReference = context.getServiceReference(ComputerComponentService.class.getName());
		ComputerComponentService componentService = (ComputerComponentService)context.getService(componentCustomerServiceReference);
		
		do {
			String choice;
			int quantity;
			String componentName;
			
			optionScanner.nextLine();
			
			System.out.println("\n---please select what u need----");
			System.out.println("a => Component List");
			System.out.println("b => Add to cart");
			System.out.println("c => My Cart");
			System.out.println("d => Exit");
			
			System.out.print("\nSelect: ");
			choice = scanner.next();
			
			if(choice.equals("d"))
				exit = true;
			else if(choice.equals("a")) {
				List<Computer> componentList = componentService.displayComponent();
				System.out.println("-----------------------------------Computer Accessories--------------------------------------------");
				System.out.println("Component ID|"+"\t" + "Component Name|" + "\t" + "Component Brand|" + "\t" + "Component Price|" + "\t" + "Component Discount|" + "\t");
				for(Computer component : componentList)  
					  System.out.println(component.getComponentId()+"\t\t"+component.getComponentName()+"\t\t"+component.getComponentBrand()+"\t\t"+component.getComponentPrice()+"\t\t"+component.getComponentDiscount()+"\t\t");  
				System.out.println("-----------------------------------------------------------------------------------------");
				
			}
			else if(choice.equals("b")) {
				HashMap<Integer, Integer> cartMap = componentService.displayCart();
				List<Computer> componentList = componentService.displayComponent();
				System.out.println("<<<<<<<<<<<<<<<<<<<<Accessories>>>>>>>>>>>>>>>");
				for(Integer i : cartMap.keySet()) {
					for(Computer component : componentList) {
						if(component.getComponentId() == i) {
							System.out.println(i + "\t\t" + component.getComponentName() + "\t\t" + cartMap.get(i) + "\t\t");
							break;
						}
					}
				}
				System.out.println("===============================================================================");
			}
			
			
			
		}while(!exit);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("customer consumer stop!");
		context.ungetService(computerCustomerServiceReference);
	}

}
