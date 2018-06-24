package com.tma.ats.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.ats.api.converter.POIConverter;
import com.tma.ats.api.db.dao.POIDao;
import com.tma.ats.api.db.dao.POITypeDao;
import com.tma.ats.api.db.entity.POI;
import com.tma.ats.api.db.entity.POIType;
import com.tma.ats.api.dto.POICreationAttributes;
import com.tma.ats.api.dto.POIModifiableAttributes;
import com.tma.ats.api.dto.POIObject;

@Service
public class POIServiceImpl implements POIService {

	@Autowired
	private POIDao poiDao;
	@Autowired
	private POITypeDao poiTypeDao;

	private POIConverter poiConverter = new POIConverter();

	@Override
	public List<POIObject> getPOIsByType(Long objectId) {
		List<POIObject> result = new ArrayList<POIObject>();
		List<POI> pois = new ArrayList<POI>();
		if (objectId == null) {
			pois = poiDao.list();
		} else {
			POIType poiType = poiTypeDao.read(objectId);
			if ((poiType == null) || (poiType.getPois() == null)) {
				return null;
			}
			pois = poiType.getPois();
		}
		for (POI poi : pois) {
			result.add(poiConverter.convert(poi));
		}
		return result;
	}

	@Override
	public List<POIObject> getAllPOIs() {
		List<POI> poiList = poiDao.list();
		if (poiList == null) {
			return null;
		}
		List<POIObject> result = new ArrayList<POIObject>();
		for (POI poi : poiList) {
			result.add(poiConverter.convert(poi));
		}
		return result;

	}

	@Override
	public POIObject createPOI(POICreationAttributes attributes) {
		POI poi = new POI();

		poi.setName(attributes.getName());
		poi.setLatitude(attributes.getLatitude());
		poi.setLongitude(attributes.getLongitude());
		poi.setDescription(attributes.getDescription());
		poi.setPoiType(poiTypeDao.read(attributes.getPOIType().getObjectId()));
		poi.setStamp(0);

		poi = poiDao.create(poi);
		return poiConverter.convert(poi);
	}

	@Override
	public POIObject getPOI(long objectId) {
		POI poi = poiDao.read(objectId);
		if (poi == null) {
			return null;
		}
		return poiConverter.convert(poi);
	}

	@Override
	public POIObject modifyPOI(POIModifiableAttributes attributes) {
		POI poi = poiDao.read(attributes.getObjectId());
		if (poi.getStamp() != attributes.getStamp()) {
			return null;
		}
		poi.setName(attributes.getName());
		poi.setLatitude(attributes.getLatitude());
		poi.setLongitude(attributes.getLongitude());
		poi.setDescription(attributes.getDescription());
		poi.setStamp(attributes.getStamp() + 1);

		poi = poiDao.update(poi);
		return poiConverter.convert(poi);
	}

	@Override
	public void deletePOIs(List<Long> objectIds) {
		for (Long objectId : objectIds) {
			POI poi = poiDao.read(objectId);
			if (poi != null) {
				poiDao.delete(poi);
			}
		}
	}

}
