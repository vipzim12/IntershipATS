package com.tma.ats.api.core;

import java.io.Serializable;

public interface BusinessObject<I extends Serializable> extends VersionedObject<I>, Serializable {
	
}
