package eu.tecfox.cloud.identity.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.tecfox.cloud.identity.api.IdentityService;

/**
 * OSGi-style configuration and tracking of services.
 * 
 * @author akrebs
 *
 */
public class CoreBundleActivator implements BundleActivator {

	private static final Logger log = LoggerFactory.getLogger(CoreBundleActivator.class);
	
	/*
	 * The OSGi service tracker of the IdentityService.
	 */
	private ServiceTracker<IdentityService, IdentityService> idServiceTracker;

	/**
	 * The service persistence; provided by fragments that can be configured.
	 */
	public IdentityService identityService;

	@Override
	public void start(BundleContext context) throws Exception {

		log.info("IGS+001: CoreBundleActivator->start()");

		if (idServiceTracker == null) {
			idServiceTracker = new ServiceTracker<IdentityService, IdentityService>(context, IdentityService.class,
					null) {

				@Override
				public IdentityService addingService(ServiceReference<IdentityService> reference) {
					log.info("IGS+002: CoreBundleActivator->Adding service!");
					IdentityService res = super.addingService(reference);
					if (isProper(res)) {
						identityService = res;
					} else {
						log.warn("IGS-002: The service to add was not proper.");
					}
					return res;
				}

				private boolean isProper(IdentityService is) {
					return null != is && is.hasRealm();
				}

				@Override
				public void removedService(ServiceReference<IdentityService> reference, IdentityService service) {
					super.removedService(reference, service);

					log.info("IGS-001: The identiy service was removed.");

					// simply de-reference
					identityService = null;
				}
			};
			idServiceTracker.open();
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		log.info("IGS-001: CoreBundleActivator->stop()");

		idServiceTracker.close();
	}

}
