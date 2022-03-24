package com.gamecenter.sa.osgi.computercomponentsalersubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class SalerConsumerActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		SalerConsumerActivator.context = bundleContext;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		SalerConsumerActivator.context = null;
	}

}
