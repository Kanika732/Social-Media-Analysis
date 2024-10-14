package com.citi.analysis.controller;


import com.citi.analysis.dto.CreateUserRequest;
import com.citi.analysis.helper.UserMgmntHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/v1/user")
public class UserMgmntController {

    @Autowired
    private UserMgmntHelper userMgmntHelper;

    /*
    This controller creates user in the static map
     */
    @PostMapping(path = "/create/user")
    public String addUser(@RequestBody CreateUserRequest request,
                                                HttpServletRequest servletRequest,
                                                HttpServletResponse response) {
        userMgmntHelper.addUser(request.getUserId(), request.getName(), request.getEmail());
        return HttpStatus.OK.getReasonPhrase();
    }

    /*
   This controller will list down the user from the static map
    */
    @GetMapping(path = "/list/user")
    public String listUser() {
        userMgmntHelper.listUsers();
        return HttpStatus.OK.getReasonPhrase();
    }

    /*
   This controller remove the user from the static map
    */
    @PostMapping(path = "/remove/user/{userId}")
    public String removeUser(@PathVariable String userId) {
        userMgmntHelper.removeUser(userId);
        return HttpStatus.OK.getReasonPhrase();
    }
}
