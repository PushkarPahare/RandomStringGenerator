package com.filter.pattern;

import org.testng.Assert;

public class RangeWeightedTreatmentRequest extends AbstractRequest {
	Treatment t;
	public int x;
	public int y;

	
	RangeWeightedTreatmentRequest(Treatment t, int x, int y) {
		this.t=t;
		Assert.assertTrue(x <= y);	
		this.x = x;
		this.y = y;
	}
}
