package com.acc.cloud.ms.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acc.cloud.ms.model.Account;
import com.acc.cloud.ms.model.SubmissionDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountMgmtServiceRestClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "defaultAccountDetailsWithSubmissions")
	public Account getAccountDetailsWithSubmissions(Long accountId) {
		String baseUrl = "http://localhost:8087/api/account-service/accounts/"+accountId+"/submissions";
		log.debug("Discovery base url::"+ baseUrl);		
		Account account=null;		
		ResponseEntity<Account> responseEntity = (ResponseEntity<Account>) restTemplate.getForEntity(baseUrl, Account.class);		
		account = responseEntity.getBody();
		return account;
	}
	
    @SuppressWarnings("unused")
	private Account defaultAccountDetailsWithSubmissions(Long accountId) {
		Account account = new Account();
		account.setAccountId(10001L);
		account.setAccountName("Accenture Workshop Account - Default");		
		SubmissionDetails submissionDetails = new SubmissionDetails();
		List<SubmissionDetails> submissionDetailsList = new ArrayList<SubmissionDetails>();
			submissionDetails.setSubmissionId(9999L);
			submissionDetails.setSubmissionEntryDate(new Date());
			submissionDetails.setBusinessName("Default Business");
			submissionDetails.setPhoneNumber("860-944-8845");
			submissionDetails.setStreetLine1("6 Buttrick Court Default");
			submissionDetails.setCity("LutherVille Timonium");
			submissionDetails.setState("MD");
			submissionDetails.setZipCode("21093");
			submissionDetails.setMarketSegment("Gold mine");
			submissionDetails.setLineOfInsurance("Auto");
			submissionDetails.setFeinNumber("345-345-5533"); 
			submissionDetailsList.add(submissionDetails);		
		account.setSubmissionDetailsList(submissionDetailsList);
		log.debug("Submission Details for Account"+ account.toString());
		return account;
    }	

}
