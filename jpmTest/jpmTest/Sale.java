package jpmTest;

public class Sale {
	public enum MessageType { MESSAGE_TYPE_1, MESSAGE_TYPE_2, MESSAGE_TYPE_3 };
	private static final int SALE_TYPE_MESSAGE_INDEX = 0;
	private static final int PRODUCT_TYPE_MESSAGE_INDEX = 1;
	private static final int VALUE_MESSAGE_INDEX = 2;
	private static final int NUM_OF_SALES_MESSAGE_INDEX = 3;
	private static final int PRODUCT_ADJUSTMENT_OPERATOR_MESSAGE_INDEX = 3;
	private MessageType saleType;
	private String productType;
	private Double value;
	 
	// Number of Sales will be 0 for Message Type 1 and -1 for Message Type 3
	private int numOfSales = -1;
	
	// adjOp will be null unless Sale is Message Type 3
	private ProductAdjustment adjOp = null;
	
	
	Sale(){
		
	}
	
	Sale(String _productType, Double _value){
		productType = _productType;
		value = _value;
	}
	
	private MessageType getMessageTypeFromString( String messageTypeStr ){
		MessageType messageType = null;
		if ( messageTypeStr.matches( MessageType.MESSAGE_TYPE_1.toString() ) ){
			messageType = MessageType.MESSAGE_TYPE_1;
		} else if ( messageTypeStr.matches( MessageType.MESSAGE_TYPE_2.toString() ) ) {
			messageType = MessageType.MESSAGE_TYPE_2;
		} else if ( messageTypeStr.matches( MessageType.MESSAGE_TYPE_3.toString() ) ) {
			messageType = MessageType.MESSAGE_TYPE_3;
		}
		return messageType;
	}
	
	Sale( String[] messageOutput ){
		saleType = getMessageTypeFromString( messageOutput[ SALE_TYPE_MESSAGE_INDEX ] );
		productType = messageOutput[ PRODUCT_TYPE_MESSAGE_INDEX ];
		if ( saleType.equals( MessageType.MESSAGE_TYPE_1 ) || saleType.equals( MessageType.MESSAGE_TYPE_2 ) ){
			value = Double.valueOf( messageOutput[ VALUE_MESSAGE_INDEX ] );
			numOfSales = Integer.parseInt( messageOutput[ NUM_OF_SALES_MESSAGE_INDEX ] );
		} else if ( saleType.equals( MessageType.MESSAGE_TYPE_3 ) ){
			String productAdjOpStr = messageOutput[ PRODUCT_ADJUSTMENT_OPERATOR_MESSAGE_INDEX ];
			String value = messageOutput[ VALUE_MESSAGE_INDEX ];
			adjOp = new ProductAdjustment(productAdjOpStr, value);
		}
	}
	
	String getProductType(){
		return productType;
	}
	
	Double getValue(){
		return value;
	}
	
	public int getNumOfSales(){
		return numOfSales;
	}
	
	public ProductAdjustment getAdjustmentOperation(){
		return adjOp;
	}
	
	void setProductType(String _productType){
		productType = _productType;
	}
	
	void setValue(Double _value){
		value = _value;
	}
	
	public MessageType getSaleType(){
		return saleType;
	}
	
}
