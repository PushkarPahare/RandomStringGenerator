package com.filter.pattern;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class RangeWeightedFilter implements IFilter {
	public int x;
	public int y;

	
	RangeWeightedFilter(int x, int y) {
		
		Assert.assertTrue(x <= y);	
		this.x = x;
		this.y = y;
	}
	
	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();
		
		for(TreatmentAllocation t : inWeblabs) {
			if(t.weight >= x && t.weight <= y) {
				outWeblabs.add(t);
			}
		}
		
		
		return new WeblabResult(outWeblabs);
	}
}
