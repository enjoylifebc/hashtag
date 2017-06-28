import java.util.Set;

/**
 * Created by Youwei Chen on 6/26/2017.
 */
public class HashTagClient {
    HashTagServer server = HashTagServer.getInstance();
    EndPointSubscriber subscriber;
    volatile boolean running = true;

    HashTagClient (EndPointSubscriber subscriber, Set<String> tags) {
        this.subscriber = subscriber;
        register(subscriber, tags);
    }

    public void register (EndPointSubscriber subscriber, Set<String> tags) {
        this.server.register(subscriber, tags);
    }

    public void deregister (EndPointSubscriber subscriber) {
        this.server.deregister(subscriber);
    }

    public void modifyRegistration (EndPointSubscriber subscriber, Set<String> tags) {
        this.server.modifyRegistration(subscriber, tags);
    }

    public void shutDown () {
        this.running = false;
    }
}
