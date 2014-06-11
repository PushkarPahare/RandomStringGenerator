package com.filter.pattern;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.collections4.set.ListOrderedSet;

public class Main {
	
	public static void main(String... s) {
		LinkedHashSet<String> l = null;
		l = new LinkedHashSet<String>();
		
		l.add("AAA");
		l.add("BBB");
		l.add("CCC");
		l.add("BBB");
		
		System.out.println(l);
		
		ListOrderedSet l1 = new ListOrderedSet();
		

		l1.add("AAA");
		l1.add("BBB");
		l1.add("CCC");
		l1.add("BBB");
		
		System.out.println(l1);
		
	}
	public static void main1(String s[]) {
		List<TreatmentAllocation> list = new ArrayList<TreatmentAllocation>();
		list.add(new TreatmentAllocation(1,12));
		list.add(new TreatmentAllocation(1,34));
		list.add(new TreatmentAllocation(2,2));
		list.add(new TreatmentAllocation(2,9));
		list.add(new TreatmentAllocation(2,12));
		list.add(new TreatmentAllocation(3,25));
		list.add(new TreatmentAllocation(3,89));
		
		WeblabResult weblabResult = new WeblabResult(list);
		

		AbstractFilter filter3 = new SimpleWeightedFilter(new SimpleWeightedRequest(12), new SimpleWeightedRequest(34));
		
		AbstractFilter filter4 = new RangeWeightedFilter(new RangeWeightedRequest(12,65));
		AbstractFilter filter0 = new SimpleWeightedTreatmentFilter(new SimpleWeightedTreatmentRequest(Treatment.getTreatmentMode(1),12));
		AbstractFilter filter1 = new TreatmentFilter(new TreatmentRequest(Treatment.getTreatmentMode(1)));
		AbstractFilter filter2 =  new RangeWeightedTreatmentFilter(new RangeWeightedTreatmentRequest(Treatment.getTreatmentMode(1), 12, 65),
				   											new RangeWeightedTreatmentRequest(Treatment.getTreatmentMode(2), 0, 50));

		System.out.println("======= weight:12, T1=========");
		
		WeblabResult filteredResult = filter0.filter(weblabResult);
		System.out.print(filteredResult);
		
		System.out.println("======= T1 =========");
		
		filteredResult = filter1.filter(weblabResult);
		System.out.print(filteredResult)
		;

		System.out.println("======= weight:0-100, T1 =========");
		
		filteredResult = filter2.filter(weblabResult);
		System.out.print(filteredResult)
		;
		

		System.out.println("======= weight:12 | 34 =========");
		
		filteredResult = filter3.filter(weblabResult);
		System.out.print(filteredResult)
		;

		System.out.println("======= weight:12-65 =========");
		
		filteredResult = filter4.filter(weblabResult);
		System.out.print(filteredResult)
		;
		

		System.out.println("======= weight:T1 or 0-50  =========");
		
		AbstractFilter filter01 = new TreatmentFilter(new TreatmentRequest(Treatment.getTreatmentMode(1)));
		AbstractFilter filter02 = new RangeWeightedFilter(new RangeWeightedRequest(0, 50));
		
		filteredResult = filter02.filter(weblabResult, filter01);
		System.out.print(filteredResult);
	}
}
