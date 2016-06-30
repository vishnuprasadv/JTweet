package com.vishnuprasadv.jtweet;

import java.util.ArrayList;

import com.vishnuprasadv.jtweet.model.Tweet;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws Exception {
		JTweet retrieve = new JTweet();
		ArrayList<Tweet> tweets = retrieve.retrieveTweets("jonwestenberg", "2015-12-01", "2016-01-01");
		System.out.println(tweets.size());
		System.out.println("done");
    }

}
