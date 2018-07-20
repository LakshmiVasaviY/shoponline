package com.niit.shoponline.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoponline.dao.My_CartDAO;
import com.niit.shoponline.dao.ProductDAO;
import com.niit.shoponline.model.My_Cart;
import com.niit.shoponline.model.Product;


public class My_CartTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	static My_CartDAO my_CartDAO;
	@Autowired
	static My_Cart my_Cart;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		//get the categoryDAO from context
		my_CartDAO =  (My_CartDAO) context.getBean("my_CartDAO");
		
		//get the category from context
		my_Cart = (My_Cart)context.getBean("my_Cart");
		
	}
	
	@Ignore
	@Test
	public void createCartTestCase() {
		my_Cart.setUser_id("Lakshmi");
		my_Cart.setPrice(12000);
		my_Cart.setProduct_name("Samsung Galaxy S7 Mobile");
		
		boolean flag = my_CartDAO.save(my_Cart);
		
		assertEquals("createCartTestCase",true,flag);
	}
	@Ignore
	@Test
	public void deleteCartTestCase(){
		boolean flag = my_CartDAO.deleteAllProductsInCart("IsaacDV");
		
		assertEquals(true, flag);
	}
	

}
