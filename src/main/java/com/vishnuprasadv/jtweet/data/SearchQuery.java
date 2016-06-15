package com.vishnuprasadv.jtweet.data;

/**
 * @author Vishnu Prasad
 *
 */
public final class SearchQuery {
	
	private String query;
	
	public SearchQuery(){
		query = "";
	}

	public SearchQuery addParameter(String key, String value) {
		this.query = this.query + "&" + key + ":" + value;
		return this;
	}


	/**
	 * @return the uri
	 */
	public String getUri() {
		return "?" + query;
	}

}
