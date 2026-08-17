package com.trizenai.runidgenerationservice.model;

/**
 * TODO: only statusURI confirmed so far, via OrderService.sendNumericRunId()
 * (orderResponse.getStatusURI()); this almost certainly has more fields
 * returned by the Control-M run-order API — confirm against the real
 * decompiled source.
 */
public class OrderResponse {

    private String statusURI;

    public String getStatusURI() {
        return statusURI;
    }

    public void setStatusURI(String statusURI) {
        this.statusURI = statusURI;
    }
}
