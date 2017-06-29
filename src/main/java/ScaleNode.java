import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Youwei Chen on 6/29/2017.
 *
 * Node will handle a parition of data: process incomding data
 */
public class ScaleNode {

    // on each node, maintain
    Map<String, Set<EndPointSubscriber>> tagToSubscriberMap = new ConcurrentHashMap<>();

    public ScaleNode () {
    }

    // register subscriber to tag mapping
    public void register (EndPointSubscriber endPoint, Set<String> tags) {
    }

    // describer client to tag mapping
    public void deregister (EndPointSubscriber endPoint) {
    }

    // modify subscription for tags handled by this node
    public void modifyRegistration(EndPointSubscriber endPoint, Set<String> tags) {
    }

    // on receiving tweets, loop thru subscriber map, and push all matching data back to server
    public void onTweets(Tweet[] tweets){
    }
}
