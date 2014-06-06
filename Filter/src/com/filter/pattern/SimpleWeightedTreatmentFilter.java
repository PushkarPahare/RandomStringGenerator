package com.filter.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleWeightedTreatmentFilter extends AbstractFilter {

	List<SimpleWeightedTreatmentRequest> requests;

	public SimpleWeightedTreatmentFilter(
			SimpleWeightedTreatmentRequest... simpleWeightedTreatmentRequest) {
		requests = Arrays.asList(simpleWeightedTreatmentRequest);
	}

	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();

		for (TreatmentAllocation t : inWeblabs) {
			for (SimpleWeightedTreatmentRequest request : requests) {
				if (t.weight == request.weight && request.t.name == t.name) {
					outWeblabs.add(t);
					break;
				}
				
			}
		}
		return new WeblabResult(outWeblabs);	}
}
