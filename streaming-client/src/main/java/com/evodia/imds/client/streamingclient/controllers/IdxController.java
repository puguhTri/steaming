package com.evodia.imds.client.streamingclient.controllers;


import com.evodia.imds.client.streamingclient.messages.data.UserRequestMessage;
import com.evodia.imds.client.streamingclient.messages.data.UserResponseMessage;
import com.evodia.imds.client.streamingclient.messages.handler.WebsocketSessionHolder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class IdxController {



    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponseMessage user(UserRequestMessage message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        String sessionId = headerAccessor.getSessionId();
        if (!message.getUsername().equals("puguh")){
            WebsocketSessionHolder.closeSessions(sessionId);
        }
        return new UserResponseMessage(message.getUsername(), true);
    }
}
