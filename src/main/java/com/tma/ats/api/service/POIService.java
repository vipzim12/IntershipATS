package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.POICreationAttributes;
import com.tma.ats.api.dto.POIModifiableAttributes;
import com.tma.ats.api.dto.POIObject;

public interface POIService {
	public List<POIObject> getPOIsByType(Long objectId);
	
	public List<POIObject> getAllPOIs();
	
	public POIObject createPOI(POICreationAttributes attributes);
	
	public POIObject getPOI(long objectId);
	
	public POIObject modifyPOI(POIModifiableAttributes attributes);
	
	public void deletePOIs(List<Long> objectId);
}
