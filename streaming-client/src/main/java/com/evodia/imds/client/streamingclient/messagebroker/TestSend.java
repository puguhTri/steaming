package com.evodia.imds.client.streamingclient.messagebroker;

import com.evodia.imds.client.streamingclient.messages.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


//@EnableScheduling
@Service
public class TestSend {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    //@Scheduled(fixedDelay = 3000)
    public void testSend(){
        System.out.println("scheduler");
       simpMessagingTemplate.convertAndSend("/topic/test", new Greeting("dari scheduler"));
    }

}
