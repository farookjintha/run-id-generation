package com.trizenai.runidgenerationservice.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {

    private String folder;
    private String application;
    private String subapplication;
    private String ctm;
    private String jobs;
    private String ignoreCriteria;
    private String orderDate;
    private String hold;
    private String orderIntoFolder;
    private String waitForOrderDate;
    private ArrayList<HashMap<String, String>> variables;

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getSubapplication() {
        return subapplication;
    }

    public void setSubapplication(String subapplication) {
        this.subapplication = subapplication;
    }

    public String getCtm() {
        return ctm;
    }

    public void setCtm(String ctm) {
        this.ctm = ctm;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getIgnoreCriteria() {
        return ignoreCriteria;
    }

    public void setIgnoreCriteria(String ignoreCriteria) {
        this.ignoreCriteria = ignoreCriteria;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getHold() {
        return hold;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public String getOrderIntoFolder() {
        return orderIntoFolder;
    }

    public void setOrderIntoFolder(String orderIntoFolder) {
        this.orderIntoFolder = orderIntoFolder;
    }

    public String getWaitForOrderDate() {
        return waitForOrderDate;
    }

    public void setWaitForOrderDate(String waitForOrderDate) {
        this.waitForOrderDate = waitForOrderDate;
    }

    public ArrayList<HashMap<String, String>> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<HashMap<String, String>> variables) {
        this.variables = variables;
    }
}
