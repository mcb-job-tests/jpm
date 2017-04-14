package jpmTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProductRecordManager {
	public Map< String, ProductRecord > productRecordMap = new HashMap< String, ProductRecord >();
	
	ProductRecordManager(){
		
	}
	
	public void update( Sale sale ){
		String productType = sale.getProductType();
		
		if ( ! productRecordMap.containsKey( productType ) ){
			ProductRecord newProductRecord = new ProductRecord( productType );
			productRecordMap.put( productType, newProductRecord );
		}
		productRecordMap.get( productType ).update( sale );
	}
	
	/* Logs a report detailing the number of sales of each product and their total value.*/
	public void logProductsReport(){
		Set< String > keySet = productRecordMap.keySet();
		Object[] keySetArray = keySet.toArray();
		
		Arrays.sort(keySetArray);
		
		for (int i = 0; i < keySetArray.length; i++ ) {
			ProductRecord productRecord = productRecordMap.get( keySetArray[ i ] );
			
			int totalSales = productRecord.getTotalSales();
			String totalSalesStr = Integer.toString(totalSales);
			String totalSalesStrFormated = String.format("%1$4" + "s", totalSalesStr );
			
			String totalValueStr = String.format("%.2f", productRecord.getTotalValue());
			String totalValueStrFormated = String.format("%1$7" + "s", totalValueStr );
			
			if ( totalSales > 0 ) {
				System.out.println( productRecord.getProductName()
						+ " >> Total Sales: "
						+ totalSalesStrFormated
						+ ", Total Value: £"
						+ totalValueStrFormated );	
			}
			
		}
		System.out.println();
	}
	
	public void logAdjustmentsReport(){
		Set< String > keySet = productRecordMap.keySet();
		Object[] keySetArray = keySet.toArray();
		
		Arrays.sort(keySetArray);
		
		for (int i = 0; i < keySetArray.length; i++ ) {
			ProductRecord productRecord = productRecordMap.get( keySetArray[ i ] );
			productRecord.logReportOfAdjustments();
		}
	}
	
}
