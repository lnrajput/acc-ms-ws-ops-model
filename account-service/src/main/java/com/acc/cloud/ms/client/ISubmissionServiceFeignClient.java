package com.acc.cloud.ms.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acc.cloud.ms.model.SubmissionDetails;

//@FeignClient(value = "submission-service")
@FeignClient(name = "submission-service", fallback = ISubmissionServiceFeignClient.ISubmissionServiceFeignClientFallback.class)
public interface ISubmissionServiceFeignClient extends ISubmissionService{
	
    @Component
    public static class ISubmissionServiceFeignClientFallback implements ISubmissionServiceFeignClient {
    	@Override
    	public @ResponseBody List<SubmissionDetails> getAllSubmissions(){    		
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
    			return submissionDetailsList;
    	}
    }

}
