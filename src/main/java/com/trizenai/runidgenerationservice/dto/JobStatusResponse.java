package com.trizenai.runidgenerationservice.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class JobStatusResponse {

    @SerializedName(value = "statuses")
    @Expose
    private ArrayList<Status> statuses = null;
    @SerializedName(value = "startIndex")
    @Expose
    private int startIndex;
    @SerializedName(value = "itemsPerPage")
    @Expose
    private int itemsPerPage;
    @SerializedName(value = "total")
    @Expose
    private int total;
    @SerializedName(value = "nextURI")
    @Expose
    private String nextURI;

    public ArrayList<Status> getStatuses() {
        return this.statuses;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getItemsPerPage() {
        return this.itemsPerPage;
    }

    public int getTotal() {
        return this.total;
    }

    public String getNextURI() {
        return this.nextURI;
    }

    public void setStatuses(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setNextURI(String nextURI) {
        this.nextURI = nextURI;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof JobStatusResponse)) {
            return false;
        }
        JobStatusResponse other = (JobStatusResponse) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (this.getStartIndex() != other.getStartIndex()) {
            return false;
        }
        if (this.getItemsPerPage() != other.getItemsPerPage()) {
            return false;
        }
        if (this.getTotal() != other.getTotal()) {
            return false;
        }
        ArrayList this$statuses = this.getStatuses();
        ArrayList other$statuses = other.getStatuses();
        if (this$statuses == null ? other$statuses != null : !((Object) this$statuses).equals(other$statuses)) {
            return false;
        }
        String this$nextURI = this.getNextURI();
        String other$nextURI = other.getNextURI();
        return !(this$nextURI == null ? other$nextURI != null : !this$nextURI.equals(other$nextURI));
    }

    protected boolean canEqual(Object other) {
        return other instanceof JobStatusResponse;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getStartIndex();
        result = result * 59 + this.getItemsPerPage();
        result = result * 59 + this.getTotal();
        ArrayList $statuses = this.getStatuses();
        result = result * 59 + ($statuses == null ? 43 : ((Object) $statuses).hashCode());
        String $nextURI = this.getNextURI();
        result = result * 59 + ($nextURI == null ? 43 : $nextURI.hashCode());
        return result;
    }

    public String toString() {
        return "JobStatusResponse(statuses=" + this.getStatuses() + ", startIndex=" + this.getStartIndex() + ", itemsPerPage=" + this.getItemsPerPage() + ", total=" + this.getTotal() + ", nextURI=" + this.getNextURI() + ")";
    }
}
