import java.util.List;
import java.util.Map;

/**
 * Created by Youwei Chen on 6/29/2017.
 *
 * Connection between node and server. Server send tweets to node, and receive subscriber data from each node
 */
public class ScaleConnection {

    public ScaleConnection () {

    }

    // publisher will send all tweets to node responsible for node
    // tweet can have multiple tags, how can we solve this effectively?
    public void sendTweetToNode (ScaleNode node, Tweet[] tweets) {
        // serialize data
    }


    // each node is responsible to handle a set of hashtag / subscription
    // after it receive tweets, it send all hashtag match subscription to server
    public Map<EndPointSubscriber, List<Tweet>> receiveSubscriberTweets (byte[] serializedData) {
        return null;
    }

}
