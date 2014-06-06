package com.filter.pattern;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class RangeWeightedTreatmentFilter implements IFilter {
	Treatment t;
	public int x;
	public int y;

	
	RangeWeightedTreatmentFilter(Treatment t, int x, int y) {
		this.t=t;
		Assert.assertTrue(x <= y);	
		this.x = x;
		this.y = y;
	}
	
	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();
		
		for(TreatmentAllocation t : inWeblabs) {
			if(t.weight >= x && t.weight <= y && this.t.name == t.name) {
				outWeblabs.add(t);
			}
		}
		
		
		return new WeblabResult(outWeblabs);
	}
}
