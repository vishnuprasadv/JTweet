package com.vishnuprasadv.jtweet.parse;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.vishnuprasadv.jtweet.model.AttrConstant;
import com.vishnuprasadv.jtweet.model.Tweet;

/**
 * Tweet Parser class
 * 
 * @author vishnuprasadv
 *
 */
public class TweetParser {

	/**
	 * Default constructor
	 */
	public TweetParser() {

	}

	/**
	 * Parses the response from twitter API to create {@code Tweet} objects
	 * 
	 * @param htmlData
	 *            twitter APi response string
	 * @return List of {@code Tweet} objects
	 */
	public ArrayList<Tweet> parseTweets(String htmlData) {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();

		Document document = Jsoup.parse(htmlData);
		Elements elements = document.select(AttrConstant.tweetStream);

		if (elements.isEmpty()) {
			return null;
		}

		for (Element element : elements) {
			tweets.add(this.buildTweet(element));
		}

		return tweets;
	}

	/**
	 * Creates a {@code Tweet} object from the {@code Element}
	 * 
	 * @param element
	 *            Jsoup Element
	 * @return {@code Tweet} object
	 */
	private Tweet buildTweet(Element element) {
		Tweet tweet = new Tweet();

		tweet.setTweetId(element.attr(AttrConstant.tweetID));
		tweet.setUserHandle(element.select(AttrConstant.tweetUserHandle).text());
		String tweetText = this.removeUnicode(element.select(AttrConstant.tweetText).text());
		tweet.setTweetText(tweetText);
		tweet.setPermaLink(AttrConstant.twitterUrl + element.attr(AttrConstant.tweetPermaLink));
		long retweet = Long.parseLong(
				element.select(AttrConstant.tweetRetweet).attr(AttrConstant.tweetStatCount).replaceAll(",", ""));
		tweet.setRetweetCount(retweet);
		long favorites = Long
				.parseLong(element.select(AttrConstant.tweetFavorite).attr(AttrConstant.tweetStatCount).replaceAll(",",
						""));
		tweet.setFavorites(favorites);
		long milliseconds = Long.parseLong(element.select(AttrConstant.tweetDate).attr(AttrConstant.tweetMills));
		tweet.setDate(new Date(milliseconds));

		tweet.setMentions(this.getMentions(tweetText));
		tweet.setHashTag(this.getHashTags(tweetText));

		Elements geos = element.select(AttrConstant.tweetGeo);
		if (geos.isEmpty() == false) {
			tweet.setTweetGeo(geos.attr(AttrConstant.tweetGeoTitle));
		}

		return tweet;
	}

	/**
	 * Retrieves the mentions in a tweet text
	 * 
	 * @param text
	 *            Tweet content
	 * @return Mentions
	 */
	private String getMentions(String text) {
		StringBuilder sb = new StringBuilder();
		Matcher matcher = Pattern.compile("(@\\w*)").matcher(text);
		while (matcher.find()) {
			sb.append(matcher.group());
			sb.append(" ");
		}

		return sb.toString().trim();
	}

	/**
	 * Retrieves the hash tags in a tweet text
	 * 
	 * @param text
	 *            Tweet content
	 * @return hash tags
	 */
	private String getHashTags(String text) {
		StringBuilder sb = new StringBuilder();
		Matcher matcher = Pattern.compile("(#\\w*)").matcher(text);
		while (matcher.find()) {
			sb.append(matcher.group());
			sb.append(" ");
		}

		return sb.toString().trim();
	}

	/**
	 * Removes the unicode characters from the tweet text
	 * 
	 * @param input
	 *            tweet text
	 * @return Normalized text
	 */
	private String removeUnicode(String input) {
		return input.replaceAll("[^\\u0000-\\uFFFF]", "");
	}
}
