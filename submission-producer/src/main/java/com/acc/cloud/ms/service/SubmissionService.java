package com.acc.cloud.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.cloud.ms.messaging.SubmissionMessageSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubmissionService{
	
	@Autowired
	private SubmissionMessageSource submissionMessageSource;
	
	public String getSubmission(String submissionId) {
		log.debug("In Submission Producer Service");
		submissionMessageSource.emitEvent(submissionId);
		return "Successfully Sent";
	}

}
