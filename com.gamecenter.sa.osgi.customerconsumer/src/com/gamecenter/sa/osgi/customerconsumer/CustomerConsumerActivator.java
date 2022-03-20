package com.gamecenter.sa.osgi.customerconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.gamecenter.sa.osgi.gameservice.GameService;

public class CustomerConsumerActivator implements BundleActivator {

	ServiceReference gameCustomerServiceReference;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("============Customer consumer started.============");
		gameCustomerServiceReference = bundleContext.getServiceReference(GameService.class.getName());
		GameService gameService = (GameService)bundleContext.getService(gameCustomerServiceReference);
		System.out.println(gameService.displayGame());
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("============Customer consumer stopped.============");
		bundleContext.ungetService(gameCustomerServiceReference);
	}

}
