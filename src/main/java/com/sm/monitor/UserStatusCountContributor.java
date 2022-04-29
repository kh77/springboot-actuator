package com.sm.monitor;

import com.sm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * add more information in '/actuator/info' endpoint
 */
@Component
public class UserStatusCountContributor implements InfoContributor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> userStatusMap=new HashMap<>();
        userStatusMap.put("active",userRepository.getUserStatusCountByStatus(true));
        userStatusMap.put("in-active",userRepository.getUserStatusCountByStatus(false));
        builder.withDetail("userStatus",userStatusMap);
    }
}
