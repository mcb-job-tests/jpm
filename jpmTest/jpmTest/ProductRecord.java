package jpmTest;

import java.util.ArrayList;
import java.util.List;

import jpmTest.ProductAdjustment.AdjustmentOperationType;
import jpmTest.Sale.MessageType;

public class ProductRecord {
	private String name;
	private int totalNumberOfSales = 0;
	private Double totalValue = 0.0;
	private Double averagePrice = 0.0;
	private List<ProductAdjustment> adjustmentList = new ArrayList<ProductAdjustment>();
	
	ProductRecord( String _name ) {
		name = _name;
	}

	public void update( Sale sale ){
		if ( sale.getSaleType().equals( MessageType.MESSAGE_TYPE_1 ) ) {
			update( sale.getProductType(), sale.getValue() );
		} else if ( sale.getSaleType().equals( MessageType.MESSAGE_TYPE_2 ) ) {
			update( sale.getProductType(), sale.getValue(), sale.getNumOfSales() );
		} else if ( sale.getSaleType().equals( MessageType.MESSAGE_TYPE_3 ) ) {
			update( sale.getProductType(), sale.getValue(), sale.getAdjustmentOperation() );
		}
	}
	
	// Message Type 1
	public void update(String name, Double price){
		update(name, price, 1);
	}
	
	// Message Type 2
	public void update(String name, Double price, int numOfSales){
		Double saleValue = price * numOfSales;
		totalNumberOfSales += numOfSales;
		totalValue += saleValue;
		averagePrice = totalValue/totalNumberOfSales;
	}
	
	// Message Type 3
	public void update(String name, Double price, ProductAdjustment productAdj){
		
		// an adjustment operation to be applied to all stored sales of this product type
		if ( productAdj.adjOpType.equals( AdjustmentOperationType.ADD ) ){
			averagePrice += productAdj.adjAmount;
		}
		
		if ( productAdj.adjOpType.equals( AdjustmentOperationType.SUBTRACT ) ){
			averagePrice -= productAdj.adjAmount;
		}
		
		if ( productAdj.adjOpType.equals( AdjustmentOperationType.MULTIPLY ) ){
			averagePrice *= productAdj.adjAmount;
		}
		
		totalValue = averagePrice * totalNumberOfSales;		
		adjustmentList.add( productAdj );
	}
	
	public int getTotalSales(){
		return totalNumberOfSales;	
	}
	
	public Double getTotalValue(){
		return totalValue;	
	}
	
	public String getProductName(){
		return name;
	}
	
	public void logReportOfAdjustments(){
		for (int i = 0; i < adjustmentList.size(); i++){
			Double adjAmount = adjustmentList.get(i).adjAmount;
			String adjOpTypeStr = adjustmentList.get(i).adjOpType.toString();
		
			String adjOpTypeStrFormated = String.format("%1$8" + "s", adjOpTypeStr );
			
			System.out.println(getProductName() + " >> " + "Operation: " + adjOpTypeStrFormated + ", Amount: £" + adjAmount);
		}
	}
}
