package com.trizenai.runidgenerationservice.model;

import java.util.ArrayList;

/**
 * TODO: only activeServices confirmed so far, via
 * OrderService.sendJobStatusBySLAApi() (slaServiceResponse.getActiveServices());
 * confirm against the real decompiled source.
 */
public class SLAServices {

    private ArrayList<ActiveService> activeServices;

    public ArrayList<ActiveService> getActiveServices() {
        return activeServices;
    }

    public void setActiveServices(ArrayList<ActiveService> activeServices) {
        this.activeServices = activeServices;
    }
}
