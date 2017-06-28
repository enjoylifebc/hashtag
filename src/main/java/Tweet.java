import java.util.Set;

/**
 * Created by Youwei Chen on 6/25/2017.
 */
public class Tweet {
    public Set<String> hashTags;
    public String tweet;
    public Tweet(Set<String> hashTags, String tweet){
        this.hashTags = hashTags;
        this.tweet = tweet;
    }
}
