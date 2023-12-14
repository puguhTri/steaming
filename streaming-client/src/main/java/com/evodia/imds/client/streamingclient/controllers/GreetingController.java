package com.evodia.imds.client.streamingclient.controllers;

import com.evodia.imds.client.streamingclient.messages.Greeting;
import com.evodia.imds.client.streamingclient.messages.HelloMessage;
import com.evodia.imds.client.streamingclient.messages.handler.WebsocketSessionHolder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/test")
    public Greeting greeting(HelloMessage message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
        Thread.sleep(1000); // simulated delay
        String sessionId = headerAccessor.getSessionId();
        if (!message.getName().equals("puguh")){
            WebsocketSessionHolder.closeSessions(sessionId);
        }
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
