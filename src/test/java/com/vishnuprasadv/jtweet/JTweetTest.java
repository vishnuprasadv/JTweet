package com.vishnuprasadv.jtweet;

import java.io.IOException;
import java.util.ArrayList;

import com.vishnuprasadv.jtweet.model.Tweet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for JTweet.
 */
public class JTweetTest
    extends TestCase
{
    /**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public JTweetTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
		return new TestSuite(JTweetTest.class);
    }

    /**
	 * Test the functionality
	 */
    public void testApp()
    {
		JTweet retrieve = new JTweet();
		try {
			ArrayList<Tweet> tweets = retrieve.retrieveTweets("jonwestenberg", "2015-12-01", "2016-01-01");
			assertFalse(tweets.isEmpty());
			for (Tweet tweet : tweets) {
				System.out.println(tweet.getTweetText());
			}
		} catch (IOException e) {
			fail(e.toString());
			e.printStackTrace();
		}
        assertTrue( true );
    }
}
