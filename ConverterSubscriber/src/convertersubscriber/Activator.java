package convertersubscriber;

import binarypublisher.BinaryService;
import org.osgi.framework.BundleActivator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;


public class Activator implements BundleActivator {

private static BundleContext context;
	
	public ServiceRegistration serviceRegistration;
	

	public static ServiceTracker decimalTracker,binaryTracker,octalTracker,hexaTracker;
	
	public static BinaryService binaryService;

	

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Number Converter Displayer service is started");
		ConverterService cds = new Converter();
		serviceRegistration = bundleContext.registerService(ConverterService.class.getName(), cds, null);
		
		
		binaryTracker = new ServiceTracker(bundleContext,BinaryService.class.getName(),null);
		
	
		cds.startService();
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Converter service is stopped");
		serviceRegistration.unregister();
	}

	
	
	public static boolean BinaryChecker() {
		binaryTracker.open();
		binaryService = (BinaryService) binaryTracker.getService();
		
		if (binaryService != null)
			return true;
		else
			return false;
	}
	
	

}
