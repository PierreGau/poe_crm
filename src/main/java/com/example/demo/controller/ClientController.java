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
import com.example.demo.service.ClientDirectory;

@RestController
@RequestMapping("api")
public class ClientController 
{
	@Autowired
	ClientDirectory clientDirectory;
	
	@GetMapping("clients")
	public List<Client> getClients()
	{
		return clientDirectory.getClients();
	}
	
	@GetMapping("client/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id")Long _id)
	{		
		Optional<Client> o = clientDirectory.getClient(Math.toIntExact(_id));
		
		if(o.isPresent())		
			return ResponseEntity.ok(o.get());			
		else
			return ResponseEntity.notFound().build();
	}
	
	@PostMapping("client")
	public Client postClient(@RequestBody Client client)
	{
		clientDirectory.add(client);
		return client;
	}
	
	@DeleteMapping("client/{id}")
	public ResponseEntity<Client> Delete(@PathVariable("id")Long _id)
	{	
		boolean success = clientDirectory.deleteClient(_id);
		
		if(success)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("client/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable("id") Long id)
	{	
		if(client.getId().equals(id))
		{
			boolean success = clientDirectory.updateClient(client);
			if(success)
				return ResponseEntity.ok().build();
			else
				return ResponseEntity.notFound().build();				
		}

		return ResponseEntity.badRequest().build();
	}
}
