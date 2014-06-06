package com.filter.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

public class RangeWeightedFilter implements IFilter {

	List<RangeWeightedRequest> requests;
	IFilter filter;
	
	public RangeWeightedFilter(IFilter filter, RangeWeightedRequest... rangeWeightedRequest) {
		// TODO Auto-generated constructor stub
		requests = Arrays.asList(rangeWeightedRequest);
		this.filter = filter;
	}
	
	public RangeWeightedFilter(RangeWeightedRequest... rangeWeightedRequest) {
		// TODO Auto-generated constructor stub
		requests = Arrays.asList(rangeWeightedRequest);
	}

	@Override
	public WeblabResult filter(WeblabResult weblabs) {
		List<TreatmentAllocation> outWeblabs = new ArrayList<TreatmentAllocation>();
		List<TreatmentAllocation> inWeblabs = weblabs.getList();

		for (TreatmentAllocation t : inWeblabs) {
			for (RangeWeightedRequest request : requests) {
				if (t.weight >= request.x && t.weight <= request.y) {
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
