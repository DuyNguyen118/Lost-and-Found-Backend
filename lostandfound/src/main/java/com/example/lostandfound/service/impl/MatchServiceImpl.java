package com.example.lostandfound.service.impl;

import com.example.lostandfound.model.Match;
import com.example.lostandfound.repository.MatchRepository;
import com.example.lostandfound.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public Match createMatch(int lostItemId, int foundItemId) {
        Match match = new Match();
        match.setLostItemId(lostItemId);
        match.setFoundItemId(foundItemId);
        match.setMatchDate(new java.util.Date());
        return matchRepository.save(match);
    }
}
