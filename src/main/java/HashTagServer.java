import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Youwei Chen on 6/26/2017.
 */
public class HashTagServer {

    // map of hashTag with end points
    Map<String, Set<EndPointSubscriber>> tagsToSubscribers = new HashMap<>();

    // map of endPoint to tags
    Map<EndPointSubscriber, Set<String>> subscribersToTagsMap = new HashMap<>();

    ExecutorService publisherPool = Executors.newFixedThreadPool(1);
    Object          lock          = new Object();

    public volatile boolean running = true;

    private static HashTagServer instance = new HashTagServer();

    static public HashTagServer getInstance () {
        return instance;
    }

    public void register (EndPointSubscriber endPoint, Set<String> tags) {
        synchronized (lock) {
            this.subscribersToTagsMap.put(endPoint, tags);
            if ( tags != null ) {
                for (String tag : tags) {
                    Set<EndPointSubscriber> subscribers = tagsToSubscribers.getOrDefault(tag, new HashSet<>());
                    subscribers.add(endPoint);
                    tagsToSubscribers.put(tag, subscribers);
                }
            }
        }
    }

    public void deregister (EndPointSubscriber endPoint) {
        synchronized (lock) {
            Set<String> tags = this.subscribersToTagsMap.get(endPoint);
            this.subscribersToTagsMap.remove(endPoint);
            for (String tag : tags) {
                this.tagsToSubscribers.get(tag).remove(endPoint);
            }
        }
    }


    // for simplicity sake, let make it a single publisher
    public void startPublisher (EndPointPublisher publisher) {
        this.publisherPool.execute(
            () -> {
                while ( running ) {
                    try {
                        Tweet tweet = publisher.queue.take();
                        onTweet(tweet);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        );
    }

    public void shutdownPublisher () {
        this.running = false;
        this.publisherPool.shutdownNow();
    }

    // when we receive a tweet
    // loop thru the subscribers, can call it onTweet method using simple oberserver pattern
    public synchronized void onTweet (Tweet tweet) {
        for (String tag : tweet.hashTags) {
            Set<EndPointSubscriber> subscribers = tagsToSubscribers.get(tag);
            if ( subscribers != null ) {
                for (EndPointSubscriber subscriber : subscribers) {
                    // subscriber.queue.offer(tweet);
                    subscriber.onTweet(tweet);
                }
            }
        }
    }

    public void modifyRegistration (EndPointSubscriber endPoint, Set<String> tags) {
        synchronized (lock) {
            deregister(endPoint);
            register(endPoint, tags);
        }
    }
}
