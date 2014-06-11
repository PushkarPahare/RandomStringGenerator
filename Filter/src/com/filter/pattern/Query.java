package com.filter.pattern;

import java.util.ArrayList;
import java.util.List;

public class Query {
	private static final String SEPARATOR = " : ";
	private static final Object OR = " OR ";
	private static final Object AND = " AND ";
	private StringBuilder query;

	public Query(String index, String value) {
		query = new StringBuilder();
		query.append(index).append(SEPARATOR).append(value);
	}

	public Query(Query build) {
		this.query = new StringBuilder(build.toString());
	}

	public Query and(Query query) {
		this.query.append(AND).append(query.toString());
		return this;
	}

	public Query or(Query query) {
		this.query.append(OR).append(query.toString());
		return this;
	}

	public String toString() {
		return "(" + this.query.toString() + ")";
	}

	public static void main(String s[]) {
		Query query = null;
		List<IAnyQuery> queryObjectList = new ArrayList<IAnyQuery>();
		queryObjectList.add(new TermQuery("x", "x1"));
		queryObjectList.add(new TermQuery("y", "y1"));
		queryObjectList.add(new TermQuery("z", "z1"));

		for (IAnyQuery queryObject : queryObjectList) {

			if (query == null) {
				query = new Query(queryObject.build());

			} else {

				query = query.or(queryObject.build());

			}

		}

		queryObjectList = new ArrayList<IAnyQuery>();
		queryObjectList.add(new TermQuery("a", "a1"));
		queryObjectList.add(new TermQuery("b", "b1"));
		queryObjectList.add(new TermQuery("c", "c1"));

		for (IAnyQuery queryObject : queryObjectList) {

			if (query == null) {
				query = new Query(queryObject.build());

			} else {

				query = query.and(queryObject.build());

			}

		}

		System.out.println(query);
	}
}
