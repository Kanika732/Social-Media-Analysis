package com.citi.analysis.managements.user;

public interface UserMgmntService {

    void addUser(String userId, String name, String email);

    void removeUser(String userId) ;

    void listUsers() ;

}
