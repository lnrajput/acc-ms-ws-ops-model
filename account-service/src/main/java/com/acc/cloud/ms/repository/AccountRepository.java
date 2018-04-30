package com.acc.cloud.ms.repository;

import org.springframework.data.repository.CrudRepository;

import com.acc.cloud.ms.domain.Account;


public interface AccountRepository extends CrudRepository<Account, Long> {

//	public Account findByAccountId(Long accountId);
}
