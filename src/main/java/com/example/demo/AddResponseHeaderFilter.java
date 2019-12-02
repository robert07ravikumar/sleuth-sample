package com.example.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import brave.Tracer;

@WebFilter()
public class AddResponseHeaderFilter implements Filter {
	
	@Autowired
	Tracer tracer;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("tracer-id", tracer.currentSpan().context().traceIdString());
        chain.doFilter(request, response);
    }
	
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }
 
    @Override
    public void destroy() {
       
    }
}
