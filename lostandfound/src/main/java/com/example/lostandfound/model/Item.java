package com.example.lostandfound.model;

import java.util.Date;
import java.util.Locale.Category;
import java.util.Objects;

import com.example.lostandfound.model.enums.Location;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String itemName;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    private String status;

    @Temporal(TemporalType.DATE)
    private Date reportDate;

    @Enumerated(EnumType.STRING)
    private Location location;

    private String room;

    private String contactInfo; 

    private int reportedBy;

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public int getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(int reportedBy) {
        this.reportedBy = reportedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) &&
               Objects.equals(itemName, item.itemName) &&
               category == item.category &&
               Objects.equals(description, item.description) &&
               Objects.equals(status, item.status) &&
               Objects.equals(reportDate, item.reportDate) &&
               location == item.location &&
               Objects.equals(room, item.room) &&
               Objects.equals(contactInfo, item.contactInfo) &&
               Objects.equals(reportedBy, item.reportedBy);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, category, description, status, reportDate, location, room, contactInfo, reportedBy);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", reportDate=" + reportDate +
                ", location=" + location +
                ", room='" + room + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", reportedBy=" + reportedBy +
                '}';
    }
}