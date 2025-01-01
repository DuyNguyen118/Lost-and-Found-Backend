package com.example.lostandfound.service.impl;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.Match;
import com.example.lostandfound.repository.ItemRepository;
import com.example.lostandfound.repository.MatchRepository;
import com.example.lostandfound.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Match createMatch(int lostItemId, int foundItemId) {
        if (lostItemId == foundItemId) {
            throw new IllegalArgumentException("Lost and Found items cannot have the same ID.");
        }

        Match match = new Match();
        match.setLostItemId(lostItemId);
        match.setFoundItemId(foundItemId);
        match.setMatchDate(new Date());
        return matchRepository.save(match);
    }

    @Override
    public List<Item> suggestMatches(int itemId, String itemType) {
        // Fetch the item details
        Item item = itemRepository.findById((int) itemId)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId));

        // Define the opposite type
        String oppositeType = itemType.equalsIgnoreCase("lost") ? "found" : "lost";

        // Find potential matches
        List<Item> potentialMatches = itemRepository.findAll().stream()
                .filter(i -> !i.getItemId().equals(itemId)) // Exclude the same item
                .filter(i -> i.getStatus().equalsIgnoreCase(oppositeType)) // Match opposite type
                .filter(i -> i.getCategories().equals(item.getCategories())) // Match category
                .filter(i -> i.getLocation().equals(item.getLocation())) // Match location
                .collect(Collectors.toList());

        return potentialMatches;
    }
}
