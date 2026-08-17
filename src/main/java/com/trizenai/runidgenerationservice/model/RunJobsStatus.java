package com.trizenai.runidgenerationservice.model;

/**
 * TODO: only folderId/jobId confirmed so far, via RetryServiceImpl
 * (runJobsStatus.getFolderId()/getJobId()); likely has more fields —
 * confirm against the real decompiled source.
 */
public class RunJobsStatus {

    private String folderId;
    private String jobId;

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
