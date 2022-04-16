package com.konecta.controller;



import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.konecta.dao.LogDAO;
import com.konecta.dao.ProductDAO;
import com.konecta.model.Log;
import com.konecta.model.Product;

@ManagedBean(name = "productoBean")
@RequestScoped
public class ProductBean {

	public String create() {
		Product p = new Product();
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", p);
		
		return "/faces/create.xhtml";
	}
	public String save(Product product) {
		ProductDAO productDAO = new ProductDAO();
		productDAO.save(product);
		return "/faces/index.xhtml";
	}
	
	public String sell(Product product, Log log) {
		LogDAO logDAO = new LogDAO();
		ProductDAO productDAO = new ProductDAO();
		
		
		Integer stock = product.getStock();
		
		if(stock <= 0 ) {
			return "/faces/index.xhtml";
		}else {
			Integer quantity = log.getQuantity();
			Integer price = product.getPrice();
			Long product_id = product.getId();
			
			Integer totalPrice = (price*quantity);
			
			log.setPrice(totalPrice);
			log.setProduct_id(product_id);
			log.setQuantity(quantity);
			
			logDAO.save(log);
			
			Integer totalStock = (stock - quantity);
			
			product.setStock(totalStock);
			
			productDAO.edit(product);
			
			return "/faces/index.xhtml";
		}
		
	}
	
	public List<Product> obtenerProductos(){
		ProductDAO productDAO = new ProductDAO();
		
		
			
		return productDAO.getProducts();
	}
	
	public String edit(Long id) {
		ProductDAO productDAO = new ProductDAO();
		Product p = new Product();
		p= productDAO.search(id);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", p);
		
		return "/faces/editar.xhtml";
	}
	
	public String update(Product product) {
		ProductDAO productDAO = new ProductDAO();
		productDAO.edit(product);
		return "/faces/index.xhtml";
	}
	
	public String sellProduct(Long id) {
		ProductDAO productDAO = new ProductDAO();
		Product p = new Product();
		p= productDAO.search(id);
		
		
		Log l = new Log();
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("producto", p);
		
		Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("log", l);
		
		return "/faces/sell.xhtml";
	}
	
	
	
	public String delete(Long id) {
		ProductDAO productDAO = new ProductDAO();
		productDAO.delete(id);
		System.out.println("Producto eliminado");
		return "/faces/index.xhtml";
	}
	
	
}
