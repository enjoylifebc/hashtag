/**
 * Created by Youwei Chen on 6/26/2017.
 */
public interface Partitioner {
    // we can process tags in several nodes in parallel
    int getHostId(String hashTag);
}
