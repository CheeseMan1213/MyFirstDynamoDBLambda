package com.healthfirst.memberfunction.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "student")
public class Student implements Serializable {

	@DynamoDBHashKey (attributeName = "studentId")
	@DynamoDBAutoGeneratedKey
	private String studentId;
	@DynamoDBAttribute
	private String lastName;
	@DynamoDBAttribute
	private int age;
}