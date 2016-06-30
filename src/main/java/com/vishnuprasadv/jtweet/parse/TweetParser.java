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

public class TweetParser {

	public TweetParser() {

	}

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

	private Tweet buildTweet(Element element) {
		Tweet tweet = new Tweet();

		tweet.setTweetId(element.attr(AttrConstant.tweetID));
		tweet.setUserHandle(element.select(AttrConstant.tweetUserHandle).text());
		String tweetText = this.removeUnicode(element.select(AttrConstant.tweetText).text());
		tweet.setTweetText(tweetText);
		tweet.setPermaLink(element.attr(AttrConstant.tweetPermaLink));
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

	private String getMentions(String text) {
		StringBuilder sb = new StringBuilder();
		Matcher matcher = Pattern.compile("(@\\w*)").matcher(text);
		while (matcher.find()) {
			sb.append(matcher.group());
			sb.append(" ");
		}

		return sb.toString().trim();
	}

	private String getHashTags(String text) {
		StringBuilder sb = new StringBuilder();
		Matcher matcher = Pattern.compile("(#\\w*)").matcher(text);
		while (matcher.find()) {
			sb.append(matcher.group());
			sb.append(" ");
		}

		return sb.toString().trim();
	}

	private String removeUnicode(String input) {
		return input.replaceAll("[^\\u0000-\\uFFFF]", "");
	}
}
