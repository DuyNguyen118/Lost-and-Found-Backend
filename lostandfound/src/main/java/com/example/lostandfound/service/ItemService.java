package com.example.lostandfound.service;

import com.example.lostandfound.model.Item;
import java.util.List;

public interface ItemService {
    Item reportItem(Item item);
    Item getItemById(Long id);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    List<Item> getAllItems();
}
