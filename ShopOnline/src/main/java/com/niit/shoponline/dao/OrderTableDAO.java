package com.niit.shoponline.dao;

import java.util.List;

import com.niit.shoponline.model.OrderTable;



public interface OrderTableDAO 
{
	
	public boolean save(OrderTable orderTable);
	public List<OrderTable> list(String userId);

}
