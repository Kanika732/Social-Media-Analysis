package com.citi.analysis.managements.friendship;

import com.citi.analysis.exception.UserMgmtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static com.citi.analysis.service.SocialNetworkService.friendships;
import static com.citi.analysis.service.SocialNetworkService.users;

@Slf4j
@Component
public class FriendshipMgmntServiceImpl implements FriendshipMgmntService {


    @Override
    public void createFriendship(String userId1, String userId2) throws UserMgmtException {
        if (users.containsKey(userId1) && users.containsKey(userId2)) {
            friendships.get(userId1).add(userId2);
            friendships.get(userId2).add(userId1);
        }
        else {
            log.error("FriendshipMgmntServiceImpl | createFriendship | Users do not exist ");
            throw new UserMgmtException(HttpStatus.BAD_REQUEST.value(), "Users does not exist");
        }
    }

    @Override
    public void removeFriendship(String userId1, String userId2) throws UserMgmtException {
        if (friendships.containsKey(userId1) && friendships.containsKey(userId2)) {
            friendships.get(userId1).remove(userId2);
            friendships.get(userId2).remove(userId1);
        }
        else {
            log.error("FriendshipMgmntServiceImpl | removeFriendship | Users do not exist ");
            throw new UserMgmtException(HttpStatus.BAD_REQUEST.value(), "Users does not exist");
        }
    }

    @Override
    public void listFriends(String userId) {
        if (friendships.containsKey(userId)) {
            System.out.println("Friends of " + userId + ": " + friendships.get(userId));
        }
    }
}
