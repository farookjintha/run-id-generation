package com.trizenai.runidgenerationservice.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * TODO: field order below is reconstructed from the clearest evidence
 * (class header + setter block, which agree: jobId, folderId, numberOfRuns,
 * name, type, status, held, deleted, startTime, endTime, outputURI, logURI,
 * folder). An earlier read of hashCode()'s opening seemed to show
 * numberOfRuns/held/deleted checked before jobId, which would contradict
 * this — likely a transcription mix-up on the denser hashCode block rather
 * than a real discrepancy, but worth confirming with a clearer photo of
 * the field declarations and full hashCode() if you have one.
 * @SerializedName values beyond "status" are inferred (assumed to equal the
 * field name, matching every field confirmed so far) — not directly seen.
 */
public class Status {

    @SerializedName(value = "jobId")
    @Expose
    private String jobId;
    @SerializedName(value = "folderId")
    @Expose
    private String folderId;
    @SerializedName(value = "numberOfRuns")
    @Expose
    private int numberOfRuns;
    @SerializedName(value = "name")
    @Expose
    private String name;
    @SerializedName(value = "type")
    @Expose
    private String type;
    @SerializedName(value = "status")
    @Expose
    private String status;
    @SerializedName(value = "held")
    @Expose
    private boolean held;
    @SerializedName(value = "deleted")
    @Expose
    private boolean deleted;
    @SerializedName(value = "startTime")
    @Expose
    private String startTime;
    @SerializedName(value = "endTime")
    @Expose
    private String endTime;
    @SerializedName(value = "outputURI")
    @Expose
    private String outputURI;
    @SerializedName(value = "logURI")
    @Expose
    private String logURI;
    @SerializedName(value = "folder")
    @Expose
    private String folder;

    public String getJobId() {
        return this.jobId;
    }

    public String getFolderId() {
        return this.folderId;
    }

    public int getNumberOfRuns() {
        return this.numberOfRuns;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isHeld() {
        return this.held;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getOutputURI() {
        return this.outputURI;
    }

    public String getLogURI() {
        return this.logURI;
    }

    public String getFolder() {
        return this.folder;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public void setNumberOfRuns(int numberOfRuns) {
        this.numberOfRuns = numberOfRuns;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHeld(boolean held) {
        this.held = held;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setOutputURI(String outputURI) {
        this.outputURI = outputURI;
    }

    public void setLogURI(String logURI) {
        this.logURI = logURI;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Status)) {
            return false;
        }
        Status other = (Status) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (this.getNumberOfRuns() != other.getNumberOfRuns()) {
            return false;
        }
        if (this.isHeld() != other.isHeld()) {
            return false;
        }
        if (this.isDeleted() != other.isDeleted()) {
            return false;
        }
        String this$jobId = this.getJobId();
        String other$jobId = other.getJobId();
        if (this$jobId == null ? other$jobId != null : !this$jobId.equals(other$jobId)) {
            return false;
        }
        String this$folderId = this.getFolderId();
        String other$folderId = other.getFolderId();
        if (this$folderId == null ? other$folderId != null : !this$folderId.equals(other$folderId)) {
            return false;
        }
        String this$name = this.getName();
        String other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        String this$type = this.getType();
        String other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        String this$startTime = this.getStartTime();
        String other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
            return false;
        }
        String this$endTime = this.getEndTime();
        String other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) {
            return false;
        }
        String this$outputURI = this.getOutputURI();
        String other$outputURI = other.getOutputURI();
        if (this$outputURI == null ? other$outputURI != null : !this$outputURI.equals(other$outputURI)) {
            return false;
        }
        String this$logURI = this.getLogURI();
        String other$logURI = other.getLogURI();
        if (this$logURI == null ? other$logURI != null : !this$logURI.equals(other$logURI)) {
            return false;
        }
        String this$folder = this.getFolder();
        String other$folder = other.getFolder();
        return !(this$folder == null ? other$folder != null : !this$folder.equals(other$folder));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Status;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getNumberOfRuns();
        result = result * 59 + (this.isHeld() ? 79 : 97);
        result = result * 59 + (this.isDeleted() ? 79 : 97);
        String $jobId = this.getJobId();
        result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
        String $folderId = this.getFolderId();
        result = result * 59 + ($folderId == null ? 43 : $folderId.hashCode());
        String $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        String $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        String $startTime = this.getStartTime();
        result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
        String $endTime = this.getEndTime();
        result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
        String $outputURI = this.getOutputURI();
        result = result * 59 + ($outputURI == null ? 43 : $outputURI.hashCode());
        String $logURI = this.getLogURI();
        result = result * 59 + ($logURI == null ? 43 : $logURI.hashCode());
        String $folder = this.getFolder();
        result = result * 59 + ($folder == null ? 43 : $folder.hashCode());
        return result;
    }

    public String toString() {
        return "Status(jobId=" + this.getJobId() + ", folderId=" + this.getFolderId() + ", numberOfRuns=" + this.getNumberOfRuns() + ", name=" + this.getName() + ", type=" + this.getType() + ", status=" + this.getStatus() + ", held=" + this.isHeld() + ", deleted=" + this.isDeleted() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", outputURI=" + this.getOutputURI() + ", logURI=" + this.getLogURI() + ", folder=" + this.getFolder() + ")";
    }
}
