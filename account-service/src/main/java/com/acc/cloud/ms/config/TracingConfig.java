package com.acc.cloud.ms.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {
	
/*    @Autowired
    private EurekaClient eurekaClient;
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
                InstanceInfo instance = eurekaClient.getNextServerFromEureka("zipkin", false);
                if (!(baseUrl != null && instance.getHomePageUrl().equals(baseUrl))) {
                    baseUrl = instance.getHomePageUrl();
                    delegate = new HttpZipkinSpanReporter(baseUrl, zipkinProperties.getFlushInterval(), zipkinProperties.getCompression().isEnabled(), spanMetricReporter);
                    if (!span.name.matches(skipPattern)) delegate.report(span);
                }
            }
        };
    }	*/

}
