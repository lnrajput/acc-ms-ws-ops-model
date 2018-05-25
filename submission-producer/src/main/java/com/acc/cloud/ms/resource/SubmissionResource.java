package com.acc.cloud.ms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.cloud.ms.service.SubmissionService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class SubmissionResource {

	@Autowired
	private SubmissionService submissionService;

	@RequestMapping("/submissions/{submissionId}")
	public @ResponseBody String getSubmission(@PathVariable("submissionId")String submissionId) {
		log.debug("in getSubmission producer resource method..");
		return submissionService.getSubmission(submissionId);
	}

}
