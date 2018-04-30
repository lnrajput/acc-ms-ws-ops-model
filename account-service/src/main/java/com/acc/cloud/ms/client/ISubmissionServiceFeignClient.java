package com.acc.cloud.ms.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "submission-service")
public interface ISubmissionServiceFeignClient extends ISubmissionService{

}
