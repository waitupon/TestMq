package com.dwh.rocketmq.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "spring.rocketmq")
@Configuration
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class RocketMQProperties {
    private String namesrvAddr;
    private String producerGroupName;
    private String transactionProducerGroupName;
    private String consumerGroupName;
    private String producerInstanceName;
    private String consumerInstanceName;
    private String producerTranInstanceName;
    private int consumerBatchMaxSize;
    private boolean consumerBroadcasting;
    private boolean enableHistoryConsumer;
    private boolean enableOrderConsumer;
    private List<String> subscribe = new ArrayList<String>();

}

