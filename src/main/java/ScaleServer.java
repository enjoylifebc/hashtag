import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Youwei Chen on 6/29/2017.
 *
 * Server handle: - subscriber connectivity; keep track of subscriber offset; coordinate with nodes to return data
 */
public class ScaleServer {


    // given a partition, find corresponding node to handle the parition
    Map<Partition, ScaleNode> partitionToNodeMap = new HashMap<>();
    int numberOfNode;

    // keep track of set of connections to client
    Set<ScaleConnection> connetions;

    // track client offset as it consume messages from queue
    Map<EndPointSubscriber, Integer> subscriberOffsetTracker = new ConcurrentHashMap<>();

    // Aggregate data and send to subscribers
    Map<EndPointSubscriber, BlockingQueue> subscriberData = new ConcurrentHashMap<>();

    public ScaleServer (int numberOfNode) {
        this.numberOfNode = numberOfNode;
        this.connetions = new HashSet<>();
    }

    public void register (EndPointSubscriber endPoint, Set<String> tags) {
    }

    public void deregister (EndPointSubscriber endPoint) {
    }

    // Given a tag, hash it to one of node in the cluster
    public Partition getPartition (String tag) {
        return new Partition(tag.hashCode() % numberOfNode);
    }
}
