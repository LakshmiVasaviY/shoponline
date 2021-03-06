package com.niit.shoponline.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoponline.dao.SupplierDAO;
import com.niit.shoponline.model.Supplier;


public class SupplierTestCase 
{

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		
		supplier = (Supplier) context.getBean("supplier");

	}

	@Ignore
	@Test
	public void createSupplierTestCase() {
		supplier.setId("1");
		supplier.setName("Lenovo");
		supplier.setAddress("HSR Layout, Hyderabad");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);

	}
    @Ignore
	@Test
	public void updateSupplierTestCase() {
		supplier.setId("SUPP1");
		supplier.setName("Sangeetha");
		supplier.setAddress("Mumbai");

		boolean flag = supplierDAO.update(supplier);

		assertEquals("updateSupplierTestCase", true, flag);

	}
    @Ignore
	@Test
	public void listAllSupplierTestCase() 
    {
		int actualSize = supplierDAO.list().size();
		assertEquals(6, actualSize);
	}

}
