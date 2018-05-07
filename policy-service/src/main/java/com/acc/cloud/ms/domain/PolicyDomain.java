package com.acc.cloud.ms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="policy")
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDomain {
	
	
	@Id
	@NotNull
	@Column(name="policy_id")
	private Long policyId;
	@NotNull
	@Column(name="policy_type")
	private String policyType;
	@NotNull
	@Column(name="account_id")
	private Long accountId;
	@NotNull
	@Column(name="submission_id")
	private Long submissionId;
	@Column(name="account_name")
	private String accountName;
	@Column(name="business_type")
	private String businessType;
}
