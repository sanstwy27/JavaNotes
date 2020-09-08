package com.sanstwy27.zookeeper.distributedlock.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sanstwy27
 * @create 9/7/2020
 */

@Configuration
public class ZookeeperConfig {
    /**
     * @param zookeeperProperties create CuratorFramework with zookeeperProperties
     * @return CuratorFramework
     */
    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework(ZookeeperProperties zookeeperProperties) {
        return CuratorFrameworkFactory.newClient(
                zookeeperProperties.getAddress(),
                zookeeperProperties.getSessionTimeoutMs(),
                zookeeperProperties.getConnectionTimeoutMs(),
                new RetryNTimes(zookeeperProperties.getRetryCount(),
                        zookeeperProperties.getElapsedTimeMs()));
    }
}
