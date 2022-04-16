package com.konecta.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.konecta.model.JPAUtil;
import com.konecta.model.Log;

public class LogDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void save(Log log) {
		entity.getTransaction().begin();
		entity.persist(log);
		entity.getTransaction().commit();
	}
	
	public List<Log> getLogs(){
		List<Log> logsList = new ArrayList<>();
		Query q = entity.createQuery("SELECT l From Log l");
		logsList = q.getResultList();
		return logsList;
	}
	
	
	
}
