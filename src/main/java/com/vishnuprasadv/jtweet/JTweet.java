package com.vishnuprasadv.jtweet;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONObject;

import com.vishnuprasadv.jtweet.data.DataBot;
import com.vishnuprasadv.jtweet.data.SearchQuery;
import com.vishnuprasadv.jtweet.model.Tweet;
import com.vishnuprasadv.jtweet.parse.TweetParser;

public class JTweet {

	public JTweet() {

	}

	public static final String urlPrefix = "https://twitter.com/i/search/timeline";

	public String searchQuery = null;

	public ArrayList<Tweet> retrieveTweets(String userName, String from, String until) throws IOException {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		String pagination = null;
		TweetParser parser = new TweetParser();
		this.searchQuery = new SearchQuery(userName,from,until).buildSearchQuery();
		if (this.searchQuery == null) {
			return null;
		}
		searchQuery = searchQuery.replaceAll("\\+", "%20");
		DataBot bot = new DataBot(JTweet.urlPrefix);
		String json = bot.retrieveData(searchQuery);
		JSONObject result = new JSONObject(json);
		pagination = result.getString("min_position");
		while (true) {
			String itemsHtml = result.getString("items_html");
			ArrayList<Tweet> currentList = parser.parseTweets(itemsHtml);
			if (currentList == null || currentList.isEmpty())
				break;
			tweets.addAll(currentList);
			json = bot.retrieveData(searchQuery + pagination);
			result = new JSONObject(json);
			pagination = result.getString("min_position");
		}
		return tweets;
	}
}
