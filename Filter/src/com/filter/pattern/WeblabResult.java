package com.filter.pattern;

import java.util.ArrayList;
import java.util.List;

public class WeblabResult {
	List<TreatmentAllocation> weblabs = new ArrayList<TreatmentAllocation>();
	
	WeblabResult(List<TreatmentAllocation> result ) {
		weblabs = result;
	}
	
	List<TreatmentAllocation> getList() {
		return weblabs;
	}
	
	public String toString() {
		String out = "";
		for(TreatmentAllocation t : weblabs) {
			out += t.name + ":" + t.weight + "\n";
		}
		return out;
	}
}
