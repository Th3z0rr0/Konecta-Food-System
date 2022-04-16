package com.konecta.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="logs")
public class Log {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long product_id;
	@Column
	private Integer quantity;
	@Column
	private Integer price;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date sell_at;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getSell_at() {
		return sell_at;
	}
	public void setSell_at(Date sell_at) {
		this.sell_at = sell_at;
	}
	
	@Override
	public String toString() {
		return "Log [id=" + id + ", product_id=" + product_id + ", quantity=" + quantity + ", price=" + price
				+ ", sell_at=" + sell_at + "]";
	}
	
	
}
