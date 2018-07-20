package com.niit.shoponline.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoponline.dao.OrderTableDAO;
import com.niit.shoponline.model.OrderTable;



public class OrderTableTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static OrderTable orderTable;
	
	@Autowired
	static OrderTableDAO orderTableDAO;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		orderTableDAO =  (OrderTableDAO) context.getBean("orderTableDAO");
		
		
		orderTable = (OrderTable)context.getBean("orderTable");
		
	}
	
	
	@Ignore
	@Test
	public void createOrderTableTestCase(){
		orderTable.setId(2);
		orderTable.setUser_id("Lakshmi");
		orderTable.setStatus("N");
		boolean flag = orderTableDAO.save(orderTable);
		assertEquals("createOrderTableTestCase", true, flag);
	}
	@Ignore
	@Test
	public void listTestCase(){
		int orderedSize = orderTableDAO.list("IsaacDV").size();
		assertEquals(1, orderedSize);
	}

}
