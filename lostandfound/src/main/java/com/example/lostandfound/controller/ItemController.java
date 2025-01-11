package com.example.lostandfound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.enums.Category;
import com.example.lostandfound.model.enums.Location;
import com.example.lostandfound.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Report a new item
    @PostMapping("/report")
    public Item reportItem(@RequestBody Item item) {
        return itemService.reportItem(item);
    }

    // Get item details by ID
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    // Get all reported items
    @GetMapping("/list")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Get lost items
    @GetMapping("/lost")
    public List<Item> getLostItems() {
        return itemService.getLostItems();
    }

    // Get found items
    @GetMapping("/found")
    public List<Item> getFoundItems() {
        return itemService.getFoundItems();
    }

    // Update item details
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    // Delete an item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return "Item deleted successfully.";
    }

    // Search items by keyword
    @GetMapping("/search")
    public List<Item> searchItems(@RequestParam String keyword) {
        return itemService.searchItems(keyword);
    }

    // Get items by location
    @GetMapping("/by-location")
    public List<Item> getItemsByLocation(@RequestParam Location location) {
        return itemService.findItemsByLocation(location);
    }

    // Get items by category
    @GetMapping("/by-category")
    public List<Item> getItemsByCategory(@RequestParam Category category) {
        return itemService.findItemsByCategory(category);
    }
}
