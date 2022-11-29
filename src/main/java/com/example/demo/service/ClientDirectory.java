package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.model.Client;

@Service
public class ClientDirectory 
{
	@Autowired
	ClientRepository cr;
	
	public void add(Client client)
	{
		cr.save(client);
	}
	
	public void add(List<Client> clients)
	{
		cr.saveAll(clients);
	}
	
	public List<Client> getClients()
	{	
		return cr.findAll();
	}
	
	public Optional<Client> getClient(int _id)
	{
		return cr.findById(Long.valueOf(_id));
	}
	
	/**Renvoie true si l'id existait*/
	public boolean deleteClient(int _id)
	{
		boolean b = cr.existsById(Long.valueOf(_id));
		if(b)
			cr.deleteById(Long.valueOf(_id));
		return b;
	}
	
	
	/**Renvoie true si l'id existait*/
	public boolean updateClient(Client client)
	{
		boolean b = cr.existsById(Long.valueOf(client.getId()));
		if(b)
			cr.save(client);
		
		return b;
	}
}
