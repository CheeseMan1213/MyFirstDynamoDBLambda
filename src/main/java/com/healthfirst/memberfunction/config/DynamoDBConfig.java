//package com.healthfirst.memberfunction.config;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
//import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//@Configuration
//@EnableDynamoDBRepositories(basePackages = "com.healthfirst.memberfunction.repository")
//public class DynamoDBConfig {
//
//	@Value("${amazon_aws_accesskey}")
//	private String awsAccessKey;
//
//	@Value("${amazon_aws_secretkey}")
//	private String awsSecretKey;
//
//	@Value("${amazon_dynamodb_region}")
//	private String awsRegion;
//
//	@Value("${amazon_dynamodb_endpoint}")
//	private String awsDynamoDBEndpoint;
//
//	@Autowired
//	private ApplicationContext context;
//
//	@Bean
//	public AmazonDynamoDB amazonDynamoDB() {
//		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
//		if (!StringUtils.isEmpty(this.awsDynamoDBEndpoint)) {
//			amazonDynamoDB.setEndpoint(this.awsDynamoDBEndpoint);
//		}
//		return amazonDynamoDB;
//	}
//
//	@Bean
//	public AWSCredentials amazonAWSCredentials() {
//		return new BasicAWSCredentials(this.awsAccessKey, this.awsSecretKey);
//	}
//
//	@Bean(name = "mvcHandlerMappingIntrospectorCustom")
//	public HandlerMappingIntrospector mvcHandlerMappingIntrospectorCustom() {
//		return new HandlerMappingIntrospector(context);
//	}
//}
