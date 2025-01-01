package com.example.lostandfound.model.enums;

public enum Location {
    LIBRARY("Library"),
    CANTEEN("Canteen"),
    BLOCK_A1("A1"),
    BLOCK_A2("A2"),
    PARKING_AREA("Parking Area"),
    CENTRAL_LIBRARY("Central Library"),
    ER_INSTITUTE("ER Institute");

    private final String displayName;

    Location(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
