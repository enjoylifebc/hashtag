import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

/**
 * Created by Youwei Chen on 6/27/2017.
 */
public class EndPointSubscriber {
    Consumer<Tweet> tweetConsumer;
    public EndPointSubscriber(String endPoint, Consumer<Tweet> tweetConsuemr){
        this.endPoint = endPoint;
        this.tweetConsumer = tweetConsuemr;
    }

    public String endPoint;

    // we can use a blockingqueue to represent client, all tweet for this client
    // will be pushed to blockingqueue
    public BlockingQueue<Tweet> queue = new ArrayBlockingQueue<>(5000);

    // a very simple implementation that use observer pattern
    // we can pass in a consumer to make how to consumer tweet more generic
    // ex: consumer can save to file, or collect and verify data when run test
    public void onTweet (Tweet tweet) {
        tweetConsumer.accept(tweet);
    }
}
