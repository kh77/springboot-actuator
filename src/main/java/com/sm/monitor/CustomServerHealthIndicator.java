package com.sm.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomServerHealthIndicator implements HealthIndicator {

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        Health health = Health.up().build();
        //System.out.println("JSS Health: " + health);
        return health;
    }
}
