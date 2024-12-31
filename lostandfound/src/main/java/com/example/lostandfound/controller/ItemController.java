package com.example.lostandfound.controller;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    // Get all reported items
    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Update item details
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    // Delete an item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "Item deleted successfully.";
    }
}
