package com.techprimers.spark.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.spark.sql.SparkSession;

@Configuration
public class SparkConfig {
	@Value("${spark.app.name}")
	private String appName;
	@Value("${spark.master}")
	private String masterUri;
	
	@Bean
	public SparkConf conf() {
		return new SparkConf().setAppName(appName).setMaster(masterUri);
	}
	
	@Bean
	public SparkSession sparkSession() {
		SparkSession session = SparkSession
			.builder()
			.appName("SparkJavaExample")
			.master("local[3]")
			.getOrCreate();
		return session;
	}
	
//	@Bean
//	public JavaSparkContext sc() {
//		return new JavaSparkContext(conf());
//	}
}
