package com.evodia.imds.client.streamingclient.messages.data;

import lombok.Data;

@Data
public class UserRequestMessage {

    private String username;
    private String password;

}
