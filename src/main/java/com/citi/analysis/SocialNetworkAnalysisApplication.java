package com.citi.analysis;

import com.citi.analysis.helper.FriendshipMgmntHelper;
import com.citi.analysis.helper.UserMgmntHelper;
import com.citi.analysis.service.SocialNetworkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SocialNetworkAnalysisApplication {

    public static void main(String[] args) {

        SocialNetworkService network = new SocialNetworkService();
        UserMgmntHelper userMgmntHelper = new UserMgmntHelper();
        FriendshipMgmntHelper friendshipMgmntHelper = new FriendshipMgmntHelper();

        /*
        Below user mngmnt and friendship mgmnt code have been written such that the value can be added statically
        and using the controller as well
         */

        // User Management - UserMgmntController.java
        userMgmntHelper.addUser("1", "Alice", "alice@example.com");
        userMgmntHelper.addUser("2", "Bob", "bob@example.com");
        userMgmntHelper.addUser("3", "Charlie", "charlie@example.com");

        userMgmntHelper.listUsers();

        // Friendship Management - FriendshipMngmntController.java
        try {
            friendshipMgmntHelper.createFriendship("1", "2");
            friendshipMgmntHelper.createFriendship("2", "3");

            friendshipMgmntHelper.listFriends("1");
            friendshipMgmntHelper.listFriends("2");
        }catch (Exception e){
            log.error("Exception occurred while creating friends.");
        }


        // Find shortest path
        System.out.println("Shortest path from 1 to 3: " + network.findShortestPath("1", "3"));

        // Degree centrality
        System.out.println("Degree Centrality: " + network.calculateDegreeCentrality());

        // Identify communities
        System.out.println("Communities: " + network.identifyCommunities());

        // Remove a user and check remaining users
        userMgmntHelper.removeUser("2");
        userMgmntHelper.listUsers();
    }
}
