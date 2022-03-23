package com.gamecenter.sa.osgi.computercomponentsalerproducer;

import com.gamecenter.sa.osgi.ComponentCrud.ComputerComponentCrudService;

import com.gamecenter.sa.osgi.dataStore.Computer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class SalerConsumerActivator implements BundleActivator {
	
	ServiceReference computerComponentServiceReference;
	Scanner scanner = new Scanner(System.in);
	Scanner optionScanner = new Scanner(System.in);
	boolean exit = false;
	
	
	@SuppressWarnings("unused")
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("==============WELCOME TO THE COMPUTER PARTS MANAGEMENT===================");
		computerComponentServiceReference = context.getServiceReference(ComputerComponentCrudService.class.getName());
		ComputerComponentCrudService computerComponentCrudService = (ComputerComponentCrudService)context.getService(computerComponentServiceReference);
		
		do {
			
			String option ;
			
			String componentName,componentBrand ,updateComponentName,updateComponentBrand;
			double componentPrice , componentDiscount , updateComponentDiscount,updateComponentPrice;
			
			
			
			optionScanner.nextLine();
			
			System.out.println("\n-------------------------------");
			System.out.println("a => Add New Component");
			System.out.println("u => Update a Component");
			System.out.println("d => Delete Item");
			System.out.println("s => Search");
			System.out.println("l => Get Item List");
			System.out.println("e => Exit");
			
			
			System.out.print("\n Select : ");
			option = scanner.next();
			
			
			if(option.equals("e") || option.equals("E"))
				exit = true;
			else if(option.equals("a") || option.equals("A")) {
				System.out.print("Component Name: ");
				componentName = optionScanner.nextLine();
				
				System.out.print("Component Brand: ");
				componentBrand = optionScanner.nextLine();
				
				System.out.print("Component Price: ");
				componentPrice = optionScanner.nextDouble();
				
				System.out.print("Component Discount: ");
				componentDiscount = optionScanner.nextDouble();
				
				String message = computerComponentCrudService.addComponent(componentName, componentBrand, componentPrice, componentDiscount);
				if(message == null) {
					System.out.println("Component Cannot be added!");
					
				}else {
					System.out.println(message);
				}
			}
			else if(option.equals("u") || option.equals("U")) {
				
				System.out.print("What Component do u need to update?: ");
				componentName = optionScanner.nextLine();
				
				
				int select = 4;
				
				System.out.println("If U Want change Component Name select 1");
				System.out.println("If U Want change Component Brand select 2");
				System.out.println("If U Want change Component Price select 3");
				System.out.println("If U Want change Component Discount select 4");
				
				System.out.println("\n Select : ");
				select = scanner.nextInt();
				
				switch(select) {
				case 1:
					System.out.print("Component Name: ");
					updateComponentName = optionScanner.nextLine();
					
					String message = computerComponentCrudService.updateComponent(componentName, updateComponentName,null,null,null);
					if(message == null) {
						System.out.print("Cannot be updated!!");
					}else {
						System.out.println(message);
					}
					break;
					
				case 2:
					System.out.print("Component Brand: ");
					updateComponentBrand = optionScanner.nextLine();
					
					String message1 = computerComponentCrudService.updateComponent(componentName, null,updateComponentBrand,null,null);
					if(message1 == null) {
						System.out.print("Cannot be updated!!");
					}else {
						System.out.println(message1);
					}
					break;
				case 3:
					System.out.print("Component Price: ");
					updateComponentPrice = optionScanner.nextDouble();
					
					String message2 = computerComponentCrudService.updateComponent(componentName, null,null,updateComponentPrice,null);
					if(message2 == null) {
						System.out.print("Cannot be updated!!");
					}else {
						System.out.println(message2);
					}
					break;
				case 4:
					System.out.print("Component Discount: ");
					updateComponentDiscount = optionScanner.nextDouble();
					
					String message3 = computerComponentCrudService.updateComponent(componentName, null,null,null,updateComponentDiscount	);
					if(message3 == null) {
						System.out.print("Cannot be updated!!");
					}else {
						System.out.println(message3);
					}
					break;
				
				}
				
				
			}
			
			else if(option.equals("d") || option.equals("D")) {
				
	
					System.out.print("Component Name: ");
					componentName = optionScanner.nextLine();
					
					String message = computerComponentCrudService.removeComponent(componentName);
					if(message == null) {
						System.out.println("Component Cannot be deleted");
					}else {
						System.out.println(message);
					}			
				
			}
			else if(option.equals("s") || option.equals("S")) {
				
				System.out.println("Component Name: ");
				componentName = optionScanner.nextLine();
				
				Computer component = computerComponentCrudService.searchComponent(componentName);
				if(component != null) {
					System.out.println(component.getComponentName());
					System.out.println(component.getComponentBrand());
					System.out.println(component.getComponentPrice());
					System.out.println(component.getComponentDiscount());
				}
				else {
					System.out.println("Component is not found");
				}
			}
			else if(option.equals("l") || option.equals("L")) {
				List<Computer> computertList = computerComponentCrudService.computerList();
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Updated List>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Component Id: |" + "\t" + "Name: |" + "\t"+"Brand: |" + "\t"+"Price: |" + "\t" + "Discount");
				for(Computer component : computertList)
				System.out.println(component.getComponentId()+"\t\t"+component.getComponentName()+"\t\t"+component.getComponentBrand()+"\t\t"+component.getComponentPrice()+"\t\t"+component.getComponentDiscount());
				System.out.println("\n==================================================================================");
						
			}
							
		}
		while(!exit);
		
		
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Close the Component Manager");
		context.ungetService(computerComponentServiceReference);
	}

}
