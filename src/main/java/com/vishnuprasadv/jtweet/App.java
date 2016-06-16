package com.vishnuprasadv.jtweet;

import com.vishnuprasadv.jtweet.data.DataBot;
import com.vishnuprasadv.jtweet.data.SearchQuery;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws Exception {
		System.setProperty("http.proxyHost", "proxy.cognizant.com");
		System.setProperty("http.proxyPort", "6050");
		System.setProperty("https.proxyHost", "proxy.cognizant.com");
		System.setProperty("https.proxyPort", "6050");
		System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1");
		System.setProperty("https.nonProxyHosts", "localhost|127.0.0.1");
		SearchQuery query = new SearchQuery("jonwestenberg", "2010-01-01", "2016-01-01");
		String queryString = query.buildSearchQuery();
		String json = new DataBot("https://twitter.com/i/search/timeline").retrieveData(queryString);
		System.out.println(json);
    }

}
