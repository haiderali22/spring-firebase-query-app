package com.hali.leaning.spring.firebase.model;

import java.util.List;

import org.springframework.cloud.gcp.data.firestore.Document;

import com.google.cloud.firestore.annotation.DocumentId;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collectionName = "Orders")
public class Order 
{
	@DocumentId
	private String id;
	
	private List<LocationHistory> locationHistory;
}
