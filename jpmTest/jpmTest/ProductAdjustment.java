package jpmTest;

public class ProductAdjustment {
	public enum AdjustmentOperationType { ADD, SUBTRACT, MULTIPLY };
	
	AdjustmentOperationType adjOpType;
	Double adjAmount;
	
	ProductAdjustment(){
		
	}
	
	ProductAdjustment( String adOpTypeStr, String adjAmountStr ){
		adjOpType = getAdjOpType( adOpTypeStr );
		adjAmount = Double.valueOf( adjAmountStr );
	}
	
	ProductAdjustment( String adOpTypeStr, Double _adjAmount ){
		adjOpType = getAdjOpType( adOpTypeStr );
		adjAmount = _adjAmount;
	}
	
	ProductAdjustment( AdjustmentOperationType _adjOpType, Double _adjAmount ){
		adjOpType = _adjOpType;
		adjAmount = _adjAmount;
	}
	
	public AdjustmentOperationType getAdjOpType( String adjOpTypeStr ){
		AdjustmentOperationType _adjOpType = null;	
		if ( adjOpTypeStr.matches( "ADD" ) ){
			_adjOpType =  AdjustmentOperationType.ADD;
		} else if ( adjOpTypeStr.matches( "SUBTRACT" ) ){
			_adjOpType =  AdjustmentOperationType.SUBTRACT;
		} else if ( adjOpTypeStr.matches( "MULTIPLY" ) ){
			_adjOpType =  AdjustmentOperationType.MULTIPLY;
		}
		return _adjOpType;
	}
}
