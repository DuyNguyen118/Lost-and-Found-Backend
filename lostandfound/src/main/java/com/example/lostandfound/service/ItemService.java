package com.example.lostandfound.service;

import com.example.lostandfound.model.Item;
import java.util.List;

public interface ItemService {
    Item reportItem(Item item);
    Item getItemById(Integer id);
    Item updateItem(Integer id, Item item);
    void deleteItem(Integer id);
    List<Item> getAllItems();
    List<Item> getLostItems();
    List<Item> getFoundItems();
    List<Item> searchItems(String keyword);
}