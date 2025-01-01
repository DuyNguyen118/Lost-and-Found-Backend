package com.example.lostandfound.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.enums.Location;
import com.example.lostandfound.repository.ItemRepository;
import com.example.lostandfound.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item reportItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Integer id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
    }

    @Override
    public Item updateItem(Integer id, Item item) {
        Item existingItem = getItemById(id);
        
        // Update all fields from the new item model
        existingItem.setItemName(item.getItemName());
        existingItem.setCategories(item.getCategories());
        existingItem.setDescription(item.getDescription());
        existingItem.setBlock(item.getBlock());
        existingItem.setRoom(item.getRoom());
        existingItem.setStatus(item.getStatus());
        existingItem.setContactInfo(item.getContactInfo());
        existingItem.setReportDate(item.getReportDate());
        existingItem.setReportedBy(item.getReportedBy());
        
        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
<<<<<<< Updated upstream

    @Override
    public List<Item> findItemsByLocation(Location location) {
        return itemRepository.findByLocation(location);
    }
}
=======
    
    // Additional methods that might be useful for your UI
    
    @Override
    public List<Item> getLostItems() {
        return itemRepository.findByStatus("LOST");
    }
    
    @Override
    public List<Item> getFoundItems() {
        return itemRepository.findByStatus("FOUND");
    }
    
    @Override
    public List<Item> searchItems(String keyword) {
        return itemRepository.searchItems(keyword);    }
}
>>>>>>> Stashed changes
