package m.infrastructure;

import java.util.ArrayList;
import java.util.List;

import m.domain.tweet.Tweet;
import m.domain.user.User;

/**
 * wee on 11/30/13.
 */
public class SampleData {

    public static final List<User> list = new ArrayList<User>();
    
    public static final List<Tweet> twList = new ArrayList<Tweet>();

    public static final User currentUser = new User("cherry");

    static {
        addUserRecursively(list, "james", 20);
        addUserRecursively(list, "cindy", 40);
        addUserRecursively(list, "bob", 23);
        addUserRecursively(list, "tom", 70);

        addFollower(20L, 23L, 50L, 2L, 90L, 120L);
        addFollowee(22L, 29L, 50L, 3L, 98L, 129L);
        
        addTweets(twList,"é����","������ǣ��൱���������ˮ������100Ԫ�ĳ�Ʊֻ����ģ������á��ұȽϹ����������Ʊ����Ӣ������ŷ���գ��ӣ��ۣ�̨�ȵȣ����ҹ������Ϊ��͡���Ҷ���500Ԫ��Ʊ������֮���Գٳٲ����У��Ҳ�����ë�󶫵���Ҫ��Ҫӡ��ȥ�������йء�������һ������ͶƱ���Կ�������һ�����ڵ�������Ρ�");
        addTweets(twList,"�й��黭����","�ͫ| ī�� �����鷨�����У���Ʒ����Ʒ��һ��Ѫ�����������壬��Ʒ����������Ʒ����ν���˷��֡���ʵ�ͫ|���вŻ����������ˣ�����Ȩ�������鷨��ʫ�����нϸ����裬�����ֺ�Ǭ¡���Ƶ����Լ�����ĵز���");
        addTweets(twList,"2é����","2������ǣ��൱���������ˮ������100Ԫ�ĳ�Ʊֻ����ģ������á��ұȽϹ����������Ʊ����Ӣ������ŷ���գ��ӣ��ۣ�̨�ȵȣ����ҹ������Ϊ��͡���Ҷ���500Ԫ��Ʊ������֮���Գٳٲ����У��Ҳ�����ë�󶫵���Ҫ��Ҫӡ��ȥ�������йء�������һ������ͶƱ���Կ�������һ�����ڵ�������Ρ�");
        addTweets(twList,"2�й��黭����","2�ͫ| ī�� �����鷨�����У���Ʒ����Ʒ��һ��Ѫ�����������壬��Ʒ����������Ʒ����ν���˷��֡���ʵ�ͫ|���вŻ����������ˣ�����Ȩ�������鷨��ʫ�����нϸ����裬�����ֺ�Ǭ¡���Ƶ����Լ�����ĵز���");
    }

    private static void addFollower(Long... userIds) {
        for (Long id : userIds) {
            currentUser.addFollower(list.get(id.intValue()));
        }
    }

    private static void addFollowee(Long... userIds) {
        for (Long id : userIds) {
            currentUser.addFollowee(list.get(id.intValue()+1));
        }
    }

    private static void addUserRecursively(List<User> users, String name, int times) {

        for (int i = 0; i < times; i++) {
            final User user = new User(name + Integer.toString(i + 1));
            user.setName(name + user.getId());
            user.setNickName(name + "nickname");
            users.add(user);
        }
    }
    
    private static void addTweets(List<Tweet> tweets, String username, String content){
    	final Tweet tweet = new Tweet();
    	tweet.setUserName(username);
    	tweet.setContent(content);
    	tweets.add(tweet);
    }
}
