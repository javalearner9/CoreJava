package com.h2k.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoggingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Pre-processing
		System.out.println("This is Pre-processing of LoggingFilter");
		// Actual Processing - Filter Chaining
		chain.doFilter(request, response);
		// Post processing
		System.out.println("Post processing logic is here");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Init Method for LoggingFilter");
		
	}

}
