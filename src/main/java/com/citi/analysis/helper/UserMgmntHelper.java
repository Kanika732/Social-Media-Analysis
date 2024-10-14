package com.citi.analysis.helper;

import com.citi.analysis.managements.user.UserMgmntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMgmntHelper {

     /*
        This is a helper for all the conversion of DTOs and interactions between the service and controller
     */

    @Autowired
    private UserMgmntService userMgmntService;

    public void addUser(String userId, String name, String email){
        userMgmntService.addUser(userId, name, email);
    }

    public void listUsers() {
        userMgmntService.listUsers();
    }

    public void removeUser(String userId) {
        userMgmntService.removeUser(userId);
    }
}
