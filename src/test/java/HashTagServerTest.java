import org.junit.Test;

/**
 * Created by Youwei Chen on 6/25/2017.
 */
public class HashTagServerTest {

    @Test
    public void testPublisher(){
        EndPointPublisher publisher = new EndPointPublisher();
        HashTagServer server = HashTagServer.getInstance();
        server.startPublisher(publisher);
        publisher.publish(HashTagTestUtil.getSingleTweet());
        server.shutdownPublisher();
    }

}
