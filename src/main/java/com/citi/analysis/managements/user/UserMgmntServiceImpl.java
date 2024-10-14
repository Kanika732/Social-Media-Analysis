package com.citi.analysis.managements.user;

import com.citi.analysis.dto.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.citi.analysis.service.SocialNetworkService.friendships;
import static com.citi.analysis.service.SocialNetworkService.users;

@Component
public class UserMgmntServiceImpl implements UserMgmntService {


    /*
     Adding user in the static user's map and with empty friends wrt to that user.
     This can also be saved in the DB by adding a repo layer.
     Many to Many relationship is created among users.
   */
    public void addUser(String userId, String name, String email) {
        User user = new User(userId, name, email);
        users.put(userId, user);
        friendships.put(userId, new HashSet<>());
    }




    /*
    Removing user from user map and as well as from the friendships map.
    Also removing the user if he user exists as friend(value in the map)
    */
    public void removeUser(String userId) {
        users.remove(userId);
        friendships.remove(userId);
        for (Set<String> friends : friendships.values()) {
            friends.remove(userId);
        }
    }



    public void listUsers() {
        for (User user : users.values()) {
            System.out.println(user.getUserId() + ": " + user.getName() + " (" + user.getEmail() + ")");
        }
    }

}
