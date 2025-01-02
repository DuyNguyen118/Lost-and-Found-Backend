package com.example.lostandfound.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    private int lostItemId;

    private int foundItemId;

    @Temporal(TemporalType.DATE)
    private Date matchDate;

    // Getters and Setters
    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getLostItemId() {
        return lostItemId;
    }

    public void setLostItemId(int lostItemId) {
        if (lostItemId <= 0) {
            throw new IllegalArgumentException("Invalid lost item ID.");
        }
        this.lostItemId = lostItemId;
    }    

    public int getFoundItemId() {
        return foundItemId;
    }

    public void setFoundItemId(int foundItemId) {
        if (foundItemId <= 0) {
            throw new IllegalArgumentException("Invalid found item ID.");
        }
        this.foundItemId = foundItemId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Match match = (Match) o;
    return matchId == match.matchId &&
            lostItemId == match.lostItemId &&
            foundItemId == match.foundItemId;
}

@Override
public int hashCode() {
    return Objects.hash(matchId, lostItemId, foundItemId);
}

@Override
public String toString() {
    return "Match{" +
            "matchId=" + matchId +
            ", lostItemId=" + lostItemId +
            ", foundItemId=" + foundItemId +
            ", matchDate=" + matchDate +
            '}';
}

}
