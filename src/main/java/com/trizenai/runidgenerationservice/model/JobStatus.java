package com.trizenai.runidgenerationservice.model;

/**
 * TODO: fields confirmed from OrderService.sendNumericRunId() call sites
 * (setStatusURI, setNumericRunId, getAlphanumericRunId, getNumericRunId);
 * there may be more fields — confirm against the real decompiled source.
 */
public class JobStatus {

    private String statusURI;
    private Integer numericRunId;
    private String alphanumericRunId;

    public String getStatusURI() {
        return statusURI;
    }

    public void setStatusURI(String statusURI) {
        this.statusURI = statusURI;
    }

    public Integer getNumericRunId() {
        return numericRunId;
    }

    public void setNumericRunId(Integer numericRunId) {
        this.numericRunId = numericRunId;
    }

    public String getAlphanumericRunId() {
        return alphanumericRunId;
    }

    public void setAlphanumericRunId(String alphanumericRunId) {
        this.alphanumericRunId = alphanumericRunId;
    }
}
