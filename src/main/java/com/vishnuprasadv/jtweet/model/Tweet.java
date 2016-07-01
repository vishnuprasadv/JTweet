package com.vishnuprasadv.jtweet.model;

import java.util.Date;

/**
 * Tweet model class
 * 
 * @author vishnuprasadv
 *
 */
public class Tweet {

	private String tweetId;
	private String permaLink;
	private Date date;
	private String tweetText;
	private long retweetCount;
	private long favorites;
	private String mentions;
	private String hashTag;
	private String tweetGeo;
	private String userHandle;

	/**
	 * @return the tweetId
	 */
	public String getTweetId() {
		return tweetId;
	}

	/**
	 * 
	 */
	public Tweet() {
	}

	/**
	 * @param tweetId
	 *            the tweetId to set
	 */
	public void setTweetId(String tweetId) {
		this.tweetId = tweetId;
	}

	/**
	 * @return the permaLink
	 */
	public String getPermaLink() {
		return permaLink;
	}

	/**
	 * @param permaLink
	 *            the permaLink to set
	 */
	public void setPermaLink(String permaLink) {
		this.permaLink = permaLink;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the tweetText
	 */
	public String getTweetText() {
		return tweetText;
	}

	/**
	 * @param tweetText
	 *            the tweetText to set
	 */
	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	/**
	 * @return the retweetCount
	 */
	public long getRetweetCount() {
		return retweetCount;
	}

	/**
	 * @param retweetCount
	 *            the retweetCount to set
	 */
	public void setRetweetCount(long retweetCount) {
		this.retweetCount = retweetCount;
	}

	/**
	 * @return the favorites
	 */
	public long getFavorites() {
		return favorites;
	}

	/**
	 * @param favorites
	 *            the favorites to set
	 */
	public void setFavorites(long favorites) {
		this.favorites = favorites;
	}

	/**
	 * @return the mentions
	 */
	public String getMentions() {
		return mentions;
	}

	/**
	 * @param mentions
	 *            the mentions to set
	 */
	public void setMentions(String mentions) {
		this.mentions = mentions;
	}

	/**
	 * @return the hashTag
	 */
	public String getHashTag() {
		return hashTag;
	}

	/**
	 * @param hashTag
	 *            the hashTag to set
	 */
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	/**
	 * @return the tweetGeo
	 */
	public String getTweetGeo() {
		return tweetGeo;
	}

	/**
	 * @param tweetGeo
	 *            the tweetGeo to set
	 */
	public void setTweetGeo(String tweetGeo) {
		this.tweetGeo = tweetGeo;
	}

	/**
	 * @return the userHandle
	 */
	public String getUserHandle() {
		return userHandle;
	}

	/**
	 * @param userHandle
	 *            the userHandle to set
	 */
	public void setUserHandle(String userHandle) {
		this.userHandle = userHandle;
	}

}
