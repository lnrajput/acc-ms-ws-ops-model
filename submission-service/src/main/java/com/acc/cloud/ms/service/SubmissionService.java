package com.acc.cloud.ms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.cloud.ms.domain.Submission;
import com.acc.cloud.ms.messaging.SubmissionMessageSource;
import com.acc.cloud.ms.model.SubmissionDetails;
import com.acc.cloud.ms.repository.SubmissionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubmissionService implements ISubmissionService{
	
	@Autowired
	private SubmissionRepository submissionRepository;
	
	@Autowired
	private SubmissionMessageSource submissionMessageSource;
	
	private List<Submission> submissions = new ArrayList<>(Arrays.asList(new Submission(1001L, new Date(), "Walmart", "860-944-8845", "6 Buttrick Court", "LutherVille Timonium", "MD", "21093", "Aggri Business", "Auto", "1234-34-352"), new Submission(1002L, new Date(), "Target", "860-944-8825", "4 Buttrick Court", "LutherVille Timonium", "MD", "21093", "Aggri Business", "CMP", "1234-34-322")));	

	public List<SubmissionDetails> getAllSubmissions(){
		List<com.acc.cloud.ms.model.SubmissionDetails> SubmissionDetailsList = new ArrayList<com.acc.cloud.ms.model.SubmissionDetails>();
		log.debug("in Service getAllSubmissions..");
//		accountDomainList = (List<com.acc.cloud.ms.domain.Account>) accountRepository.findAll();
		for (Submission submission : submissions) {
			SubmissionDetails submissionDetails = new SubmissionDetails();
			submissionDetails.setSubmissionId(submission.getSubmissionId());
			submissionDetails.setSubmissionEntryDate(submission.getSubmissionEntryDate());
			submissionDetails.setBusinessName(submission.getBusinessName());
			submissionDetails.setPhoneNumber(submission.getPhoneNumber());
			submissionDetails.setStreetLine1(submission.getStreetLine1());
			submissionDetails.setCity(submission.getCity());
			submissionDetails.setState(submission.getState());
			submissionDetails.setZipCode(submission.getZipCode());
			submissionDetails.setMarketSegment(submission.getMarketSegment());
			submissionDetails.setLineOfInsurance(submission.getLineOfInsurance());
			submissionDetails.setFeinNumber(submission.getFeinNumber());
			SubmissionDetailsList.add(submissionDetails);
		}
		return SubmissionDetailsList;
	}
	
	public SubmissionDetails getSubmission(Long submissionId) {				
		SubmissionDetails submissionDetails = new SubmissionDetails(); 
		Submission submission = null;
		submission = submissions.stream().filter(t ->t.getSubmissionId().equals(submissionId)).findFirst().get();
		if(null !=submission) {
			submissionDetails.setSubmissionId(submission.getSubmissionId());
			submissionDetails.setSubmissionEntryDate(submission.getSubmissionEntryDate());
			submissionDetails.setBusinessName(submission.getBusinessName());
			submissionDetails.setPhoneNumber(submission.getPhoneNumber());
			submissionDetails.setStreetLine1(submission.getStreetLine1());
			submissionDetails.setCity(submission.getCity());
			submissionDetails.setState(submission.getState());
			submissionDetails.setZipCode(submission.getZipCode());
			submissionDetails.setMarketSegment(submission.getMarketSegment());
			submissionDetails.setLineOfInsurance(submission.getLineOfInsurance());
			submissionDetails.setFeinNumber(submission.getFeinNumber());
			submissionMessageSource.emitEvent(submissionDetails);
		}
		return submissionDetails;
	}
	
	public void createSubmission(SubmissionDetails submissionDetails) {
//		submissions.add(submissionDetails);
	}
	
	public void updateSubmission(SubmissionDetails submissionDetails, Long submissionId) {
//		submissions.stream().filter(t -> t.getSubmissionId().equals(submissionId)).collect(Collectors.toList()).add(submissionDetails);
	}
	
	public void deleteSubmission(Long submissionId) {
		submissions.removeIf(t -> t.getSubmissionId().equals(submissionId));
	}
}
