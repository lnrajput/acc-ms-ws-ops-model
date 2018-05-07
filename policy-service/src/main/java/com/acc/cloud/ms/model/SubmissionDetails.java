package com.acc.cloud.ms.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
