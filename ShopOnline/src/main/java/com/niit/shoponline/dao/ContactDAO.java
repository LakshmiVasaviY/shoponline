package com.niit.shoponline.dao;

import java.util.List;

import com.niit.shoponline.model.Contact;



public interface ContactDAO 
{
	
	
	public  boolean save(Contact contact);
	
	public boolean delete(int id);
	
	public List<Contact> list();
	
	public Contact getContactById(int id);
	
}
