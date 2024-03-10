package com.tcil.in.astra20.onboarding.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ContentConfiguration implements WebMvcConfigurer{

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true)
				.parameterName("mediaType")
				.defaultContentType(org.springframework.http.MediaType.APPLICATION_XML)
				.mediaType("json", org.springframework.http.MediaType.APPLICATION_JSON)
				.mediaType("xml", org.springframework.http.MediaType.APPLICATION_XML);
	}	
}
