package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Item;
import com.app.repository.ItemRepository;

@Service
public class ItemService {

	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item SaveItem(Item item)
	{
		return itemRepository.save(item);
		
	}
	
	
	public Item getItemById(int id)
	{
		return itemRepository.findById(id).get();
		
	}
}
