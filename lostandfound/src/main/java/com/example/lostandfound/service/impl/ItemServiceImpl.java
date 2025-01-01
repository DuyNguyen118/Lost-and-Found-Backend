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
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Integer id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
    }

    @Override
    public Item updateItem(Integer id, Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Updated item cannot be null");
        }

        Item existingItem = getItemById(id);

        // Update fields
        if (item.getItemName() != null) existingItem.setItemName(item.getItemName());
        if (item.getCategories() != null) existingItem.setCategories(item.getCategories());
        if (item.getDescription() != null) existingItem.setDescription(item.getDescription());
        if (item.getLocation() != null) existingItem.setLocation(item.getLocation());
        if (item.getRoom() != null) existingItem.setRoom(item.getRoom());
        if (item.getStatus() != null) existingItem.setStatus(item.getStatus());
        if (item.getContactInfo() != null) existingItem.setContactInfo(item.getContactInfo());
        if (item.getReportDate() != null) existingItem.setReportDate(item.getReportDate());
        if (item.getReportedBy() != null) existingItem.setReportedBy(item.getReportedBy());

        return itemRepository.save(existingItem);
    }

    @Override
    public void deleteItem(Integer id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete item. Item not found with id: " + id);
        }
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

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
        return itemRepository.searchItems(keyword);  // Ensure repository has this method
    }

    @Override
    public List<Item> findItemsByLocation(Location location) {
        return itemRepository.findByLocation(location); // Ensure repository has this method
    }
}
