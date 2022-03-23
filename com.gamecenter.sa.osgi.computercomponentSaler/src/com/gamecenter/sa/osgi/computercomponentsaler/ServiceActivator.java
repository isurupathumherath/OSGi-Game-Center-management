package com.gamecenter.sa.osgi.computercomponentsaler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.gamecenter.sa.osgi.ComponentCrud.ComputerComponentCrudService;
import com.gamecenter.sa.osgi.ComponentCrud.ComputerComponentCrudServiceImpl;
import com.gamecenter.sa.osgi.componentBill.ComputerComponentService;
import com.gamecenter.sa.osgi.componentBill.ComputerComponentServiceImpl;

public class ServiceActivator implements BundleActivator {
	ServiceRegistration serviceRegister;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("==================WELCOME TO THE COMPUTER COMPONENTS AREA===============");
		ComputerComponentService computerComponentService = new ComputerComponentServiceImpl();
		serviceRegister = context.registerService(ComputerComponentService.class.getName(), computerComponentService, null);
		ComputerComponentCrudService computerComponentCrudService = new ComputerComponentCrudServiceImpl();
		serviceRegister = context.registerService(ComputerComponentCrudService.class.getName(), computerComponentCrudService, null);
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("==================Thank You For Visiting====================");
		serviceRegister.unregister();
	}

}
