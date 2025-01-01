package com.example.lostandfound.service.impl;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.enums.Location;
import com.example.lostandfound.repository.ItemRepository;
import com.example.lostandfound.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item reportItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item existingItem = getItemById(id);
        existingItem.setItemName(item.getItemName());
        existingItem.setCategory(item.getCategory());
        existingItem.setDescription(item.getDescription());
        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> findItemsByLocation(Location location) {
        return itemRepository.findByLocation(location);
    }
}
