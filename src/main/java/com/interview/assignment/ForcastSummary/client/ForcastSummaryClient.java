package com.interview.assignment.ForcastSummary.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ForcastSummaryClient {

	@Autowired
	private RestTemplate restTemplate;
	/*Enter actual Working Url*/
	String rapidApiUrl = "http://localhost:3000/rapidapi/forecast/";

	public String getRapidApiGetForecastSummaryByLocationName(String locationName, String rapidAPIKey,
			String rapidAPIHost) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X-RapidAPI-Key", rapidAPIKey);
		httpHeaders.add("X-RapidAPI-Host", rapidAPIHost);
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		String forecastSummaryByLocationNameUrl = rapidApiUrl + locationName + "/summary";
		ResponseEntity<String> response = restTemplate.exchange(forecastSummaryByLocationNameUrl, HttpMethod.GET,
				httpEntity, String.class);
		return response.getBody();
	}

	public String getRapidApiGetHourlyForecastByLocationName(String locationName, String rapidAPIKey,
			String rapidAPIHost) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X-RapidAPI-Key", rapidAPIKey);
		httpHeaders.add("X-RapidAPI-Host", rapidAPIHost);
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		String hourlyForecastByLocationNameUrl = rapidApiUrl + locationName + "/hourly";
		ResponseEntity<String> response = restTemplate.exchange(hourlyForecastByLocationNameUrl, HttpMethod.GET,
				httpEntity, String.class);
		return response.getBody();
	}

}
