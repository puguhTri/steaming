package com.evodia.imds.client.streamingclient.messagebroker;

import com.evodia.imds.client.streamingclient.messages.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class ImdsConsumer {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @KafkaListener(topics = {"test","announcement_uma_widget"}, groupId = "spring-cloud")
    public void streamingTest(String message) {
        log.info(message);
        //simpMessagingTemplate.convertAndSend("/topic/announcement_uma_widget", new Greeting(message));
        simpMessagingTemplate.convertAndSend("/topic/announcement_uma_widget", new Greeting(message));

    }

}
