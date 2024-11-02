package com.IotBTl.IOTbe.config;

import com.IotBTl.IOTbe.WebSocketHandler.DashboardHandler;
import com.IotBTl.IOTbe.WebSocketHandler.DevicesHandler;
import com.IotBTl.IOTbe.WebSocketHandler.MeasurementHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(getDashboardHandler(), "/dashboard");
    }

    @Bean
    DevicesHandler getDevicesHandler() {
        return new DevicesHandler();
    }

    @Bean
    DashboardHandler getDashboardHandler(){
        return new DashboardHandler();
    }

    @Bean
    MeasurementHandler getMeasurementHandler() {
        return new MeasurementHandler();
    }
}
