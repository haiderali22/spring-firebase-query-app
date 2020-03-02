package com.hali.leaning.spring.firebase.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
	
	private String signalStrength;
	private Boolean gpsStatus;
	private String accuracy;
	private String deviceModel;
	
	@JsonProperty("long")
	private String longitude;
	private String lat;
	private String deviceOSVersion;
	private String deviceBrand;
	private String batteryLevel;
	private Boolean chargingState;
	private String timestamp;	

	
	@PropertyName("long")
	public String getLongitude() {
		return longitude;
	}
	
	@PropertyName("long")
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}	
}
