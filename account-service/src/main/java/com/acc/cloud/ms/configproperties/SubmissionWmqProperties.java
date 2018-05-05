package com.acc.cloud.ms.configproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="jms.queue")
public class SubmissionWmqProperties {
	
	private String queueManager;
	private String host;
	private int port;
	private String channel;
	private String queueName;
	private String username;
	private String password;
	private String inboundQueueName;
	private int transportType;	


}
