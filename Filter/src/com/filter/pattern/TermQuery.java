package com.filter.pattern;

public class TermQuery implements IAnyQuery {

	String index;
	String value;
	public TermQuery(String string, String string2) {
		// TODO Auto-generated constructor stub
		index = string
				;
		value = string2;
		
	}

	public Query build() {
		// TODO Auto-generated method stub
		return new Query(index,value);
	}
}
