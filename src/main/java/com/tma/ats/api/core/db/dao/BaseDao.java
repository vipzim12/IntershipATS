package com.tma.ats.api.core.db.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.tma.ats.api.core.exception.DuplicateObjectException;
import com.tma.ats.api.core.exception.InvalidValueException;
import com.tma.ats.api.core.exception.ObjectInUseException;
import com.tma.ats.api.core.exception.StampMismatchException;

public interface BaseDao <E extends Indexable> {

    public void setEntityManager(EntityManager em);

    public E create(E newInstance) throws DuplicateObjectException, ObjectInUseException, InvalidValueException;

    public E read(Serializable id);

    public E update(E transientObject) throws DuplicateObjectException, InvalidValueException, StampMismatchException;

    public void delete(E persistentObject) throws ObjectInUseException;

    public boolean exists(Serializable id);

    public List<E> list();

    public Class<? extends E> getType();

}