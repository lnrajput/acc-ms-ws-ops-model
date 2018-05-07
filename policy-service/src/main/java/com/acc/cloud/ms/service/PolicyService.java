package com.acc.cloud.ms.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.cloud.ms.client.AccountMgmtServiceRestClient;
import com.acc.cloud.ms.domain.PolicyDomain;
import com.acc.cloud.ms.model.Account;
import com.acc.cloud.ms.model.Policy;
import com.acc.cloud.ms.repository.PolicyRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;
	

	@Autowired
	private AccountMgmtServiceRestClient accountMgmtServiceRestClient;
	
//	@Autowired
//	private ISubmissionServiceFeignClient iSubmissionServiceFeignClient;
	
	private List<PolicyDomain> policyDomains = new ArrayList<>(Arrays.asList(new PolicyDomain(50001L, "Auto",10001L,30001L,"Select", "Electronic"), new PolicyDomain(50002L, "Auto",10001L,30002L,"Select", "Electronic"),new PolicyDomain(50003L, "Auto",10001L,30003L,"Select", "Electronic")));	

	public List<Policy> getAllPolicys(){
		List<com.acc.cloud.ms.domain.PolicyDomain> policyDomainList= null;
		List<Policy> policies = new ArrayList<Policy>();
		log.debug("in Service getAllPolicy..");
//		policyDomainList = (List<com.acc.cloud.ms.domain.PolicyDomain>) policyRepository.findAll();
		policyDomainList=policyDomains;
		if(null !=policyDomainList && (!policyDomainList.isEmpty())) {
			for (com.acc.cloud.ms.domain.PolicyDomain policyDomain : policyDomainList) {
				com.acc.cloud.ms.model.Policy policy = new com.acc.cloud.ms.model.Policy();
				policy.setPolicyId(policyDomain.getPolicyId());
				policy.setPolicyType(policyDomain.getPolicyType());
				policy.setAccountId(policyDomain.getAccountId());
				policy.setAccountName(policyDomain.getAccountName());
				policy.setBusinessType(policyDomain.getBusinessType());
				policy.setSubmissionId(policyDomain.getSubmissionId());
				policies.add(policy);
			}
		}
		return policies;
	}
	
	public Policy getPolicy(Long policyId) {
//		Optional<PolicyDomain> policyDomain = policyRepository.findById(policyId);
		Optional<PolicyDomain> policyDomain = null;
		policyDomain = Optional.of(policyDomains.stream().filter(t ->t.getPolicyId().equals(policyId)).findFirst().get());
		com.acc.cloud.ms.model.Policy policy = new com.acc.cloud.ms.model.Policy();
		if(policyDomain.isPresent()) {			
			policy.setPolicyId(policyDomain.get().getPolicyId());
			policy.setPolicyType(policyDomain.get().getPolicyType());
			policy.setAccountId(policyDomain.get().getAccountId());
			policy.setAccountName(policyDomain.get().getAccountName());
			policy.setBusinessType(policyDomain.get().getBusinessType());
			policy.setSubmissionId(policyDomain.get().getSubmissionId());
		}			
		
		return policy;
	}
	
	public void createPolicy(Policy policy) {
		com.acc.cloud.ms.domain.PolicyDomain policyDomain = new com.acc.cloud.ms.domain.PolicyDomain();
		policyDomain.setPolicyId(policy.getPolicyId());
		policyDomain.setPolicyType(policy.getPolicyType());
		policyDomain.setAccountId(policy.getAccountId());
		policyDomain.setAccountName(policy.getAccountName());
		policyDomain.setSubmissionId(policy.getSubmissionId());
		policyDomain.setBusinessType(policy.getBusinessType());
		policyDomains.add(policyDomain);
	}
	
	public void updatePolicy(Policy policy, Long policyId) {
		com.acc.cloud.ms.domain.PolicyDomain policyDomain = new com.acc.cloud.ms.domain.PolicyDomain();
		policyDomain.setPolicyId(policy.getPolicyId());
		policyDomain.setPolicyType(policy.getPolicyType());
		policyDomain.setAccountId(policy.getAccountId());
		policyDomain.setAccountName(policy.getAccountName());
		policyDomain.setSubmissionId(policy.getSubmissionId());
		policyDomain.setBusinessType(policy.getBusinessType());
		policyDomains.stream().filter(t -> t.getPolicyId().equals(policyId)).collect(Collectors.toList()).add(policyDomain);
	}
	
	public void deletePolicy(Long policyId) {
		policyDomains.removeIf(t -> t.getPolicyId().equals(policyId));
	}
	
	public List<Policy> getAllPoliciesForAccount(Long accountId) {
		Account account = null;
		account = accountMgmtServiceRestClient.getAccountDetailsWithSubmissions(accountId);
		if(null!=account) {
			policyDomains.stream().filter(f->f.getAccountId().equals(accountId)).collect(Collectors.toList());
		}		
		List<Policy> policies = new ArrayList<Policy>();
		log.debug("in Service getAllPolicy..");
		if(null !=policyDomains && (!policyDomains.isEmpty())) {
			for (com.acc.cloud.ms.domain.PolicyDomain policyDomain : policyDomains) {
				com.acc.cloud.ms.model.Policy policy = new com.acc.cloud.ms.model.Policy();
				policy.setPolicyId(policyDomain.getPolicyId());
				policy.setPolicyType(policyDomain.getPolicyType());
				policy.setAccountId(policyDomain.getAccountId());
				policy.setAccountName(policyDomain.getAccountName());
				policy.setBusinessType(policyDomain.getBusinessType());
				policy.setSubmissionId(policyDomain.getSubmissionId());
				policies.add(policy);
			}
		}
		return policies;
	}
}



