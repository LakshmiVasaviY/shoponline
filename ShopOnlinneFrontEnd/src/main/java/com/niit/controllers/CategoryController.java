package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoponline.dao.CategoryDAO;
import com.niit.shoponline.dao.ProductDAO;
import com.niit.shoponline.model.Category;
import com.niit.shoponline.model.Product;



@Controller
public class CategoryController {

	private static Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	HttpSession session;

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;

	@RequestMapping("/manage-category-add")
	public ModelAndView createCategory(@RequestParam("cId") String id, @RequestParam("cName") String name,
			@RequestParam("cDescription") String description) 
	{
		log.debug("Starting of create category");
		ModelAndView mv = new ModelAndView("Home");

		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		if (categoryDAO.getCategoryById(id) != null) 
		{
			mv.addObject("cMessage", "Category already exists with id : " + id);
			return mv;
		} 
		else 
		{
			categoryDAO.save(category);
			mv.addObject("cMessage", "Category creation success with id : " + id);

		}

		List<Category> categoryList = categoryDAO.list();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);
		session.setAttribute("isUserLoggedIn", "false");

		session.setAttribute("isAdminClickedManageCategoryEdit", "false");
		log.debug("Ending of create category");
		return mv;

	}

	@RequestMapping("/manage-category-delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id) {
		
		log.debug("Starting of delete Category");
		log.info("You are about to delete a category with id : " + id);
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		int noOfProducts = productDAO.getAllProductsByCategoryId(id).size();
		if(noOfProducts != 0){
			log.debug("Few products are there under this category, you cannot delete!");
			session.setAttribute("categoryMessage", "There are "+noOfProducts+" products under this "+id+" category, you cannot delete!");
			return mv;
		}
		
		
		if (categoryDAO.delete(id) == true) {
			mv.addObject("categoryMessage", "Successfullly deleted");
		} else {
			mv.addObject("categoryMessage", "Failed to delete");
		}
		log.debug("Ending of delete Category");
		
		return mv;
	}
	
	@RequestMapping("/manage-category-edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") String id){
		log.debug("Starting of editCategory");
		log.info("You are about to edit a category with id : " + id);
		
		category = categoryDAO.getCategoryById(id);
		
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");

		session.setAttribute("isAdminClickedManageCategoryEdit", "true");
		mv.addObject("selectedCategory", category);		
		session.setAttribute("selectedCategory", category);	
		
		log.debug("Ending of editCategory");

		return mv;
	}
	
	@RequestMapping("/manage-category-update")
	public ModelAndView updateCategory(@RequestParam("cId") String id, @RequestParam("cName") String name,
			@RequestParam("cDescription") String description) {
		log.debug("Starting of updateCategory");
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");
		session.setAttribute("isAdminClickedManageCategoryEdit", "false");	

		category.setId(id);
		category.setName(name);
		category.setDescription(description);

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		if (categoryDAO.getCategoryById(id) == null) {
			mv.addObject("cMessage", "Category does not exists with id : " + id);
			return mv;
		} else {
			categoryDAO.update(category);
			mv.addObject("cMessage", "Category updated success with id : " + id);

		}
		
		session.setAttribute("isAdminClickedManageCategoryEdit", "false");
		log.debug("Ending of updateCategory");
		
		return mv;
	}

}
