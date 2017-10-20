package com.eb.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {

		return sessionFactory.getCurrentSession();

	}

	public Long Save(Object entity) {

		return (Long) getSession().save(entity);

	}

	public void persist(Object entity) {

		getSession().persist(entity);
	}

	public void delete(Object entity) {

		getSession().delete(entity);

	}

	public void saveOrUpdate(Object entity) {

		getSession().saveOrUpdate(entity);

	}

	public Object getEntity(String hqlQuery) {

		Query query = getSession().createQuery(hqlQuery);
		return query.list();

	}

	public List<Object> getEntity(String hqlQuery, Object[] inputs) {
		System.out.println("about to execute ");

		Query query = getSession().createQuery(hqlQuery);

		for (int i = 0; i < inputs.length; i++) {
			System.out.println(i + "-->" + inputs[i]);
			query.setParameter(i, inputs[i]);
		}

		return query.list();
	}

}
