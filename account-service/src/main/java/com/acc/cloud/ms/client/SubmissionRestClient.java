package com.acc.cloud.ms.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.acc.cloud.ms.model.SubmissionDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SubmissionRestClient {

	//Usecase-2
//	@Autowired
//	private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	public List<SubmissionDetails> getAllSubmissionDetails(Long accountId) {
		//Usecase-1. Direct using base url
		//String baseUrl = "http://localhost:8081";
		
		//Usecase-2. DiscoveryClient uses
		//List<ServiceInstance> instances = discoveryClient.getInstances("submission-service");
		//String baseUrl = instances.get(0).getUri().toString();
		//log.debug("Discovery base url::"+ baseUrl);
		
		//Usecase-3 Ribbon LoadBalanced
		ServiceInstance instance = loadBalancerClient.choose("submission-service");
		String baseUrl = instance.getUri().toString();
		List<SubmissionDetails> submissionDetailsList = (List<SubmissionDetails>) restTemplate.getForObject(baseUrl+"/submissions", Object.class);
		if(null!=submissionDetailsList && !submissionDetailsList.isEmpty()) {
			log.debug(submissionDetailsList.stream().findAny().toString());			
		}
		return submissionDetailsList;
	}

}
