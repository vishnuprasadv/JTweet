package com.vishnuprasadv.jtweet;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import com.vishnuprasadv.jtweet.data.DataBot;
import com.vishnuprasadv.jtweet.data.SearchQuery;
import com.vishnuprasadv.jtweet.model.AttrConstant;
import com.vishnuprasadv.jtweet.model.Tweet;
import com.vishnuprasadv.jtweet.parse.TweetParser;

/**
 * @author vishnuprasadv
 *
 */
public class JTweet {

	/***
	 * Constructs an object of {@code JTweet}
	 */
	public JTweet() {

	}


	/**
	 * twitter API search suffix
	 */
	private static final String urlPrefix = "https://twitter.com/i/search/timeline";

	private String searchQuery = null;

	/**
	 * Retrieves the tweets for the specified user
	 * 
	 * @param userName
	 *            twitter user handle
	 * @param from
	 *            from date {@code format : yyyy-mm-dd}
	 * @param until
	 *            until date {@code format : yyyy-mm-dd}
	 * @return List of tweets
	 * @throws IOException
	 *             on connection issues
	 */
	public ArrayList<Tweet> retrieveTweets(String userName, String from, String until) throws IOException {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		String pagination = null;
		TweetParser parser = new TweetParser();
		this.searchQuery = new SearchQuery(userName,from,until).buildSearchQuery();
		if (this.searchQuery == null) {
			return null;
		}
		// Following replacement is needed because UrlEncoder can't encode worth
		// a s***
		searchQuery = searchQuery.replaceAll("\\+", "%20");

		DataBot bot = new DataBot(JTweet.urlPrefix);
		String json = bot.retrieveData(searchQuery);
		JSONObject result = new JSONObject(json);
		pagination = result.getString(AttrConstant.tweetPagination);
		while (true) {
			String itemsHtml = result.getString(AttrConstant.tweetItems);
			ArrayList<Tweet> currentList = parser.parseTweets(itemsHtml);
			if (currentList == null || currentList.isEmpty())
				break;
			tweets.addAll(currentList);
			json = bot.retrieveData(searchQuery + pagination);
			result = new JSONObject(json);
			pagination = result.getString(AttrConstant.tweetPagination);
		}
		return tweets;
	}
}
