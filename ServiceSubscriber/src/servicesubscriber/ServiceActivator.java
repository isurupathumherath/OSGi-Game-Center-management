package servicesubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.mtit.service.ServicePublish;

public class ServiceActivator implements BundleActivator {


	ServiceReference serviceReference;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Subscriber Service");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) context.getService(serviceReference);
		System.out.println(servicePublish.publishService());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Good Bye");
		context.ungetService(serviceReference);
	}

}
