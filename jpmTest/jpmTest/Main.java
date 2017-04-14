package jpmTest;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		final int NUMBER_OF_MESSAGES_BEFORE_SALES_LOG_REPORT = 10;
		final int NUMBER_OF_MESSAGES_BEFORE_ADJUSTMENT_LOG_REPORT = 50;
		
		// Simulate raw external message generation. 
		RawMessageGenerator rawMessageGenerator = new RawMessageGenerator();
		
		List<Sale> salesList = new ArrayList<Sale>();
		ProductRecordManager productRecordManager = new ProductRecordManager();				

		for ( int i = 1; i <= NUMBER_OF_MESSAGES_BEFORE_ADJUSTMENT_LOG_REPORT; i++ ) {
			RawMessage rawMessage = rawMessageGenerator.createRawMessage();
			String[] message = rawMessage.getOutput();
			
			// All sales must be recorded
			Sale saleMessage = new Sale( message );
			salesList.add( saleMessage );

			// All messages must be processed			
			productRecordManager.update( saleMessage );
				
			/* After every 10th message received your application should log a report detailing
			 * the number of sales of each product and their total value.*/
			if ( i % NUMBER_OF_MESSAGES_BEFORE_SALES_LOG_REPORT == 0 ){
				System.out.println(" *** " + i + " Messages Processed - Sales Log Report *** ");
				productRecordManager.logProductsReport();
			}
		}		
		/* After 50 messages your application should log that it is pausing, 
		 * stop accepting new messages and log a report of the adjustments 
		 * that have been made to each sale type while the application was running.*/
		System.out.println("*** Application Pausing - Product Adjustment Report ***");
		productRecordManager.logAdjustmentsReport();
		
	}

}
