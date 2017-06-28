import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Youwei Chen on 6/25/2017.
 */
public class HashTagClientTest {

    @Test
    public void testSubscriber () throws Exception {

        HashTagServer    server = HashTagServer.getInstance();
        ArrayList<Tweet> tweets = new ArrayList<>();
        Consumer<Tweet> tweetConsumer = (e) -> tweets.add(e);

        EndPointSubscriber subscriber = new EndPointSubscriber("SUBSCRIBER_1", tweetConsumer);
        Set<String>        tags       = new HashSet<>();
        tags.add("#iHeartAwards");
        HashTagClient client = new HashTagClient(subscriber, tags);
        client.register(subscriber, tags);


        EndPointSubscriber subscriber2 = new EndPointSubscriber("SUBSCRIBER_2", tweetConsumer);
        Set<String>        sub2tags    = new HashSet<>();
        sub2tags.add("#iHeartAwards");
        sub2tags.add("#BestFanArmy");
        HashTagClient client2 = new HashTagClient(subscriber2, sub2tags);
        client2.register(subscriber2, sub2tags);

        EndPointPublisher publisher = new EndPointPublisher();
        server.startPublisher(publisher);
        publisher.publish(HashTagTestUtil.getSingleTweet());

        Thread.sleep(100);
        Assert.assertEquals(2, tweets.size());
        // server.shutdownPublisher();
    }
}
