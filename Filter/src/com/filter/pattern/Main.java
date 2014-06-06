package com.filter.pattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String s[]) {
		List<TreatmentAllocation> list = new ArrayList<TreatmentAllocation>();
		list.add(new TreatmentAllocation(1,12));
		list.add(new TreatmentAllocation(1,34));
		list.add(new TreatmentAllocation(2,2));
		list.add(new TreatmentAllocation(2,9));
		list.add(new TreatmentAllocation(2,12));
		list.add(new TreatmentAllocation(3,25));
		list.add(new TreatmentAllocation(3,89));
		
		WeblabResult weblabResult = new WeblabResult(list);
		

		IFilter filter3 = new SimpleWeightedFilter(12);
		IFilter filter4 = new RangeWeightedFilter(12,65);
		IFilter filter0 = new SimpleWeightedTreatmentFilter(Treatment.getTreatmentMode(1),12);
		IFilter filter1 = new TreatmentFilter(Treatment.getTreatmentMode(1));
		IFilter filter2 = new RangeWeightedTreatmentFilter(Treatment.getTreatmentMode(1), 0, 100);
		

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
		

		System.out.println("======= weight:12 =========");
		
		filteredResult = filter3.filter(weblabResult);
		System.out.print(filteredResult)
		;

		System.out.println("======= weight:12-65 =========");
		
		filteredResult = filter4.filter(weblabResult);
		System.out.print(filteredResult)
		;
		
	}
}
