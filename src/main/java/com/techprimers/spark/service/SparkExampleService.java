package com.techprimers.spark.service;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SparkExampleService {
	@Autowired
	SparkSession session;
	
	public int processSpark() throws InterruptedException {
		int sum = 1000;
		try (JavaSparkContext context = new JavaSparkContext(session.sparkContext())) {
			List<Integer> integers = Arrays.asList(1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
			JavaRDD<Integer> javaRDD = context.parallelize(integers, 3);
			javaRDD
				.foreach((VoidFunction<Integer>)integer -> {
					System.out.println("Java RDD:" + integer);
					//Thread.sleep(3000);
				});
			//Thread.sleep(1000000);
			context.stop();
		}
		return sum;
	}
}
