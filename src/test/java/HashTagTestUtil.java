import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by Youwei Chen on 6/25/2017.
 */
public class HashTagTestUtil {

    public static Random rand = new Random();
    public static String[] tags = {
        "#iHeartAwards", "#BestFanArmy", "#Harmonizers", "#Directioners", "#5SOSFam",
        "#KCA", "#gameinsight", "#android", "#androidgames", "#GOT7" };

    /**
     * Generate random tweets with 10% of tweet contain testing tags
     * @return
     */
    public static List<Tweet> generateRandomTweets (int numOfTweets) {
        IntStream.range(1, numOfTweets).mapToObj((x) -> new Tweet(generateRandomTweetTags(), generateRandomTweetText()));
        return null;
    }

    /**
     * generate a tweet with random text within 140 char length
     * @return
     */
    public static String generateRandomTweetText(){
        return "";
    }

    /**
     * Generate tags with 10% of tweet containt testing tags, tweet can contain multiple tags, it possible
     * a tweet match multiple testing tags
     * @return
     */
    public static Set<String> generateRandomTweetTags(){
        return null;
    }

    public static Tweet getSingleTweet(){
        Set<String> tag = new HashSet<>();
        tag.add("#iHeartAwards");
        return new Tweet(tag, "my test message");
    }
}
