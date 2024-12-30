package com.example.lostandfound.model;

import java.util.Objects;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AdminActions")
public class AdminAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionId;

    private int adminId;

    private String actionType;

    @Temporal(TemporalType.DATE)
    private Date actionDate;

    private String details;

    // Getters and Setters
    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AdminAction that = (AdminAction) o;
    return actionId == that.actionId &&
            adminId == that.adminId &&
            Objects.equals(actionType, that.actionType) &&
            Objects.equals(details, that.details);
}

@Override
public int hashCode() {
    return Objects.hash(actionId, adminId, actionType, details);
}

@Override
public String toString() {
    return "AdminAction{" +
            "actionId=" + actionId +
            ", adminId=" + adminId +
            ", actionType='" + actionType + '\'' +
            ", actionDate=" + actionDate +
            ", details='" + details + '\'' +
            '}';
}

}
