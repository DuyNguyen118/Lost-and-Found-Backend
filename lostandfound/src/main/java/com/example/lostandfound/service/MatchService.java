package com.example.lostandfound.service;

import java.util.List;

import com.example.lostandfound.model.Item;
import com.example.lostandfound.model.Match;

public interface MatchService {
    Match createMatch(int lostItemId, int foundItemId);
     /**
     * Suggests potential matches for a given item based on specified criteria.
     *
     * @param itemId   the ID of the item for which matches are being searched
     * @param itemType the type of the item ("lost" or "found")
     * @return a list of items that match the criteria
     */
    List<Item> suggestMatches(int itemId, String itemType);
}
