import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Youwei Chen on 6/26/2017. Server hash tag tweets
 */
public class HashTagTweets {

    final String hashTag;
    ArrayList<Tweet> tweets   = new ArrayList<>();
    Set<String>      endPoints = new HashSet<>();

    public HashTagTweets (String hashTag) {
        this.hashTag = hashTag;
    }

    public synchronized  void addTweets(Tweet tweet){
        tweets.add(tweet);
    }
}
