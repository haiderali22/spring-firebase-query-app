package com.hali.leaning.spring.firebase.model;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.firestore.annotation.PropertyName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@Document(collectionName = "LocationHistory")
public class LocationHistory
{
	@DocumentId
	private String id;
	
	private String lat;
	
	@PropertyName("long")
	private String longitude;
}
