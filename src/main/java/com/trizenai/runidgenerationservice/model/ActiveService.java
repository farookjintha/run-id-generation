package com.trizenai.runidgenerationservice.model;

public class ActiveService {

    public String serviceName;
    public String status;
    public String statusReason;
    public String startTime;
    public String endTime;
    public String dueTime;
    public String slackTime;
    public String serviceOrderDateTime;
    public String scheduledOrderDate;
    public String serviceJob;
    public String serviceControlM;
    public String priority;
    public String note;
    public String totalJobs;
    public String jobsCompleted;
    public String jobsWithoutStatistics;
    public String completionPercentage;
    public String averageCompletionTime;
    public String errors;
    public StatusByJobs statusByJobs;

    public String getServiceName() {
        return this.serviceName;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusReason() {
        return this.statusReason;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getDueTime() {
        return this.dueTime;
    }

    public String getSlackTime() {
        return this.slackTime;
    }

    public String getServiceOrderDateTime() {
        return this.serviceOrderDateTime;
    }

    public String getScheduledOrderDate() {
        return this.scheduledOrderDate;
    }

    public String getServiceJob() {
        return this.serviceJob;
    }

    public String getServiceControlM() {
        return this.serviceControlM;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getNote() {
        return this.note;
    }

    public String getTotalJobs() {
        return this.totalJobs;
    }

    public String getJobsCompleted() {
        return this.jobsCompleted;
    }

    public String getJobsWithoutStatistics() {
        return this.jobsWithoutStatistics;
    }

    public String getCompletionPercentage() {
        return this.completionPercentage;
    }

    public String getAverageCompletionTime() {
        return this.averageCompletionTime;
    }

    public String getErrors() {
        return this.errors;
    }

    public StatusByJobs getStatusByJobs() {
        return this.statusByJobs;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public void setSlackTime(String slackTime) {
        this.slackTime = slackTime;
    }

    public void setServiceOrderDateTime(String serviceOrderDateTime) {
        this.serviceOrderDateTime = serviceOrderDateTime;
    }

    public void setScheduledOrderDate(String scheduledOrderDate) {
        this.scheduledOrderDate = scheduledOrderDate;
    }

    public void setServiceJob(String serviceJob) {
        this.serviceJob = serviceJob;
    }

    public void setServiceControlM(String serviceControlM) {
        this.serviceControlM = serviceControlM;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setTotalJobs(String totalJobs) {
        this.totalJobs = totalJobs;
    }

    public void setJobsCompleted(String jobsCompleted) {
        this.jobsCompleted = jobsCompleted;
    }

    public void setJobsWithoutStatistics(String jobsWithoutStatistics) {
        this.jobsWithoutStatistics = jobsWithoutStatistics;
    }

    public void setCompletionPercentage(String completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public void setAverageCompletionTime(String averageCompletionTime) {
        this.averageCompletionTime = averageCompletionTime;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public void setStatusByJobs(StatusByJobs statusByJobs) {
        this.statusByJobs = statusByJobs;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ActiveService)) {
            return false;
        }
        ActiveService other = (ActiveService) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        String this$serviceName = this.getServiceName();
        String other$serviceName = other.getServiceName();
        if (this$serviceName == null ? other$serviceName != null : !this$serviceName.equals(other$serviceName)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        String this$statusReason = this.getStatusReason();
        String other$statusReason = other.getStatusReason();
        if (this$statusReason == null ? other$statusReason != null : !this$statusReason.equals(other$statusReason)) {
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
        String this$dueTime = this.getDueTime();
        String other$dueTime = other.getDueTime();
        if (this$dueTime == null ? other$dueTime != null : !this$dueTime.equals(other$dueTime)) {
            return false;
        }
        String this$slackTime = this.getSlackTime();
        String other$slackTime = other.getSlackTime();
        if (this$slackTime == null ? other$slackTime != null : !this$slackTime.equals(other$slackTime)) {
            return false;
        }
        String this$serviceOrderDateTime = this.getServiceOrderDateTime();
        String other$serviceOrderDateTime = other.getServiceOrderDateTime();
        if (this$serviceOrderDateTime == null ? other$serviceOrderDateTime != null : !this$serviceOrderDateTime.equals(other$serviceOrderDateTime)) {
            return false;
        }
        String this$scheduledOrderDate = this.getScheduledOrderDate();
        String other$scheduledOrderDate = other.getScheduledOrderDate();
        if (this$scheduledOrderDate == null ? other$scheduledOrderDate != null : !this$scheduledOrderDate.equals(other$scheduledOrderDate)) {
            return false;
        }
        String this$serviceJob = this.getServiceJob();
        String other$serviceJob = other.getServiceJob();
        if (this$serviceJob == null ? other$serviceJob != null : !this$serviceJob.equals(other$serviceJob)) {
            return false;
        }
        String this$serviceControlM = this.getServiceControlM();
        String other$serviceControlM = other.getServiceControlM();
        if (this$serviceControlM == null ? other$serviceControlM != null : !this$serviceControlM.equals(other$serviceControlM)) {
            return false;
        }
        String this$priority = this.getPriority();
        String other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
            return false;
        }
        String this$note = this.getNote();
        String other$note = other.getNote();
        if (this$note == null ? other$note != null : !this$note.equals(other$note)) {
            return false;
        }
        String this$totalJobs = this.getTotalJobs();
        String other$totalJobs = other.getTotalJobs();
        if (this$totalJobs == null ? other$totalJobs != null : !this$totalJobs.equals(other$totalJobs)) {
            return false;
        }
        String this$jobsCompleted = this.getJobsCompleted();
        String other$jobsCompleted = other.getJobsCompleted();
        if (this$jobsCompleted == null ? other$jobsCompleted != null : !this$jobsCompleted.equals(other$jobsCompleted)) {
            return false;
        }
        String this$jobsWithoutStatistics = this.getJobsWithoutStatistics();
        String other$jobsWithoutStatistics = other.getJobsWithoutStatistics();
        if (this$jobsWithoutStatistics == null ? other$jobsWithoutStatistics != null : !this$jobsWithoutStatistics.equals(other$jobsWithoutStatistics)) {
            return false;
        }
        String this$completionPercentage = this.getCompletionPercentage();
        String other$completionPercentage = other.getCompletionPercentage();
        if (this$completionPercentage == null ? other$completionPercentage != null : !this$completionPercentage.equals(other$completionPercentage)) {
            return false;
        }
        String this$averageCompletionTime = this.getAverageCompletionTime();
        String other$averageCompletionTime = other.getAverageCompletionTime();
        if (this$averageCompletionTime == null ? other$averageCompletionTime != null : !this$averageCompletionTime.equals(other$averageCompletionTime)) {
            return false;
        }
        String this$errors = this.getErrors();
        String other$errors = other.getErrors();
        if (this$errors == null ? other$errors != null : !this$errors.equals(other$errors)) {
            return false;
        }
        StatusByJobs this$statusByJobs = this.getStatusByJobs();
        StatusByJobs other$statusByJobs = other.getStatusByJobs();
        return !(this$statusByJobs == null ? other$statusByJobs != null : !this$statusByJobs.equals(other$statusByJobs));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ActiveService;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $serviceName = this.getServiceName();
        result = result * 59 + ($serviceName == null ? 43 : $serviceName.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        String $statusReason = this.getStatusReason();
        result = result * 59 + ($statusReason == null ? 43 : $statusReason.hashCode());
        String $startTime = this.getStartTime();
        result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
        String $endTime = this.getEndTime();
        result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
        String $dueTime = this.getDueTime();
        result = result * 59 + ($dueTime == null ? 43 : $dueTime.hashCode());
        String $slackTime = this.getSlackTime();
        result = result * 59 + ($slackTime == null ? 43 : $slackTime.hashCode());
        String $serviceOrderDateTime = this.getServiceOrderDateTime();
        result = result * 59 + ($serviceOrderDateTime == null ? 43 : $serviceOrderDateTime.hashCode());
        String $scheduledOrderDate = this.getScheduledOrderDate();
        result = result * 59 + ($scheduledOrderDate == null ? 43 : $scheduledOrderDate.hashCode());
        String $serviceJob = this.getServiceJob();
        result = result * 59 + ($serviceJob == null ? 43 : $serviceJob.hashCode());
        String $serviceControlM = this.getServiceControlM();
        result = result * 59 + ($serviceControlM == null ? 43 : $serviceControlM.hashCode());
        String $priority = this.getPriority();
        result = result * 59 + ($priority == null ? 43 : $priority.hashCode());
        String $note = this.getNote();
        result = result * 59 + ($note == null ? 43 : $note.hashCode());
        String $totalJobs = this.getTotalJobs();
        result = result * 59 + ($totalJobs == null ? 43 : $totalJobs.hashCode());
        String $jobsCompleted = this.getJobsCompleted();
        result = result * 59 + ($jobsCompleted == null ? 43 : $jobsCompleted.hashCode());
        String $jobsWithoutStatistics = this.getJobsWithoutStatistics();
        result = result * 59 + ($jobsWithoutStatistics == null ? 43 : $jobsWithoutStatistics.hashCode());
        String $completionPercentage = this.getCompletionPercentage();
        result = result * 59 + ($completionPercentage == null ? 43 : $completionPercentage.hashCode());
        String $averageCompletionTime = this.getAverageCompletionTime();
        result = result * 59 + ($averageCompletionTime == null ? 43 : $averageCompletionTime.hashCode());
        String $errors = this.getErrors();
        result = result * 59 + ($errors == null ? 43 : $errors.hashCode());
        StatusByJobs $statusByJobs = this.getStatusByJobs();
        result = result * 59 + ($statusByJobs == null ? 43 : $statusByJobs.hashCode());
        return result;
    }

    public String toString() {
        return "ActiveService(serviceName=" + this.getServiceName() + ", status=" + this.getStatus() + ", statusReason=" + this.getStatusReason() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ", dueTime=" + this.getDueTime() + ", slackTime=" + this.getSlackTime() + ", serviceOrderDateTime=" + this.getServiceOrderDateTime() + ", scheduledOrderDate=" + this.getScheduledOrderDate() + ", serviceJob=" + this.getServiceJob() + ", serviceControlM=" + this.getServiceControlM() + ", priority=" + this.getPriority() + ", note=" + this.getNote() + ", totalJobs=" + this.getTotalJobs() + ", jobsCompleted=" + this.getJobsCompleted() + ", jobsWithoutStatistics=" + this.getJobsWithoutStatistics() + ", completionPercentage=" + this.getCompletionPercentage() + ", averageCompletionTime=" + this.getAverageCompletionTime() + ", errors=" + this.getErrors() + ", statusByJobs=" + this.getStatusByJobs() + ")";
    }
}
