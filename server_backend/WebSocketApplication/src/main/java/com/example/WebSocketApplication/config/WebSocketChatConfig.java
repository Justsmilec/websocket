package com.example.WebSocketApplication.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketChatConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //all the websocket request must start with http://localhost:8080/websocketApp/
        System.out.println("Here registe stomp");

        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:4200").withSockJS();

        //why use withSockJs -- it will let our WebSockets work even if the WebSocket protocol is not supported by an internet browser
        //if setAllowedOrigin("*")  -- is for any case

    }



    //1--> create in-memory message broker for sending and recieving messages in this case one destonation
    //destination  "topic"
    //2--> defines the prfic app that is used to filter destionations handled by methods annotated with @MessageMapping
    // (which will be implementd on controller). The controller after processing the message will send it to the broker.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        System.out.println("Here messge broker");

        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");

    }
}
