package com.acc.cloud.ms.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.cloud.ms.model.SubmissionDetails;
import com.acc.cloud.ms.service.SubmissionService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class SubmissionResource {

	@Autowired
	private SubmissionService submissionService;
	
	@RequestMapping("/submissions")
	public @ResponseBody List<SubmissionDetails> getAllSubmission(){
		log.debug("in getAllSubmission method..");
		return submissionService.getAllSubmissions();
	}
	
	@RequestMapping("/submissions/{submissionId}")
	public @ResponseBody SubmissionDetails getSubmission(@PathVariable("submissionId")Long submissionId) {
		log.debug("in getSubmission method..");
		return submissionService.getSubmission(submissionId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/submissions")
	public void createSubmission(@RequestBody SubmissionDetails submissionDetails) {
		log.debug("in createSubmission method..");
		submissionService.createSubmission(submissionDetails);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="submissions/{submissionId}")
	public void updateSubmission(@RequestBody SubmissionDetails submissionDetails, @PathVariable("submissionId") Long submissionId) {
		log.debug("in updateSubmission method..");
		submissionService.updateSubmission(submissionDetails, submissionId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/submissions/{submissionId}")
	public void deleteSubmission(@PathVariable("submissionId") Long submissionId) {
		log.debug("in updateSubmission method..");
		submissionService.deleteSubmission(submissionId);
	}

}
