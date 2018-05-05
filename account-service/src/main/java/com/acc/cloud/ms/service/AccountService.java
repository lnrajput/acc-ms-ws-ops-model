package com.acc.cloud.ms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.cloud.ms.client.ISubmissionServiceFeignClient;
import com.acc.cloud.ms.configproperties.SubmissionWmqProperties;
import com.acc.cloud.ms.model.Account;
import com.acc.cloud.ms.model.SubmissionDetails;
import com.acc.cloud.ms.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private SubmissionWmqProperties submissionWmqProperties; 
	
//	@Autowired
//	private SubmissionRestClient submissionRestClient;
	
	@Autowired
	private ISubmissionServiceFeignClient iSubmissionServiceFeignClient;
	
	private List<Account> accounts = new ArrayList<>(Arrays.asList(new Account(1001L, "Accenture Workshop",null), new Account(1002L, "Accenture Microservices",null)));	

	public List<Account> getAllAccounts(){
		List<com.acc.cloud.ms.model.Account> accountModelList = new ArrayList<com.acc.cloud.ms.model.Account>();
		List<com.acc.cloud.ms.domain.Account> accountDomainList= null;
		log.debug("in Service getAllAccount..");
		accountDomainList = (List<com.acc.cloud.ms.domain.Account>) accountRepository.findAll();
		if(null !=accountDomainList && (!accountDomainList.isEmpty())) {
			for (com.acc.cloud.ms.domain.Account account : accountDomainList) {
				com.acc.cloud.ms.model.Account accountModel = new com.acc.cloud.ms.model.Account();
				accountModel.setAccountId(account.getAccountId());
				accountModel.setAccountName(account.getAccountName());
				accountModelList.add(accountModel);
			}

		}
		//Config Server Testing excercise
		// 1.Use Properties Object
		log.debug("Config Server Properties:::"+submissionWmqProperties.toString());
		
		return accountModelList;
	}
	
	public Account getAccount(Long accountId) {
		Optional<com.acc.cloud.ms.domain.Account> account = accountRepository.findById(accountId);
		com.acc.cloud.ms.model.Account accountModel = new com.acc.cloud.ms.model.Account();
		if(account.isPresent()) {			
			accountModel.setAccountId(account.get().getAccountId());
			accountModel.setAccountName(account.get().getAccountName());
		}			
//		//return accounts.stream().filter(t ->t.getAccountId().equals(accountId)).findFirst().get();
		return accountModel;
	}
	
	public void createAccount(Account account) {
		accounts.add(account);
	}
	
	public void updateAccount(Account account, Long accountId) {
		accounts.stream().filter(t -> t.getAccountId().equals(accountId)).collect(Collectors.toList()).add(account);
	}
	
	public void deleteAccount(Long accountId) {
		accounts.removeIf(t -> t.getAccountId().equals(accountId));
	}
	
	public Account getAllSubmissionDetailsForAccount(Long accountId) {
		Account account = new Account();
		List<SubmissionDetails> submissionDetailsList = null;
		//RestClient and LoadBalenced Example
		//submissionDetailsList = submissionRestClient.getAllSubmissionDetails(accountId);
		//Feign Client Example
		submissionDetailsList = iSubmissionServiceFeignClient.getAllSubmissions();
		account.setAccountId(333333L);
		account.setAccountName("Accenture Workshop Account");
		account.setSubmissionDetailsList(submissionDetailsList);
		log.debug("Submission Details for Account"+ account.toString());
		return account;
	}
}


