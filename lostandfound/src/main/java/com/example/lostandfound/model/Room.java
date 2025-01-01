package com.example.lostandfound.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class Room {
    @NotBlank(message = "Room number/name cannot be empty")
    @Pattern(regexp = "^[A-Za-z0-9-. ]{1,20}$", 
            message = "Room should only contain letters, numbers, dots, dashes, and spaces, with maximum length of 20 characters")
    @Column(name = "room_number")
    private String roomNumber;

    // Default constructor required by JPA
    public Room() {
    }

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return roomNumber.equals(room.roomNumber);
    }

    @Override
    public int hashCode() {
        return roomNumber.hashCode();
    }
}
