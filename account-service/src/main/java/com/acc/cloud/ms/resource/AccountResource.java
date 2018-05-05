package com.acc.cloud.ms.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.cloud.ms.model.Account;
import com.acc.cloud.ms.service.AccountService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RefreshScope
public class AccountResource {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public @ResponseBody List<Account> getAllAccount(){
		log.debug("in getAllAccount method..");
		return accountService.getAllAccounts();
	}
	
	@RequestMapping("/accounts/{accountId}")
	public @ResponseBody Account getAccount(@PathVariable("accountId")Long accountId) {
		log.debug("in getAccount method..");
		return accountService.getAccount(accountId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/account")
	public void createAccount(@RequestBody Account account) {
		log.debug("in createAccount method..");
		accountService.createAccount(account);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="accounts/{accountId}")
	public void updateAccount(@RequestBody Account account, @PathVariable("accountId") Long accountId) {
		log.debug("in updateAccount method..");
		accountService.updateAccount(account, accountId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/accounts/{accountId}")
	public void deleteAccount(@PathVariable("accountId") Long accountId) {
		log.debug("in updateAccount method..");
		accountService.deleteAccount(accountId);
	}
	
	@RequestMapping("/accounts/{accountId}/submissions")
	public @ResponseBody Account getAllSubmissionDetailsForAccount(@PathVariable("accountId")Long accountId) {
		log.debug("in getAccount method..");
		return accountService.getAllSubmissionDetailsForAccount(accountId);
	}

}
