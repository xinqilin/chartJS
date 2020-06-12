package tw.com.hy.chart.service;

import java.util.Arrays;

import tw.com.hy.chart.data.BudgetData;

public class SetDataService {
	public final static String INIT = "INIT";
	public final static String CR = "CR";
	
	public final static String[] BAR = 
			new String[]{"一月","二月","三月","四月","五月","六月"};
	
	//初始合約資料
	public final static Double[] ESTIMATE = 
			new Double[]{500.0, 1000.0, 1500.0, 2000.0, 2500.0, 3000.0};
		
	public final static Double[] ACTUAL = 
			new Double[]{200.0, 400.0, 1200.0, 2000.0, 2800.0, 3600.0};
	
	//顯示CR用的假資料
	public final static Double[] ESTIMATE_CR = 
			new Double[]{600.0, 1200.0, 1800.0, 2400.0, 3000.0, 3600.0};
	public final static Double[] ACTUAL_CR = 
			new Double[]{800.0, 1000.0, 1200.0, 3000.0, 3800.0, 4600.0};
	
	public BudgetData setData(String type){
		
		BudgetData result = new BudgetData();
		
		if(INIT.equals(type)){
			result.getxBar().addAll(Arrays.asList(BAR));
			result.getEstimate().addAll(Arrays.asList(ESTIMATE));
			result.getActual().addAll(Arrays.asList(ACTUAL));
		} else if (CR.equals(type)){
			result.getxBar().addAll(Arrays.asList(BAR));
			result.getEstimate().addAll(Arrays.asList(ESTIMATE_CR));
			result.getActual().addAll(Arrays.asList(ACTUAL_CR));
		}
		
		return result;
	}
	
}
