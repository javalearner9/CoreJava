package com.h2k.servlet.filter;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuditingFilter implements Filter{
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("IP Address of incoming request :: " + req.getRemoteAddr());
		System.out.println("Audit Time ::" + Calendar.getInstance().getTime());
		chain.doFilter(req, resp);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
