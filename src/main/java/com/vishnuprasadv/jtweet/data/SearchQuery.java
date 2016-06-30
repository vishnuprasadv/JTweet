package com.vishnuprasadv.jtweet.data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Vishnu Prasad
 *
 */
public final class SearchQuery {
	
	private String query;
	
	private String userName;
	private String fromDate;
	private String untilDate;
	private String searchTerm;
	
	private static final String SUFFIX = "src=typd&max_position=";
	

	public SearchQuery(){

	}

	public String buildSearchQuery() {
		try {
			return "?f=realtime&q=" + URLEncoder.encode(this.addParameter("from", this.userName)
					+ this.addParameter("since", this.fromDate) + this.addParameter("until", this.untilDate), "UTF-8")
					+ SearchQuery.SUFFIX;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String buildSearchQuery(String searchTerm) {
		try {
			return "?f=realtime&q="
					+ URLEncoder
							.encode(this.addParameter("from", this.userName) + this.addParameter("since", this.fromDate)
									+ this.addParameter("until", this.untilDate) + " " + searchTerm, "UTF-8")
					+ "&" + SearchQuery.SUFFIX;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param userName
	 * @param fromDate
	 * @param untilDate
	 */
	public SearchQuery(String userName, String fromDate, String untilDate) {
		this.userName = userName;
		this.fromDate = fromDate;
		this.untilDate = untilDate;
	}

	private String addParameter(String key, String value) {
		return this.query + "&" + key + ":" + value;
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
