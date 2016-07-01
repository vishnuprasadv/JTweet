package com.vishnuprasadv.jtweet.data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.vishnuprasadv.jtweet.model.AttrConstant;

/**
 * @author vishnuprasadv
 *
 */
public final class SearchQuery {
	
	private String userName;
	private String fromDate;
	private String untilDate;
	private String searchTerm;
	
	/**
	 * URL suffix to be appended
	 */
	private static final String urlSuffix = "src=typd&max_position=";
	

	/**
	 * Creates a search query for data retrieval
	 * 
	 * @return Query string
	 */
	public String buildSearchQuery() {
		try {
			return "?f=realtime&q="
					+ URLEncoder.encode(this.addParameter(AttrConstant.tweetFrom, this.userName) + " "
							+ this.addParameter(AttrConstant.tweetSince, this.fromDate) + " "
							+ this.addParameter(AttrConstant.tweetUntil, this.untilDate), "UTF-8")
					+ "&" + SearchQuery.urlSuffix;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a search query for data retrieval along with the search term
	 * 
	 * @param searchTerm
	 *            search term to be included in the query
	 * @return Query string
	 */
	public String buildSearchQuery(String searchTerm) {
		try {
			return "?f=realtime&q="
					+ URLEncoder
							.encode(this.addParameter(AttrConstant.tweetFrom, this.userName) + " "
									+ this.addParameter(AttrConstant.tweetSince, this.fromDate) + " "
									+ this.addParameter(AttrConstant.tweetUntil, this.untilDate) + " " + searchTerm,
									"UTF-8")
					+ "&" + SearchQuery.urlSuffix;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Constructs a {@code SearchQuery} with given member values
	 * 
	 * @param userName
	 *            twitter user handle
	 * @param fromDate
	 *            from date {@code format: yyyy-mm-dd}
	 * @param untilDate
	 *            until date {@code format: yyyy-mm-dd}
	 */
	public SearchQuery(String userName, String fromDate, String untilDate) {
		this.userName = userName;
		this.fromDate = fromDate;
		this.untilDate = untilDate;
	}

	/**
	 * create a URL encoded parameter string with given key and value
	 * 
	 * @param key
	 *            key value
	 * @param value
	 *            value of the key
	 * @return URL encoded string
	 */
	private String addParameter(String key, String value) {
		return key + ":" + value;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate
	 *            the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the untilDate
	 */
	public String getUntilDate() {
		return untilDate;
	}

	/**
	 * @param untilDate
	 *            the untilDate to set
	 */
	public void setUntilDate(String untilDate) {
		this.untilDate = untilDate;
	}

	/**
	 * @return the searchTerm
	 */
	public String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * @param searchTerm
	 *            the searchTerm to set
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

}
