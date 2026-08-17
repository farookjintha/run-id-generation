package com.trizenai.runidgenerationservice.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderDTO {

    @SerializedName(value = "folder")
    @Expose
    private String folder;
    @SerializedName(value = "application")
    @Expose
    private String application;
    @SerializedName(value = "subapplication")
    @Expose
    private String subapplication;
    @SerializedName(value = "ctm")
    @Expose
    private String ctm;
    @SerializedName(value = "jobs")
    @Expose
    private String jobs;
    @SerializedName(value = "ignoreCriteria")
    @Expose
    private String ignoreCriteria;
    @SerializedName(value = "orderDate")
    @Expose
    private String orderDate;
    @SerializedName(value = "hold")
    @Expose
    private String hold;
    @SerializedName(value = "orderIntoFolder")
    @Expose
    private String orderIntoFolder;
    @SerializedName(value = "waitForOrderDate")
    @Expose
    private String waitForOrderDate;
    @SerializedName(value = "variables")
    @Expose
    private ArrayList<HashMap<String, String>> variables;

    public String getFolder() {
        return this.folder;
    }

    public String getApplication() {
        return this.application;
    }

    public String getSubapplication() {
        return this.subapplication;
    }

    public String getCtm() {
        return this.ctm;
    }

    public String getJobs() {
        return this.jobs;
    }

    public String getIgnoreCriteria() {
        return this.ignoreCriteria;
    }

    public String getOrderDate() {
        return this.orderDate;
    }

    public String getHold() {
        return this.hold;
    }

    public String getOrderIntoFolder() {
        return this.orderIntoFolder;
    }

    public String getWaitForOrderDate() {
        return this.waitForOrderDate;
    }

    public ArrayList<HashMap<String, String>> getVariables() {
        return this.variables;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public void setSubapplication(String subapplication) {
        this.subapplication = subapplication;
    }

    public void setCtm(String ctm) {
        this.ctm = ctm;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public void setIgnoreCriteria(String ignoreCriteria) {
        this.ignoreCriteria = ignoreCriteria;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setHold(String hold) {
        this.hold = hold;
    }

    public void setOrderIntoFolder(String orderIntoFolder) {
        this.orderIntoFolder = orderIntoFolder;
    }

    public void setWaitForOrderDate(String waitForOrderDate) {
        this.waitForOrderDate = waitForOrderDate;
    }

    public void setVariables(ArrayList<HashMap<String, String>> variables) {
        this.variables = variables;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof OrderDTO)) {
            return false;
        }
        OrderDTO other = (OrderDTO) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        String this$folder = this.getFolder();
        String other$folder = other.getFolder();
        if (this$folder == null ? other$folder != null : !this$folder.equals(other$folder)) {
            return false;
        }
        String this$application = this.getApplication();
        String other$application = other.getApplication();
        if (this$application == null ? other$application != null : !this$application.equals(other$application)) {
            return false;
        }
        String this$subapplication = this.getSubapplication();
        String other$subapplication = other.getSubapplication();
        if (this$subapplication == null ? other$subapplication != null : !this$subapplication.equals(other$subapplication)) {
            return false;
        }
        String this$ctm = this.getCtm();
        String other$ctm = other.getCtm();
        if (this$ctm == null ? other$ctm != null : !this$ctm.equals(other$ctm)) {
            return false;
        }
        String this$jobs = this.getJobs();
        String other$jobs = other.getJobs();
        if (this$jobs == null ? other$jobs != null : !this$jobs.equals(other$jobs)) {
            return false;
        }
        String this$ignoreCriteria = this.getIgnoreCriteria();
        String other$ignoreCriteria = other.getIgnoreCriteria();
        if (this$ignoreCriteria == null ? other$ignoreCriteria != null : !this$ignoreCriteria.equals(other$ignoreCriteria)) {
            return false;
        }
        String this$orderDate = this.getOrderDate();
        String other$orderDate = other.getOrderDate();
        if (this$orderDate == null ? other$orderDate != null : !this$orderDate.equals(other$orderDate)) {
            return false;
        }
        String this$hold = this.getHold();
        String other$hold = other.getHold();
        if (this$hold == null ? other$hold != null : !this$hold.equals(other$hold)) {
            return false;
        }
        String this$orderIntoFolder = this.getOrderIntoFolder();
        String other$orderIntoFolder = other.getOrderIntoFolder();
        if (this$orderIntoFolder == null ? other$orderIntoFolder != null : !this$orderIntoFolder.equals(other$orderIntoFolder)) {
            return false;
        }
        String this$waitForOrderDate = this.getWaitForOrderDate();
        String other$waitForOrderDate = other.getWaitForOrderDate();
        if (this$waitForOrderDate == null ? other$waitForOrderDate != null : !this$waitForOrderDate.equals(other$waitForOrderDate)) {
            return false;
        }
        ArrayList this$variables = this.getVariables();
        ArrayList other$variables = other.getVariables();
        return !(this$variables == null ? other$variables != null : !((Object) this$variables).equals(other$variables));
    }

    protected boolean canEqual(Object other) {
        return other instanceof OrderDTO;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $folder = this.getFolder();
        result = result * 59 + ($folder == null ? 43 : $folder.hashCode());
        String $application = this.getApplication();
        result = result * 59 + ($application == null ? 43 : $application.hashCode());
        String $subapplication = this.getSubapplication();
        result = result * 59 + ($subapplication == null ? 43 : $subapplication.hashCode());
        String $ctm = this.getCtm();
        result = result * 59 + ($ctm == null ? 43 : $ctm.hashCode());
        String $jobs = this.getJobs();
        result = result * 59 + ($jobs == null ? 43 : $jobs.hashCode());
        String $ignoreCriteria = this.getIgnoreCriteria();
        result = result * 59 + ($ignoreCriteria == null ? 43 : $ignoreCriteria.hashCode());
        String $orderDate = this.getOrderDate();
        result = result * 59 + ($orderDate == null ? 43 : $orderDate.hashCode());
        String $hold = this.getHold();
        result = result * 59 + ($hold == null ? 43 : $hold.hashCode());
        String $orderIntoFolder = this.getOrderIntoFolder();
        result = result * 59 + ($orderIntoFolder == null ? 43 : $orderIntoFolder.hashCode());
        String $waitForOrderDate = this.getWaitForOrderDate();
        result = result * 59 + ($waitForOrderDate == null ? 43 : $waitForOrderDate.hashCode());
        ArrayList $variables = this.getVariables();
        result = result * 59 + ($variables == null ? 43 : ((Object) $variables).hashCode());
        return result;
    }

    public String toString() {
        return "OrderDTO(folder=" + this.getFolder() + ", application=" + this.getApplication() + ", subapplication=" + this.getSubapplication() + ", ctm=" + this.getCtm() + ", jobs=" + this.getJobs() + ", ignoreCriteria=" + this.getIgnoreCriteria() + ", orderDate=" + this.getOrderDate() + ", hold=" + this.getHold() + ", orderIntoFolder=" + this.getOrderIntoFolder() + ", waitForOrderDate=" + this.getWaitForOrderDate() + ", variables=" + this.getVariables() + ")";
    }
}
