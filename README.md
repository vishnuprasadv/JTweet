# JTweet

Retrieves tweets of a specific user from Twitter in bulk.  

Twitter API limits the maximum number of tweets retrievable via API to a meagre 3200. This library bypasses this limit to retrieve entire tweets from a user.  

This library is really useful when you want to retrieve entire tweets of a user who has well more than 3200 tweets.  

No API keys, No login required.

## Usage

Clone this library and build it using `maven` build tool. 

```sh
git clone https://github.com/vishnuprasadv/JTweet.git
mvn install
```

* Add the resulting `.jar` file to your project `classpath`   
or
* Add this project as dependency in your project via `pom.xml`
```xml
<dependency>
  <groupId>com.vishnuprasadv</groupId>
  <artifactId>jtweet</artifactId>
  <version>0.0.1</version>
</dependency>
```

## How to use

Following code demonstrates a simple usage of this java library. It retrieves and prints the tweets of a twitter user with user handle `@Snowden`

```java
JTweet jtweet = new JTweet();
ArrayList<Tweet> tweets = jtweet.retrieveTweets("snowden", "2015-01-01", "2016-06-01");
```

### Under the hood

Since twitter API restricts the maximum number of tweets to 3200, this library mimics the method in which the twitter website retrieves the tweets.

### When not to use

This project is meant to retrieve tweets of users in bulk. If you are looking for getting only first few tweets or building a twitter client, you might be better of with some other libraries.

## How to contribute

You are welcome to contribute to this project by adding new features and fixing any issues.

### License

[MIT license](https://opensource.org/licenses/MIT).
