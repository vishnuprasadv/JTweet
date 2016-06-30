package com.vishnuprasadv.jtweet.data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SearchQueryTest extends TestCase {

	public SearchQueryTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SearchQueryTest.class);
	}

	public void testBuildQuery() {
		String exp = "?f=realtime&q=from%3Ahello%20since%3A2015-01-01%20until%3A2016-01-01&src=typd&max_position=";
		SearchQuery query = new SearchQuery("hello", "2015-01-01", "2016-01-01");
		String result = query.buildSearchQuery();
		result = result.replaceAll("\\+", "%20");
		assertTrue(result.equals(exp));

	}

}
