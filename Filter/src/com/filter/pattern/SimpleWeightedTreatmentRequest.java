package com.filter.pattern;

public class SimpleWeightedTreatmentRequest {
	Treatment t;

	SimpleWeightedTreatmentRequest(Treatment t2, int i) {
		this.weight = i;
		this.t = t2;
	}

	public int weight;

}
