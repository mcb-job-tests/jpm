package jpmTest;

public class RawMessage {
	private String messageType;
	private String productType;
	private String price;
	private String numOfSales;
	private String adjOp;
	private String[] output = new String[4]; 
	
	RawMessage(String _productType, Double _price){
		messageType = "MESSAGE_TYPE_1";
		productType = _productType;
		price = _price.toString();
		numOfSales = "1";
		
		output[0] = messageType;
		output[1] = productType;
		output[2] = price;
		output[3] = numOfSales;
	}
	
	RawMessage(String _productType, Double _price, int _numOfSales){
		messageType = "MESSAGE_TYPE_2";
		productType = _productType;
		price = _price.toString();
		numOfSales = Integer.toString(_numOfSales);
		
		output[0] = messageType;
		output[1] = productType;
		output[2] = price;
		output[3] = numOfSales;
	}
	
	RawMessage(String _productType, Double _price, String _adjOp){
		messageType = "MESSAGE_TYPE_3";
		productType = _productType;
		price = _price.toString();
		adjOp = _adjOp;
		
		output[0] = messageType;
		output[1] = productType;
		output[2] = price;
		output[3] = adjOp;
	}
	
	public String[] getOutput(){
		return output;
	}
}
