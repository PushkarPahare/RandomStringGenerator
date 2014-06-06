package com.filter.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreatmentFilter implements IFilter {

	List<TreatmentRequest> requests;
	IFilter filter;

	public TreatmentFilter(IFilter filter, TreatmentRequest... treatmentRequest) {
		requests = Arrays.asList(treatmentRequest);
		this.filter = filter;
	}

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

		if(filter != null)
			return filter.filter(new WeblabResult(outWeblabs));
		else
			return new WeblabResult(outWeblabs);
	}

}
