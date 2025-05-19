package com.iskandarov.backend_services.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.net.Socket;

@Component("internetConnectionCheck")
public class InternetConnectionCheck implements HealthIndicator {
    private static final String HOST = "groogle.com";
    private static final int PORT = 80;
    private static final int TIMEOUT_MS = 2000;

    @Override
    public Health health() {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(HOST, PORT), TIMEOUT_MS);
            return Health.up().withDetail("host", HOST).withDetail("port", PORT).build();
        } catch (Exception e) {
            return Health.down().withDetail("error", e.getMessage()).build();
        }
    }
}
