package com.filter.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

public class RangeWeightedTreatmentFilter extends AbstractFilter {

	List<RangeWeightedTreatmentRequest> requests;
	
	public RangeWeightedTreatmentFilter(
			RangeWeightedTreatmentRequest... rangeWeightedTreatmentRequest) {
		requests = Arrays.asList(rangeWeightedTreatmentRequest);
	}

	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();

		for (TreatmentAllocation t : inWeblabs) {
			for (RangeWeightedTreatmentRequest request : requests) {
				if (t.weight >= request.x && t.weight <= request.y
						&& request.t.name == t.name) {
					outWeblabs.add(t);

					break;
				}
			}
		}
		return new WeblabResult(outWeblabs);	}

}
