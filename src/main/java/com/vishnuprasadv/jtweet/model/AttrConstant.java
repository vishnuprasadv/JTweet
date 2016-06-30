package com.vishnuprasadv.jtweet.model;

public interface AttrConstant {
	String tweetID = "data-tweet-id";
	String tweetUserHandle = "span.username.js-action-profile-name b";
	String tweetText = "p.js-tweet-text";
	String tweetPermaLink = "data-permalink-path";
	String tweetRetweet = "span.ProfileTweet-action--retweet span.ProfileTweet-actionCount";
	String tweetStatCount = "data-tweet-stat-count";
	String tweetFavorite = "span.ProfileTweet-action--favorite span.ProfileTweet-actionCount";
	String tweetDate = "small.time span.js-short-timestamp";
	String tweetMills = "data-time-ms";
	String tweetGeo = "span.Tweet-geo";
	String tweetGeoTitle = "title";
	String tweetStream = "div.js-stream-tweet";
}
