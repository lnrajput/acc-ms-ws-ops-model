package com.acc.cloud.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class PolicyServiceConfig {
	
	@Autowired
	private OAuth2SecurityProperties oAuth2SecurityProperties;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
/*	@Bean
	public OAuth2RestTemplate restTemplate() {
		
		ResourceOwnerPasswordAccessTokenProvider tokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
		OAuth2AccessToken accessToken = tokenProvider.obtainAccessToken(oAuth2ProtectedResourceDetails(), new DefaultAccessTokenRequest());
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(oAuth2ProtectedResourceDetails(), new DefaultOAuth2ClientContext(accessToken));
		restTemplate.setAccessTokenProvider(tokenProvider);
		restTemplate.setRetryBadAccessTokens(true);
		log.debug("Access Token Details - Expires in :::"+ accessToken.getExpiresIn());
		log.debug("Access Token Details - Vaule :::"+ accessToken.getValue());
		restTemplate.getMessageConverters().add(0, mappingJackson2HttpMessageConverter());
		return restTemplate;
	}
	
	@Bean
	protected OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails() {
		
		ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
		resource.setClientAuthenticationScheme(AuthenticationScheme.header);
		resource.setAccessTokenUri(oAuth2SecurityProperties.getAccessTokenUri());
		resource.setGrantType(oAuth2SecurityProperties.getGrantType());
		resource.setUsername(oAuth2SecurityProperties.getUsername());
		resource.setPassword(oAuth2SecurityProperties.getPassword());
		resource.setClientId(oAuth2SecurityProperties.getClientId());
		resource.setClientSecret(oAuth2SecurityProperties.getClientSecret());
		resource.setTokenName(oAuth2SecurityProperties.getTokenName());	
		
		return resource;		
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		return mapper;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper());
		return converter;
		
	}
*/
}
