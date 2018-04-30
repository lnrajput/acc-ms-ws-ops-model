package com.acc.cloud.ms.model;

import java.util.Date;

import lombok.Data;

@Data
public class SubmissionDetails {
	
	private Long submissionId;
	private Date submissionEntryDate;
	private String businessName;
	private String phoneNumber;
	private String streetLine1;
	private String city;
	private String state;
	private String zipCode;
	private String marketSegment;
	private String lineOfInsurance;
	private String feinNumber;
	

}
