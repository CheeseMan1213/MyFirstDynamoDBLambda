package com.healthfirst.memberfunction;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.healthfirst.memberfunction.entity.StudentRequest;
import com.healthfirst.memberfunction.entity.StudentResponse;
import com.healthfirst.memberfunction.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;
import java.util.function.Function;

@SpringBootApplication
public class MemberFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberFunctionApplication.class, args);
	}

//	@Bean
//	public Function<HealthFirstMemberRequest, HealthFirstMemberResponse> members() {
//		return member -> {
//			HealthFirstMemberResponse response = new HealthFirstMemberResponse();
//			response.setMemberId(member.getMemberId());
//			response.setCoverage(HealthFirstMemberResponse.Coverage.MEDICAL);
//		    return response;
//        };
//	}
	///New stuff here
	@Bean
	public Function<StudentRequest, ItemCollection<ScanOutcome>> members() {
		return student -> {
			SavePersonHandler savePersonHandler = new SavePersonHandler();
			ItemCollection<ScanOutcome> test = savePersonHandler.handleRequest(student);
			Iterator<Item> iterator = test.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().toJSONPretty());
			}
		    return savePersonHandler.handleRequest(student);
        };
	}
}
//public class SavePersonHandler implements RequestHandler<StudentRequest, StudentResponse> {
class SavePersonHandler {

	@Autowired
	StudentRepository repository;

	private DynamoDB dynamoDb;
	private String DYNAMODB_TABLE_NAME = "student";
	private Regions REGION = Regions.US_EAST_1;
	@Value("${amazon_aws_accesskey}")
	private String awsAccessKey;

	@Value("${amazon_aws_secretkey}")
	private String awsSecretKey;


	public ItemCollection<ScanOutcome> handleRequest(StudentRequest studentRequest) {

		this.initDynamoDbClient();
		Table table = this.dynamoDb.getTable(DYNAMODB_TABLE_NAME);

//		persistData(studentRequest);
//
//		StudentResponse studentResponse = new StudentResponse();
//		studentResponse.setMessage("Saved Successfully!!!");
//		return studentResponse;

		//ScanRequest scanRequest = new ScanRequest().withTableName(DYNAMODB_TABLE_NAME);
		//ScanResult scanResult = dynamoDb.scan

		return table.scan();
	}

//	private PutItemOutcome persistData(StudentRequest studentRequest)
//	  throws ConditionalCheckFailedException {
//		return this.dynamoDb.getTable(DYNAMODB_TABLE_NAME)
//		  .putItem(
//			new PutItemSpec().withItem(new Item()
//			  .withString("studentId", studentRequest.getStudentId())
//			  .withString("lastName", studentRequest.getLastName())));
//	}

	private void initDynamoDbClient() {
		AmazonDynamoDBClient client = new AmazonDynamoDBClient(amazonAWSCredentials());
		client.setRegion(Region.getRegion(REGION));
		this.dynamoDb = new DynamoDB(client);
	}
	private AWSCredentials amazonAWSCredentials() {
		return new BasicAWSCredentials(this.awsAccessKey, this.awsSecretKey);
	}
}
