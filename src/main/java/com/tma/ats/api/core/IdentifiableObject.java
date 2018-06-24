package com.tma.ats.api.core;

import java.io.Serializable;

public interface IdentifiableObject<T extends Serializable> {
    public T getObjectId();
}
