package com.interview.assignment.ForcastSummary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.assignment.ForcastSummary.exception.ForcastSummaryException;
import com.interview.assignment.ForcastSummary.service.ForcastSummaryServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ForcastSummaryController {

	@Autowired
	private ForcastSummaryServiceImpl service;

	@GetMapping("/getForecastSummaryByLocationName/{locationName}")
	public String getRapidApiGetForecastSummaryByLocationName(@PathVariable String locationName,
			HttpServletRequest requestHeaders) throws Exception {
		String rapidAPIKey = requestHeaders.getHeader("X-RapidAPI-Key");
		String rapidAPIHost = requestHeaders.getHeader("X-RapidAPI-Host");
		if (rapidAPIKey == null || rapidAPIHost == null) {
			throw new ForcastSummaryException("Please Add X-RapidAPI-Key and X-RapidAPI-Host Headers");
		}
		return service.getRapidApiGetForecastSummaryByLocationName(locationName, rapidAPIKey, rapidAPIHost);
	}

	@GetMapping("/getHourlyForecastByLocationName/{locationName}")
	public String getHourlyForecastByLocationName(@PathVariable String locationName, HttpServletRequest requestHeaders)
			throws Exception {
		String rapidAPIKey = requestHeaders.getHeader("X-RapidAPI-Key");
		String rapidAPIHost = requestHeaders.getHeader("X-RapidAPI-Host");
		if (rapidAPIKey == null || rapidAPIHost == null) {
			throw new ForcastSummaryException("Please Add X-RapidAPI-Key and X-RapidAPI-Host Headers");
		}
		return service.getRapidApiGetForecastSummaryByLocationName(locationName, rapidAPIKey, rapidAPIHost);
		
	}

}
