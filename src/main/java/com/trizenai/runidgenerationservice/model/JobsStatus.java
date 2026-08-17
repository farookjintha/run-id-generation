package com.trizenai.runidgenerationservice.model;

import java.util.ArrayList;

/**
 * TODO: only getStatuses()/setStatuses() confirmed so far, via
 * RetryServiceImpl.retryCaptureJobIdByRunJobsAPI(); confirm against the
 * real decompiled source.
 */
public class JobsStatus {

    private ArrayList<RunJobsStatus> statuses;

    public ArrayList<RunJobsStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(ArrayList<RunJobsStatus> statuses) {
        this.statuses = statuses;
    }
}
