package com.niit.shoponline.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoponline.dao.ProductDAO;
import com.niit.shoponline.model.Product;



public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		product = (Product)context.getBean("product");
		
	}
	
	@Ignore
	@Test
	public void createProductTestCase()
	{
		
		product.setId("3");
		product.setCategory_id("2");
		product.setDescription("Samsung Galaxy S7 Gold Mobile");
		product.setName("Samsung Galaxy s7");
		product.setPrice(10000);
		product.setQuantity(5);
		product.setSupplier_id("2");
		
		boolean flag =  productDAO.saveOrUpdate(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	@Ignore
	@Test
	public void updateProductTestCase()
	{
		product.setId("PROD1");
		product.setName("Lenovo Yoga 500");
		product.setDescription("Lenovo Laptop");
		product.setCategory_id("1");
		product.setPrice(15000);
		product.setSupplier_id("SUPP1");
		product.setQuantity(2);
		boolean flag = productDAO.saveOrUpdate(product);
		assertEquals("update Product TestCase",true,flag);
	}
	@Ignore
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} 
}
