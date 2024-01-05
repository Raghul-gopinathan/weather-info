package com.interview.assignment.ForcastSummary.config;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class RequestHeaderAuthenticationProvider implements AuthenticationProvider {

	private String apiAuthSecret = "secret";//Hard coding for testing purpose

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String authSecretKey = String.valueOf(authentication.getPrincipal());

		if (authSecretKey.isBlank() || !authSecretKey.equals(apiAuthSecret)) {
			throw new BadCredentialsException("Bad Request Header Credentials");
		}

		return new PreAuthenticatedAuthenticationToken(authentication.getPrincipal(), null, new ArrayList<>());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(PreAuthenticatedAuthenticationToken.class);
	}

}
