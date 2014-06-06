package com.filter.pattern;

import java.util.ArrayList;
import java.util.List;

public class SimpleWeightedFilter implements IFilter{

	SimpleWeightedFilter(int i) {
		this.i = i;
	}
	
	private int i;
	
	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();
		
		for(TreatmentAllocation t : inWeblabs) {
			if(t.weight == i) {
				outWeblabs.add(t);
			}
		}
		
		
		return new WeblabResult(outWeblabs);
	}

}
