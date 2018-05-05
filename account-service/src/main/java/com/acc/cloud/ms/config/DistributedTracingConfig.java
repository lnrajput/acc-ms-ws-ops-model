package com.acc.cloud.ms.config;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.sleuth.zipkin2.ZipkinProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.InstanceInfo;

import zipkin2.Span;*/
/*
@Configuration
public class DistributedTracingConfig<SpanMetricReporter> {
	   @Autowired
	    private DiscoveryClient discoveryClient;
	    @Autowired
	    private SpanMetricReporter spanMetricReporter;
	    
	    @Autowired
	    private ZipkinProperties zipkinProperties;
	    
	    @Value("${spring.sleuth.web.skipPattern}")
	    private String skipPattern;


	    @Bean
	    public ZipkinSpanReporter makeZipkinSpanReporter() {
	        return new ZipkinSpanReporter() {
	            private HttpZipkinSpanReporter delegate;
	            private String baseUrl;

	            @Override
	            public void report(Span span) {
	                InstanceInfo instance = discoveryClient.getNextServerFromEureka("tracing-server", false);
	                if (!(baseUrl != null && instance.getHomePageUrl().equals(baseUrl))) {
	                    baseUrl = instance.getHomePageUrl();
	                    delegate = new HttpZipkinSpanReporter(baseUrl, zipkinProperties.getFlushInterval(), zipkinProperties.getCompression().isEnabled(), spanMetricReporter);
	                    if (!span.name.matches(skipPattern)) delegate.report(span);
	                }
	            }
	        };
	    }
	}*/