package com.example.lostandfound.service;

import com.example.lostandfound.model.Match;

public interface MatchService {
    Match createMatch(int lostItemId, int foundItemId);
}
