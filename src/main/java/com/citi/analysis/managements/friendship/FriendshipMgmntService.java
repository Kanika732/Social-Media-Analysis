package com.citi.analysis.managements.friendship;

import com.citi.analysis.exception.UserMgmtException;

public interface FriendshipMgmntService {

    void createFriendship(String userId1, String userId2) throws UserMgmtException;

    void removeFriendship(String userId1, String userId2) throws UserMgmtException;

    void listFriends(String userId) ;
}
