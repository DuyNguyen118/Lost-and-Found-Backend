package com.example.lostandfound.service;

import java.util.List;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.enums.Category;
import com.example.lostandfound.model.enums.Location;

public interface ItemService {
    Item reportItem(Item item);
    Item getItemById(Integer id);
    Item updateItem(Integer id, Item item);
    void deleteItem(Integer id);
    List<Item> getAllItems();
    List<Item> getLostItems();
    List<Item> getFoundItems();
    List<Item> searchItems(String keyword);
    List<Item> findItemsByLocation(Location location); 
    List<Item> findItemsByCategory(Category category); 

}
