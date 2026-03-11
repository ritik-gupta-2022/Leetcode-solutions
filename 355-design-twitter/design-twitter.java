
class Twitter {

    Deque<int[]> tweets;
    HashMap<Integer, HashSet<Integer>> users;

    public Twitter() {
        tweets = new ArrayDeque<>();
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.addLast(new int[]{userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {

        HashSet<Integer> followees = users.containsKey(userId) ? users.get(userId) : new HashSet<>();

        followees.add(userId);

        List<Integer> list = new ArrayList<>();

        Iterator<int[]> it = tweets.descendingIterator();

        while(it.hasNext() && list.size() < 10){

            int[] t = it.next();

            if(followees.contains(t[0]))
                list.add(t[1]);
        }

        return list;
    }

    public void follow(int followerId, int followeeId) {

        HashSet<Integer> set = users.containsKey(followerId) ? users.get(followerId) : new HashSet<>();

        set.add(followeeId);

        users.put(followerId, set);
    }

    public void unfollow(int followerId, int followeeId) {

        if(!users.containsKey(followerId)) return;

        users.get(followerId).remove(followeeId);
    }
}