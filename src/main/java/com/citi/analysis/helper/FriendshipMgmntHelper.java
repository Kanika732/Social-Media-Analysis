package com.citi.analysis.helper;

import com.citi.analysis.exception.UserMgmtException;
import com.citi.analysis.managements.friendship.FriendshipMgmntService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FriendshipMgmntHelper {

    @Autowired
    private FriendshipMgmntService friendshipMgmntService;

    @SneakyThrows
    public void createFriendship(String userId1, String userId2)  {
        friendshipMgmntService.createFriendship(userId1, userId2);
    }

    public void listFriends(String userId) {
        friendshipMgmntService.listFriends(userId);
    }


    @SneakyThrows
    public void removeFriendship(String userId1, String userId2)  {
        friendshipMgmntService.removeFriendship(userId1, userId2);
    }
}
