package com.pruebadev.web.helpers;

import java.net.http.HttpClient;

import com.pruebadev.web.common.Constants;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientHelper {

    /**
     * 
     * @return
     */
	public WebClient getWebClient()
	{	    
		return WebClient.builder()
		        .baseUrl(Constants.URL_SERVICE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
		        .build();
	}
}
