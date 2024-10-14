package com.citi.analysis.controller;

import com.citi.analysis.dto.CreateFriendshipRequest;
import com.citi.analysis.helper.FriendshipMgmntHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController(value = "v1/friend")
public class FriendshipMngmntController {

    @Autowired
    private FriendshipMgmntHelper friendshipMgmntHelper;

    /*
    This controller creates user in the static map
     */
    @PostMapping(path = "/create/friend")
    public String createFriendship(@RequestBody CreateFriendshipRequest request,
                          HttpServletRequest servletRequest,
                          HttpServletResponse response) {
        friendshipMgmntHelper.createFriendship(request.getFirstFriendUserId(), request.getSecondFriendUserId());
        return HttpStatus.OK.getReasonPhrase();
    }

    /*
   This controller will list down the user from the static map
    */
    @GetMapping(path = "/list/friend")
    public String listFriends(@PathVariable String userId) {
        friendshipMgmntHelper.listFriends(userId);
        return HttpStatus.OK.getReasonPhrase();
    }

    /*
   This controller remove the user from the static map
    */
    @PostMapping(path = "/remove/friend")
    public String removeFriendship(@RequestParam String userId, @RequestParam String userId2) {
        friendshipMgmntHelper.removeFriendship(userId, userId2);
        return HttpStatus.OK.getReasonPhrase();
    }
}
