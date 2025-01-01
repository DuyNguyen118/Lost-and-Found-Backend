package com.example.lostandfound.service;

<<<<<<< Updated upstream
import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.enums.Location;

=======
>>>>>>> Stashed changes
import java.util.List;

import com.example.lostandfound.model.Item;

public interface ItemService {
    Item reportItem(Item item);
    Item getItemById(Integer id);
    Item updateItem(Integer id, Item item);
    void deleteItem(Integer id);
    List<Item> getAllItems();
<<<<<<< Updated upstream
    List<Item> findItemsByLocation(Location location);
}
=======
    List<Item> getLostItems();
    List<Item> getFoundItems();
    List<Item> searchItems(String keyword);
}
>>>>>>> Stashed changes
