package com.acc.cloud.ms.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.config.EnableIntegration;

import com.acc.cloud.ms.model.SubmissionDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(Sink.class)
@EnableIntegration
public class SubmissionMessageSink {
	
	@StreamListener(Sink.INPUT)
	public void submissionMessageProcessor(SubmissionDetails submissionDetails) {
		log.debug("Message Received from Broker:: "+submissionDetails.toString());
	}
	

}
