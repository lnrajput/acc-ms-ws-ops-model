package com.acc.cloud.ms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "accountmgmt.oauth2.client")
public class OAuth2SecurityProperties {

	private String clientId;
	private String clientSecret;
	private String accessTokenUri;
	private String userAuthorizationUri;
	private String userInfoUri;
	private String grantType;
	private String username;
	private String password;
	private String tokenName;
}
