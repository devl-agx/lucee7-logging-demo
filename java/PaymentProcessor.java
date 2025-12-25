package com.mycompany.utils;

import lucee.commons.io.log.Log;

public class PaymentProcessor {

	private final Log logger;

	public PaymentProcessor( Log logger ) {
		this.logger = logger;
	}

	public boolean processPayment( String customerId, double amount ) {

		// DEBUG - detailed info for troubleshooting
		logger.debug( "PaymentProcessor", "Starting payment processing for customer: " + customerId );

		// INFO - general operational messages
		logger.info( "PaymentProcessor", "Processing payment of $" + amount + " for customer " + customerId );

		try {
			// do the actual payment stuff...

			if ( amount > 10000 ) {
				// WARN - something dodgy but not fatal
				logger.warn( "PaymentProcessor", "Large transaction detected: $" + amount + " for customer " + customerId );
			}

			logger.info( "PaymentProcessor", "Payment successful for customer " + customerId );
			return true;

		}
		catch ( Exception e ) {
			// ERROR - something broke
			logger.error( "PaymentProcessor", "Payment failed for customer " + customerId + " - amount: $" + amount, e );
			throw e;
		}
	}
}
