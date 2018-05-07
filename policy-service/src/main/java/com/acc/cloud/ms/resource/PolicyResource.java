package com.acc.cloud.ms.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acc.cloud.ms.model.Policy;
import com.acc.cloud.ms.service.PolicyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PolicyResource {

	@Autowired
	private PolicyService policyService;
	
	@RequestMapping("/policies")
	public @ResponseBody List<Policy> getAllPolicy(){
		log.debug("in getAllPolicy method..");
		return policyService.getAllPolicys();
	}
	
	@RequestMapping("/policies/{policyId}")
	public @ResponseBody Policy getPolicy(@PathVariable("policyId")Long policyId) {
		log.debug("in getPolicy method..");
		return policyService.getPolicy(policyId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/policy")
	public void createPolicy(@RequestBody Policy policy) {
		log.debug("in createPolicy method..");
		policyService.createPolicy(policy);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="policies/{policyId}")
	public void updatePolicy(@RequestBody Policy policy, @PathVariable("policyId") Long policyId) {
		log.debug("in updatePolicy method..");
		policyService.updatePolicy(policy, policyId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/policies/{policyId}")
	public void deletePolicy(@PathVariable("policyId") Long policyId) {
		log.debug("in updatePolicy method..");
		policyService.deletePolicy(policyId);
	}
	
	@RequestMapping("/policies/accounts/{accountId}")
	public @ResponseBody List<Policy> getAllPoliciesForAccount(@PathVariable("accountId")Long accountId) {
		log.debug("in getAllPoliciesForAccount method..");
		return policyService.getAllPoliciesForAccount(accountId);
	}
}