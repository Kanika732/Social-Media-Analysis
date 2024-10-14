package com.citi.analysis.dto;

import lombok.Data;

@Data
public class CreateFriendshipRequest {

    private String firstFriendUserId;
    private String secondFriendUserId;
}
