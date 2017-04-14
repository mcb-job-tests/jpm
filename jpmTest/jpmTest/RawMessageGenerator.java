package jpmTest;

import java.security.SecureRandom;
import java.util.Arrays;

public class RawMessageGenerator {
	Arrays productArray[];
	static final String AB = "ABC";
	private static final int PRODUCT_STRING_SIZE = 3;
	static SecureRandom rnd = new SecureRandom();
	RawMessage rawMessage;
	
	RawAdjustmentOperatorGenerator rawAdjOpGenerator;
	
	RawMessageGenerator(){
		rawAdjOpGenerator = new RawAdjustmentOperatorGenerator();
		rawAdjOpGenerator.adjOpMap.put("ADD", 0.4);
		rawAdjOpGenerator.adjOpMap.put("SUBTRACT", 0.4);
		rawAdjOpGenerator.adjOpMap.put("MULTIPLY", 0.2);
	}

	
	String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}

	public RawMessage createRawMessage(){
		String productType = randomString( PRODUCT_STRING_SIZE );
		Double price = ( double ) Math.round(Math.random() * 200 ) / 100;
		Double randVal = Math.random();
		
		// Type 1
		if ( randVal < 0.33 ) {
			rawMessage = new RawMessage(productType, price);
		// Type 2
		} else if ( randVal < 0.66 ) {
			int numOfSales = ( int ) ( 2 + ( Math.random() * 100 ) );
			rawMessage = new RawMessage(productType, price, numOfSales);	
		// Type 3
		} else {
			String adjOp = rawAdjOpGenerator.createRawAdjustmentOperation();
			rawMessage = new RawMessage(productType, price, adjOp);
		}
		
		return rawMessage;
	}
	
	
}
