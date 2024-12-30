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
@Table(name = "Reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    private String reportType;

    @Temporal(TemporalType.DATE)
    private Date reportDate;

    private int itemId;

    private int userId;

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Report report = (Report) o;
    return reportId == report.reportId &&
            itemId == report.itemId &&
            userId == report.userId &&
            Objects.equals(reportType, report.reportType);
}

@Override
public int hashCode() {
    return Objects.hash(reportId, reportType, itemId, userId);
}

@Override
public String toString() {
    return "Report{" +
            "reportId=" + reportId +
            ", reportType='" + reportType + '\'' +
            ", reportDate=" + reportDate +
            ", itemId=" + itemId +
            ", userId=" + userId +
            '}';
}

}
