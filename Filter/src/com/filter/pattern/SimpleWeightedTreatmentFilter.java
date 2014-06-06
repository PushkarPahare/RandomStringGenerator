package com.filter.pattern;

import java.util.ArrayList;
import java.util.List;

public class SimpleWeightedTreatmentFilter implements IFilter {

	Treatment t;

	SimpleWeightedTreatmentFilter(Treatment t2, int i) {
		this.i = i;
		this.t = t2;
	}
	
	private int i;
	
	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();
		
		for(TreatmentAllocation t : inWeblabs) {
			if(t.weight ==i && t.name == t.name) {
				outWeblabs.add(t);
			}
		}
		
		
		return new WeblabResult(outWeblabs);
	}

}
