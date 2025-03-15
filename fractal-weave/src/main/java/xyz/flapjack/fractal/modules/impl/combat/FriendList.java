package xyz.flapjack.fractal.modules.impl.combat;

import java.util.ArrayList;

public class FriendList {
    private static final String path = "license/friends.txt";
    private static final ArrayList<String> friends = new ArrayList<>();

    public void addFriendToList(String name){
        friends.add(name);
    }

    public void removeFriendFromList(String name){
        friends.remove(name);
    }

    public void loadFriends(String path){


        path = System.getenv("appdata") + "/.minecraft";

//        Load friend list file, from path
        for (String friend : friends) {
            friends.add(friend);
        }
    }

    public String getAllFriends() {
        for (String friend : friends) {
            return friend;
        }
        return null;
    }

}
