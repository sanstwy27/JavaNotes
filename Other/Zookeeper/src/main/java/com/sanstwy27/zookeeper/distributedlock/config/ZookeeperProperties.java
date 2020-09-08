package com.sanstwy27.zookeeper.distributedlock.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sanstwy27
 * @create 9/7/2020
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperProperties {
    /** Retry Count */
    private int retryCount;

    /** Retry Interval */
    private int elapsedTimeMs;

    /** Zookeeper Address */
    private String address;

    /** Session Expiration Time */
    private int sessionTimeoutMs;

    /** Connection Timeout */
    private int connectionTimeoutMs;
}
