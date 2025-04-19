package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/send/Message")
    @SendTo("/topic/Receive")
    public String SendMessage(String Message){
        return "Message from server :"+Message;

    }
}