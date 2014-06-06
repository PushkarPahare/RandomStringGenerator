package com.filter.pattern;

public abstract class AbstractFilter {
	abstract WeblabResult filter(WeblabResult weblabs);

	public WeblabResult filter(WeblabResult weblabs, AbstractFilter filter) {
		WeblabResult outWeblabs = this.filter(weblabs);
		if(filter != null)
			return filter.filter((outWeblabs));
		else
			return (outWeblabs);
	}
}
