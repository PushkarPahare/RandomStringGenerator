package com.filter.pattern;

import org.testng.Assert;

public class RangeWeightedRequest extends AbstractRequest{
	public int x;
	public int y;

	
	RangeWeightedRequest(int x, int y) {
		
		Assert.assertTrue(x <= y);	
		this.x = x;
		this.y = y;
	}
}
