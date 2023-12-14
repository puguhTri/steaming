package com.evodia.imds.client.streamingclient.messages.data;

import lombok.Data;

@Data
public class UserResponseMessage {

    public UserResponseMessage(String username, Boolean isGranted) {
        this.username = username;
        this.isGranted = isGranted;
    }

    private String username;
    private Boolean isGranted;

}
