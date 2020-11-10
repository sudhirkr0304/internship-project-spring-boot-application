package com.example.internshipproject.exceptions;

import java.util.Date;

/**
 * @author sudhir kumar
 * @date - 11-11-2020
 */
public class ErrorResponse {

    private Date timestamp;
    private String status;
    private String details;
    private String message;

    public ErrorResponse() {

    }

    public ErrorResponse(Date timestamp, String status, String details, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.details = details;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
