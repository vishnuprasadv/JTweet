package com.vishnuprasadv.jtweet.data;

import java.io.UnsupportedEncodingException;

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
		String exp = "?f=realtime&q=null%26from%3Ahellonull%26since%3A2015-01-01null%26until%3A2016-01-01src=typd&max_position=";
		SearchQuery query = new SearchQuery("hello", "2015-01-01", "2016-01-01");
		try {
			String result = query.buildSearchQuery();
			assertTrue(result.equals(exp));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
