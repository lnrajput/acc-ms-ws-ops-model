package com.acc.cloud.ms.messaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.acc.cloud.ms.model.SubmissionDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(Source.class)
public class SubmissionMessageSource {
	
	@Autowired
	@Output(Source.OUTPUT)
	MessageChannel output;
	
	public void emitEvent(SubmissionDetails submissionDetails) {
		log.debug("Received submission message :: "+submissionDetails.toString());
		output.send(MessageBuilder.withPayload(submissionDetails).build());
		log.debug("Message sent to Broker..");
		
	}

}
