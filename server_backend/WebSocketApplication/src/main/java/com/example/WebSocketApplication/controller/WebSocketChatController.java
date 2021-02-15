package com.example.WebSocketApplication.controller;

import com.example.WebSocketApplication.model.WebSocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@Controller
public class WebSocketChatController {


    @MessageMapping("/sendMessage")
    @SendTo("/topic/public")
    public String sendMessage(@Payload String message) {
        System.out.println("Here: "+ message);
        return message;
    }

    /*
        Since I use app prefix in web socket config file this method maps
         to “app/sendMessage” and then it returns the message content to the path “/topic/public”.
        In the front end we can subscribe this path (“/topic/public”)
        and then we will be able to execute any function when it gets a message.
     */
//
//    @MessageMapping("/chat.newUser")
//    @SendTo("/topic/javainuse")
//    public WebSocketChatMessage newUser(@Payload WebSocketChatMessage webSocketChatMessage,
//                                        SimpMessageHeaderAccessor headerAccessor) {
//        headerAccessor.getSessionAttributes().put("username", webSocketChatMessage.getSender());
//        return webSocketChatMessage;
//    }

}