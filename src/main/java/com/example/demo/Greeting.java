package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.Tracer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Greeting {

	private static final Logger logger = LoggerFactory.getLogger(Greeting.class);
	
	@Autowired
	Tracer tracer;

	@RequestMapping("/greeting")
	public String greeting() {
		logger.info("Hello info from from spring sleuth");
		logger.info("tracer is -----> "+tracer.currentSpan().context().traceIdString());
		return "Hello";
	}

}
