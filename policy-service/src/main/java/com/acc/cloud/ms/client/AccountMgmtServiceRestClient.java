package com.acc.cloud.ms.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acc.cloud.ms.model.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountMgmtServiceRestClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Account getAccountDetailsWithSubmissions(Long accountId) {
		String baseUrl = "http://localhost:8087/api/account-service/accounts/"+accountId+"/submissions";
		log.debug("Discovery base url::"+ baseUrl);		
		Account account=null;		
		ResponseEntity<Account> responseEntity = (ResponseEntity<Account>) restTemplate.getForEntity(baseUrl, Account.class);		
		account = responseEntity.getBody();
		return account;
	}

}
