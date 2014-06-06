package com.filter.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleWeightedFilter implements IFilter{

	private List<SimpleWeightedRequest> requests;

	SimpleWeightedFilter(SimpleWeightedRequest... simpleWeightedRequest) {
		this.requests =  Arrays.asList(simpleWeightedRequest);
	}
	
	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();
		
		for(TreatmentAllocation t : inWeblabs) {
			for(SimpleWeightedRequest request : requests) {
				if(t.weight == request.weight) {
					outWeblabs.add(t);
					break;
				}
			}
		}
		
		
		return new WeblabResult(outWeblabs);
	}

}
