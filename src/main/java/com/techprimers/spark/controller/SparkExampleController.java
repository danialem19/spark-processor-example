package com.techprimers.spark.controller;

import com.techprimers.spark.service.SparkExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SparkExampleController {
	@Autowired SparkExampleService sparkExampleService;
	
	@PostMapping(value = "/app/process")
	public int process() throws InterruptedException {
		return sparkExampleService.processSpark();
	}
}
