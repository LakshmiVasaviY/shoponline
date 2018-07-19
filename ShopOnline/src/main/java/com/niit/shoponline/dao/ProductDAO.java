package com.niit.shoponline.dao;

import java.util.List;

import com.niit.shoponline.model.Product;



public interface ProductDAO 
{

	public boolean saveOrUpdate(Product product);

	public boolean delete(String id);

	public List<Product> list();

	public Product getProductById(String id);
	
	public List<Product> getAllProductsByCategoryId(String categoryId);
	public List<Product> getAllProductsBySupplierId(String supplierId);
	
	public Product getProductByName(String name);
	
	
}
