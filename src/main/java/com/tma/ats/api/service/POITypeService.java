package com.tma.ats.api.service;

import java.util.List;

import com.tma.ats.api.dto.POITypeCreationAttributes;
import com.tma.ats.api.dto.POITypeModifiableAttributes;
import com.tma.ats.api.dto.POITypeObject;

public interface POITypeService {
	public List<POITypeObject> getAllPOITypes();
	
	public POITypeObject createPOIType(POITypeCreationAttributes attributes);
	
	public POITypeObject modifyPOIType(POITypeModifiableAttributes attributes);
	
	public void deletePOITypes(List<Long> objectId);
}