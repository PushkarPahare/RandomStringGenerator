package com.filter.pattern;

import java.util.ArrayList;
import java.util.List;

public class TreatmentFilter implements IFilter {

	Treatment t;

	TreatmentFilter(Treatment t2) {
		this.t = t2;
	}

	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();
		
		for(TreatmentAllocation t : inWeblabs) {
			if(this.t.name == t.name) {
				outWeblabs.add(t);
			}
		}
		
		
		return new WeblabResult(outWeblabs);
	}

}
