package com.interview.assignment.ForcastSummary.service;

public interface ForcastSummaryService {

	String getRapidApiGetForecastSummaryByLocationName(String locationName, String rapidAPIKey , String rapidAPIHost);
	
	String getRapidApiGetHourlyForecastByLocationName(String locationName, String rapidAPIKey , String rapidAPIHost);

}
