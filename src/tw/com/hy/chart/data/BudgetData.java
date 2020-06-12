package tw.com.hy.chart.data;

import java.util.ArrayList;
import java.util.List;

public class BudgetData {
	private List<String> xBar;
	private List<Double> estimate;
	private List<Double> actual;
	public List<String> getxBar() {
		return xBar;
	}
	public void setxBar(List<String> xBar) {
		this.xBar = xBar;
	}
	public List<Double> getEstimate() {
		return estimate;
	}
	public void setEstimate(List<Double> estimate) {
		this.estimate = estimate;
	}
	public List<Double> getActual() {
		return actual;
	}
	public void setActual(List<Double> actual) {
		this.actual = actual;
	}
	public BudgetData() {
		this.xBar = new ArrayList<String>();
		this.estimate = new ArrayList<Double>();
		this.actual = new ArrayList<Double>();
	}
	
	
}