package com.example.lostandfound.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.Match;
import com.example.lostandfound.repository.ItemRepository;
import com.example.lostandfound.repository.MatchRepository;
import com.example.lostandfound.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Match createMatch(int itemId1, int itemId2) {
        // Fetch items
        Item item1 = itemRepository.findById(itemId1)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId1));
        Item item2 = itemRepository.findById(itemId2)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId2));
    
        // Validate opposite statuses
        if ((item1.getStatus().equalsIgnoreCase("lost") && item2.getStatus().equalsIgnoreCase("found"))
                || (item1.getStatus().equalsIgnoreCase("found") && item2.getStatus().equalsIgnoreCase("lost"))) {
            // Save match
            Match match = new Match();
            match.setLostItemId(item1.getStatus().equalsIgnoreCase("lost") ? item1.getItemId() : item2.getItemId());
            match.setFoundItemId(item1.getStatus().equalsIgnoreCase("found") ? item1.getItemId() : item2.getItemId());
            match.setMatchDate(new Date());
            return matchRepository.save(match);
        } else {
            throw new IllegalArgumentException("Items must have opposite statuses (one lost and one found).");
        }
    }
    
    @Override
    public List<Item> suggestMatches(int itemId, String itemType) {
        // Fetch the item
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));
    
        // Define the opposite type based on the status of the current item
        String oppositeType = itemType.equalsIgnoreCase("lost") ? "found" : "lost";
    
        // Find potential matches using repository queries
        List<Item> potentialMatches = itemRepository.findAll().stream()
                .filter(i -> !i.getItemId().equals(itemId)) // Exclude the same item
                .filter(i -> i.getStatus().equalsIgnoreCase(oppositeType)) // Opposite status
                .filter(i -> i.getCategory().equalsIgnoreCase(item.getCategory())) // Match category
                .filter(i -> i.getLocation().equals(item.getLocation())) // Match location
                .collect(Collectors.toList());
    
        return potentialMatches;
    }
}
