package com.interview.assignment.ForcastSummary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.assignment.ForcastSummary.client.ForcastSummaryClient;

@Service
public class ForcastSummaryServiceImpl implements ForcastSummaryService {

	@Autowired
	private ForcastSummaryClient client;

	@Override
	public String getRapidApiGetForecastSummaryByLocationName(String locationName, String rapidAPIKey , String rapidAPIHost) {
		return client.getRapidApiGetForecastSummaryByLocationName(locationName, rapidAPIKey, rapidAPIHost);
	}

	@Override
	public String getRapidApiGetHourlyForecastByLocationName(String locationName, String rapidAPIKey , String rapidAPIHost) {
		return client.getRapidApiGetHourlyForecastByLocationName(locationName, rapidAPIKey, rapidAPIHost);
	}

}
