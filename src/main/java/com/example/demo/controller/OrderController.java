package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.model.Order;
import com.example.demo.service.OrderDirectory;

@RestController
@RequestMapping("api")
public class OrderController
{
	@Autowired
	OrderDirectory orderDirectory;
	
	@GetMapping("orders")
	public List<Order> getOrders()
	{
		return orderDirectory.getOrders();
	}
	
	@GetMapping("order/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable("id")Long _id)
	{		
		Optional<Order> o = orderDirectory.getOrder(_id);
		
		if(o.isPresent())		
			return ResponseEntity.ok(o.get());			
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("order")
	public Order postOrder(@RequestBody Order order)
	{
		orderDirectory.add(order);
		return order;
	}
	
	@DeleteMapping("order/{id}")
	public ResponseEntity<Client> Delete(@PathVariable("id")Long _id)
	{	
		boolean success = orderDirectory.deleteOrder(_id);
		
		if(success)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("order/{id}")
	public ResponseEntity<Client> updateOrder(@RequestBody Order order, @PathVariable("id") Long id)
	{	
		if(order.getId().equals(id))
		{
			boolean success = orderDirectory.updateOrder(order);
			if(success)
				return ResponseEntity.ok().build();
			else
				return ResponseEntity.notFound().build();				
		}

		return ResponseEntity.badRequest().build();
	}
}
