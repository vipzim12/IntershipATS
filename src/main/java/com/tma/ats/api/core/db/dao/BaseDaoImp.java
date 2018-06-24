package com.tma.ats.api.core.db.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.tma.ats.api.core.exception.DuplicateObjectException;
import com.tma.ats.api.core.exception.InvalidValueException;
import com.tma.ats.api.core.exception.ObjectInUseException;
import com.tma.ats.api.core.exception.StampMismatchException;

public abstract class BaseDaoImp<E extends Indexable> implements BaseDao<E> {

	@PersistenceContext
	protected EntityManager em;

	Logger logger = Logger.getLogger(BaseDaoImp.class);

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public final E create(E newInstance) throws DuplicateObjectException,
			InvalidValueException {
		try {
			em.persist(newInstance);
			em.flush();
			return newInstance;
		} catch (PersistenceException e) {
			if (e.getCause() != null) {
				if (e.getCause()
						.getClass()
						.getName()
						.equals("org.hibernate.exception.ConstraintViolationException")) {
					if (e.getCause().getMessage().startsWith("Duplicate entry")) {
						logger.info("DuplicateObjectException: "
								+ e.getCause().getMessage());
						throw new DuplicateObjectException(e.getCause()
								.getMessage());
					}
				} else if (e.getCause().getClass().getName()
						.equals("org.hibernate.exception.DataException")) {
					logger.info("InvalidValueException: "
							+ e.getCause().getMessage());
					throw new InvalidValueException(e.getMessage());
				}
			}
			throw e;
		}
	}

	public final void delete(E persistentObject) throws ObjectInUseException {
		try {
			em.remove(em.merge(persistentObject));
			em.flush();
		} catch (PersistenceException e) {
			if (e.getCause() != null) {
				if (e.getCause()
						.getClass()
						.getName()
						.equals("org.hibernate.exception.ConstraintViolationException")) {
					logger.info("ObjectInUseException: "
							+ e.getCause().getMessage());
					throw new ObjectInUseException();
				}
			}
			throw e;
		}
	}

	public E read(Serializable id) {
		return em.find(getType(), id);
	}

	public boolean exists(Serializable id) {
		return (null != read(id));
	}

	public E update(E transientObject) throws DuplicateObjectException,
			InvalidValueException, StampMismatchException {
		try {
			em.merge(transientObject);
			em.flush();
			return transientObject;
		} catch (PersistenceException e) {
			if (e.getCause() != null) {
				if (e.getCause()
						.getClass()
						.getName()
						.equals("org.hibernate.exception.ConstraintViolationException")) {
					if (e.getCause().getMessage().startsWith("Duplicate entry")) {
						logger.info("DuplicateObjectException: "
								+ e.getCause().getMessage());
						throw new DuplicateObjectException(e.getCause()
								.getMessage());
					}
				} else if (e.getCause().getClass().getName()
						.equals("org.hibernate.exception.DataException")) {
					logger.info("InvalidValueException: "
							+ e.getCause().getMessage());
					throw new InvalidValueException(e.getMessage());
				}
			}
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<E> list() {
		Query qry = em.createQuery("from " + getType().getSimpleName() + " u");
		return qry.getResultList();
	}

}
