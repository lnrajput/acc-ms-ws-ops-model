package com.acc.cloud.ms.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.cloud.ms.model.SubmissionDetails;

public interface ISubmissionService {
	
	@RequestMapping("/submissions")
	public @ResponseBody List<SubmissionDetails> getAllSubmissions();	
	@RequestMapping("/submissions/{submissionId}")
	public @ResponseBody SubmissionDetails getSubmission(@PathVariable("submissionId")Long submissionId);	
	@RequestMapping(method=RequestMethod.POST, value="/submissions")
	public void createSubmission(@RequestBody SubmissionDetails submissionDetails);	
	@RequestMapping(method=RequestMethod.PUT, value="submissions/{submissionId}")
	public void updateSubmission(@RequestBody SubmissionDetails submissionDetails, @PathVariable("submissionId") Long submissionId);	
	@RequestMapping(method=RequestMethod.DELETE, value="/submissions/{submissionId}")
	public void deleteSubmission(@PathVariable("submissionId") Long submissionId);

}
