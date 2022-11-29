package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Order;

@Service
public class OrderDirectory {
	@Autowired
	OrderRepository or;
	
	public void add(Order order)
	{
		or.save(order);
	}
	
	public void add(List<Order> order)
	{
		or.saveAll(order);
	}
	
	public List<Order> getOrders()
	{	
		return or.findAll();
	}
	
	public Optional<Order> getOrder(Long _id)
	{
		return or.findById(Long.valueOf(_id));
	}
	
	/**Renvoie true si l'id existait*/
	public boolean deleteOrder(Long _id)
	{
		boolean b = or.existsById(Long.valueOf(_id));
		if(b)
			or.deleteById(Long.valueOf(_id));
		return b;
	}
	
	/**Renvoie true si l'id existait*/
	public boolean updateOrder(Order order)
	{
		boolean b = or.existsById(order.getId());
		if(b)
			or.save(order);
		
		return b;
	}
}
