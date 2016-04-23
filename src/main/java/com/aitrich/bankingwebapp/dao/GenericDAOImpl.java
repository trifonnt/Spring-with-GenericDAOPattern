package com.aitrich.bankingwebapp.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * A DAO implementation for the {@link GenericDAO} using Hibernate.
 * All methods use {@link #getSession()} to get a {@link Session}.
 * 
 * @param <T> the entity class related to this DAO.
 * @param <ID> the type of the field that represents the entity class' primary key.
 * 
 * <h5>&copy;2014 All rights reserved.</h5>
 * </pre>
 * 
 * @author : JIJESH
 * @since : 06 April 2013
 * @version : 1.0
 * 
 * 
 */
@Repository("GenericDAO")
@Transactional
public abstract class GenericDAOImpl<T, ID extends Serializable>
        implements GenericDAO<T, ID>
{
	private static final long serialVersionUID = -5104946294490148817L;

	private Class<T> entityClass;

	private String entityClassName;

	@Autowired
	protected SessionFactory sessionFactory;

	/*@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;*/

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		Type genericSuperclass;
		Class<?> parametrizedClass = getClass();
		do {
			genericSuperclass = parametrizedClass.getGenericSuperclass();
			if (genericSuperclass instanceof Class) {
				parametrizedClass = (Class<?>) genericSuperclass;
			}
		} while (genericSuperclass != null
				&& !(genericSuperclass instanceof ParameterizedType));
		this.entityClass = (Class<T>) ((ParameterizedType) genericSuperclass)
				.getActualTypeArguments()[0];
		if (entityClass != null) {
			entityClassName = entityClass.getSimpleName();
		}
	}

	protected Session openSession() {
		return sessionFactory.openSession();
	}

	@SuppressWarnings("unchecked")
	protected T findByUniqueField(String fieldName, Object value) {
		return (T) openSession().createCriteria(entityClass)
				.add(Restrictions.eq(fieldName, value)).uniqueResult();
	}

	public void saveOrUpdateAll(Collection<T> entities) {
		Session session = openSession();
		for (T entity : entities) {
			session.saveOrUpdate(entity);
		}
	}

	public void saveOrUpdate(T entity) {
		openSession().saveOrUpdate(entity);
	}

	public void update(T entity) {
		openSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	public ID save(T entity) {
		return (ID) openSession().save(entity);
	}

	public void delete(T entity) {
		openSession().delete(entity);
	}

	public void delete(ID entityId) {
		Session session = openSession();
		Object entity = session.load(entityClass, entityId);
		session.delete(entity);
	}

	public void deleteAll() {
		openSession().createQuery("delete from " + entityClassName);
	}

	public void deleteAll(Collection<T> entities) {
		Session session = openSession();
		for (T entity : entities) {
			session.delete(entity);
		}
	}

	@SuppressWarnings("unchecked")
	public T merge(T entity) {
		return (T) openSession().merge(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) openSession().createQuery("from " + entityClassName)
				.list();
	}

	@SuppressWarnings("unchecked")
	public T findByPrimaryKey(ID entityId) {
		return (T) openSession().get(entityClass, entityId);
	}

	public void flush() {
		openSession().flush();
	}

	public void refresh(T entity) {
		openSession().refresh(entity);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void initProxy(Object proxy) {
		Hibernate.initialize(proxy);
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

}