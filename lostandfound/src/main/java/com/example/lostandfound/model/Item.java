package com.example.lostandfound.model;

import com.example.lostandfound.model.enums.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

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
    @Column(name = "block")
    private Location block;

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
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
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

    public Location getBlock() {
        return block;
    }

    public void setBlock(Location block) {
        this.block = block;
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
                block == item.block &&
                Objects.equals(room, item.room) &&
                Objects.equals(status, item.status) &&
                Objects.equals(contactInfo, item.contactInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemName, categories, description, block, room, status, contactInfo);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", categories='" + categories + '\'' +
                ", description='" + description + '\'' +
                ", block=" + block +
                ", room=" + room +
                ", status='" + status + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", reportDate=" + reportDate +
                ", reportedBy=" + reportedBy +
                '}';
    }
}