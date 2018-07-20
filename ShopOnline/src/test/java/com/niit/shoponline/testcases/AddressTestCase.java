package com.niit.shoponline.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoponline.dao.AddressDAO;
import com.niit.shoponline.model.Address;


public class AddressTestCase 
{

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static AddressDAO addressDAO;

	@Autowired
	static Address address;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		addressDAO = (AddressDAO) context.getBean("addressDAO");

		address = (Address) context.getBean("address");

	}

	
	@Ignore
	@Test
	public void createAddressTestCase() {
		address.setId("2");
		address.setUser_id("Lakshmi");
		address.setH_no("5-78");
		address.setStreet("Sai Enclave");
		address.setCity("Kerala");
		address.setCountry("India");
		address.setPin("500002");

		boolean flag = addressDAO.save(address);

		assertEquals("createAddressTestCase", true, flag);

	}
    @Ignore
	@Test
	public void updateAddressTestCase() {
		address.setId("SurenderAddress");
		address.setUser_id("Surender");
		address.setH_no("185");
		address.setStreet("Road No. 4");
		address.setCity("Bramguda");
		address.setCountry("India");
		address.setPin("502032");

		boolean flag = addressDAO.update(address);

		assertEquals("createAddressTestCase", true, flag);

	}
    @Ignore
	@Test
	public void listAllAddressTestCase() 
    {
		int actualSize = addressDAO.list().size();
		assertEquals(2, actualSize);
	}

}
