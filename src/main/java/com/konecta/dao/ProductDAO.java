package com.konecta.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.konecta.model.Product;
import com.konecta.model.JPAUtil;


public class ProductDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	//Save Product
	public void save(Product product) {
		entity.getTransaction().begin();
		entity.persist(product);
		entity.getTransaction().commit();
		
	}
	
	//Edit Product
	public void edit(Product product) {
		entity.getTransaction().begin();
		entity.merge(product);
		entity.getTransaction().commit();
		
	}
	
	// Search Product
	public Product search(Long id) {
		Product p = new Product();
		p = entity.find(Product.class, id);
		
		return p;
	}
	
	//Show Products
	
	
	public List<Product> getProducts(){
		List<Product> listProducts = new ArrayList<>();
		Query q = entity.createQuery("SELECT p FROM Product p");
		listProducts = q.getResultList();
		return listProducts;
	}
	
	//Delete product
	public void delete(Long id) {
		Product p = new Product();
		p = entity.find(Product.class, id);
		entity.getTransaction().begin();
		entity.remove(p);
		entity.getTransaction().commit();
	}
	
	public List<Product> maxStock(){
		List<Product> listProducts = new ArrayList<>();
		Query q = entity.createQuery("SELECT p.name,p.category,MAX(p.stock) FROM Product p");
		listProducts = q.getResultList();
		return listProducts;
	}
	
	
}
