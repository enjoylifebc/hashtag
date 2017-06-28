import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Youwei Chen on 6/27/2017.
 */
public class EndPointPublisher {
    public String endPoint;
    // each endpoint maintain a blocking queue
    public BlockingQueue<Tweet> queue = new ArrayBlockingQueue<>(5000);

    // on simple case like log tweet, we can use observer pattern to print endpoint and tweet to log
    // probably not what we want here
    public void publish (Tweet tweet) {
        queue.offer(tweet);
    }
}
