package com.example.lostandfound.model;

import java.util.Date;
import java.util.Objects;

import com.example.lostandfound.model.enums.Location;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    @NotBlank
    @Column(name = "item_name")
    private String itemName;

    @Column(name = "categories")
    private String categories;

    @Column(name = "description", length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "location")
    private Location location;

    @Embedded
    private Room room;

    @Column(name = "status")
    private String status;

    @Column(name = "contact_info")
    private String contactInfo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "reported_by")
    private Long reportedBy;

    // Default constructor
    public Item() {
        this.reportDate = new Date();
    }

    // Getters and Setters
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Long getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(Long reportedBy) {
        this.reportedBy = reportedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) &&
                Objects.equals(itemName, item.itemName) &&
                Objects.equals(categories, item.categories) &&
                Objects.equals(description, item.description) &&
                location == item.location &&
                Objects.equals(room, item.room) &&
                Objects.equals(status, item.status) &&
                Objects.equals(contactInfo, item.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, categories, description, location, room, status, contactInfo);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", categories='" + categories + '\'' +
                ", description='" + description + '\'' +
                ", location=" + location +
                ", room=" + room +
                ", status='" + status + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", reportDate=" + reportDate +
                ", reportedBy=" + reportedBy +
                '}';
    }
}