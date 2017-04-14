package jpmTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RawAdjustmentOperatorGenerator {
	public Map<String, Double> adjOpMap = new HashMap<String, Double>();
	
	RawAdjustmentOperatorGenerator(){
		
	}
	
	public String createRawAdjustmentOperation(){
		String rawAdjOp = "";
		Double randomVal = Math.random();
		Set<String> keyset = adjOpMap.keySet();
		Object[] keySetArray = keyset.toArray();
		Double probDistSumation = 0.0;
		boolean opFound = false;
		
		for (int i = 0; i < keySetArray.length && !opFound; i++){
			probDistSumation += adjOpMap.get(keySetArray[i]);
			if ( randomVal < probDistSumation ){
				rawAdjOp = (String) keySetArray[i];
				opFound = true;
			}
		}
		return rawAdjOp;
	}
}
