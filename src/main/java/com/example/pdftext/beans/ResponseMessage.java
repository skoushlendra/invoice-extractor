package com.example.pdftext.beans;

import java.util.Set;

public class ResponseMessage {
    private String message;
    private Set<String> orderIds;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(String message, Set<String> orderIds) {
        this.message = message;
        this.orderIds = orderIds;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(Set<String> orderIds) {
        this.orderIds = orderIds;
    }
}
