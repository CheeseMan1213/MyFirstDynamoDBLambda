package com.healthfirst.memberfunction;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.healthfirst.memberfunction.entity.StudentRequest;
import com.healthfirst.memberfunction.entity.StudentResponse;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.Iterator;
import java.util.List;

//public class AwsLambdaHandler extends SpringBootRequestHandler<StudentRequest, StudentResponse> {
//public class AwsLambdaHandler extends SpringBootRequestHandler<HealthFirstMemberRequest, HealthFirstMemberResponse> {
//public class AwsLambdaHandler extends SpringBootRequestHandler<StudentRequest, ItemCollection<ScanOutcome>> {
//public class AwsLambdaHandler extends SpringBootRequestHandler<StudentRequest, Iterator<Item>> {
public class AwsLambdaHandler extends SpringBootRequestHandler<StudentRequest, List<String>> {

	//
}
