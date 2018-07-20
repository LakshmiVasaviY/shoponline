package com.niit.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoponline.dao.CategoryDAO;
import com.niit.shoponline.dao.ContactDAO;
import com.niit.shoponline.dao.ProductDAO;
import com.niit.shoponline.dao.SupplierDAO;
import com.niit.shoponline.model.Category;
import com.niit.shoponline.model.Contact;
import com.niit.shoponline.model.Product;
import com.niit.shoponline.model.Supplier;



@Controller
public class AdminController 
{
	@Autowired HttpSession session;
	@Autowired Category category;
	@Autowired CategoryDAO categoryDAO;
	@Autowired Supplier supplier;
	@Autowired SupplierDAO supplierDAO;
	@Autowired Product product;
	@Autowired ProductDAO productDAO;
	@Autowired Contact contact;
	@Autowired ContactDAO contactDAO;
	
	private static Logger log = LoggerFactory.getLogger(AdminController.class); 
	

	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories() {
		log.debug("Starting of the method manageCategories");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);
		session.setAttribute("isUserLoggedIn", "false");
		log.debug("Ending of the method manageCategories");
		return mv;
	}
	
	
	@RequestMapping("/manageSuppliers")
	public ModelAndView manageSuppliers() {
		log.debug("Ending of the method manageSuppliers");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedSuppliers", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("supplier", supplier);
		session.setAttribute("isUserLoggedIn", "false");
		log.debug("Ending of the method manageSuppliers");

		return mv;
	}
	
	@RequestMapping("/manageContactUs")
	public ModelAndView manageContactUs() {
		log.debug("Starting of the method manageContactUs");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedContactUs", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("contactUsList", contactDAO.list());
		session.setAttribute("contact", contact);
		log.debug("Ending of the method manageContactUs");
		
		return mv;
	}
}
