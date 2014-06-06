package com.filter.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreatmentFilter extends AbstractFilter {

	List<TreatmentRequest> requests;

	public TreatmentFilter(TreatmentRequest treatmentRequest) {
		requests = Arrays.asList(treatmentRequest);
	}

	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();

		for (TreatmentAllocation t : inWeblabs) {
			for (TreatmentRequest request : requests) {
				if (request.t.name == t.name) {
					outWeblabs.add(t);
					break;

				}
			}
		}
		return new WeblabResult(outWeblabs);
	}
}
