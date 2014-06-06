package com.filter.pattern;

public class Treatment {
	int name;
	TreatmentMode type;
	
	private Treatment(TreatmentMode treatment, int i) {
		// TODO Auto-generated constructor stub
		this.name = i;
		this.type = treatment;
	}

	private Treatment(TreatmentMode control) {
		// TODO Auto-generated constructor stub
		this.type = control;
	}

	public static Treatment getTreatmentMode(int i) {
		return new Treatment(TreatmentMode.TREATMENT, i);
	}
	
	public static Treatment getControlMode() {
		return new Treatment(TreatmentMode.CONTROL);
	}
}

enum TreatmentMode {
	TREATMENT, CONTROL;
}
