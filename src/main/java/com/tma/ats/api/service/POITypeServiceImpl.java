package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.POITypeConverter;
import com.tma.ats.api.db.dao.POITypeDao;
import com.tma.ats.api.db.entity.POIType;
import com.tma.ats.api.dto.POITypeCreationAttributes;
import com.tma.ats.api.dto.POITypeModifiableAttributes;
import com.tma.ats.api.dto.POITypeObject;

@Service
public class POITypeServiceImpl implements POITypeService {

	@Autowired
	private POITypeDao poiTypeDao;

	private POITypeConverter converter = new POITypeConverter();

	@Override
	public List<POITypeObject> getAllPOITypes() {
		List<POIType> poiTypeList = poiTypeDao.list();
		if (poiTypeList == null) {
			return null;
		}
		List<POITypeObject> result = new ArrayList<POITypeObject>();
		for (POIType poiType : poiTypeList) {
			result.add(converter.convert(poiType));
		}
		return result;
	}

	@Override
	public POITypeObject createPOIType(POITypeCreationAttributes attributes) {
		POIType poiType = new POIType();

		poiType.setName(attributes.getName());
		poiType.setDescription(attributes.getDescription());
		poiType.setStamp(0);

		poiType = poiTypeDao.create(poiType);
		return converter.convert(poiType);
	}

	@Override
	public POITypeObject modifyPOIType(POITypeModifiableAttributes attributes) {
		POIType poiType = poiTypeDao.read(attributes.getObjectId());
		if (poiType == null) {
			return null;
		}

		poiType.setName(attributes.getName());
		poiType.setDescription(attributes.getDescription());
		poiType.setStamp(attributes.getStamp() + 1);

		poiType = poiTypeDao.update(poiType);
		return converter.convert(poiType);

	}

	@Override
	public void deletePOITypes(List<Long> objectIds) {
		for (Long objectId : objectIds) {
			POIType poiType = poiTypeDao.read(objectId);
			if (poiType != null) {
				poiTypeDao.delete(poiType);
			}
		}
	}

}
