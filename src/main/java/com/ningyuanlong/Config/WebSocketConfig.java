package com.ningyuanlong.Config;

import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by Tony on 2020/4/25
 */
@Configuration
@EnableWebSocketMessageBroker
@Log4j
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/any-socket").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
        messageBrokerRegistry.enableSimpleBroker("/topic", "/queue");
    }

}
