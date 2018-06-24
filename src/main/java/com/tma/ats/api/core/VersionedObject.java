package com.tma.ats.api.core;

import java.io.Serializable;

public interface VersionedObject<I extends Serializable> extends IdentifiableObject<I> {
    public int getStamp();
}
