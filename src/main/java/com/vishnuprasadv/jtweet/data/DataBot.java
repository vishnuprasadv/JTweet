package com.vishnuprasadv.jtweet.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author vishnuprasadv
 *
 */
public class DataBot {
	private String urlPrefix;

	public DataBot() {
	}

	/**
	 * Constructs a {@code DataBot} with specified URL prefix
	 * 
	 * @param urlPrefix
	 *            URL base value
	 */
	public DataBot(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	/**
	 * Retrieves response from the specified URL
	 * 
	 * @param urlSuffix
	 *            URL extension to be appended with the URL prefix
	 * @return Response String
	 * @throws IOException
	 *             on connection issues
	 */
	public String retrieveData(String urlSuffix) throws IOException {
		if (urlPrefix == null) {
			throw new IllegalArgumentException("urlPrefix isn't set.");
		}
		StringBuilder jsonData = new StringBuilder();
		URL url = new URL(urlPrefix + urlSuffix);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");

		// Twitter will not return anything unless we mimic some browser.
		// IE seems to be a good choice :P
		connection.setRequestProperty("User-Agent", "MSIE 10 /u/vishnuprasadv");
		if (connection.getResponseCode() != 200) {
			throw new IOException("Response doesn't indicate success. Received code : " + connection.getResponseCode());
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String str;
		while ((str = reader.readLine()) != null) {
			jsonData.append(str);
		}
		return jsonData.toString();

	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}
}
