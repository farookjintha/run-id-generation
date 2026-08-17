package com.trizenai.runidgenerationservice.config;

/**
 * Plain holder for the Control-M server details read from ServerDetails.txt
 * by URLBuilder (not Spring-managed — populated manually, see URLBuilder).
 */
public class ControlMConfig {

    public String sessionLoginApi;
    public String orderApi;
    public String jobStatusApi;
    public String SLAStatusApi;
    public String RunJobsApi;
    public String serverName;
    public int port;

    public String getSessionLoginApi() {
        return this.sessionLoginApi;
    }

    public String getOrderApi() {
        return this.orderApi;
    }

    public String getJobStatusApi() {
        return this.jobStatusApi;
    }

    public String getSLAStatusApi() {
        return this.SLAStatusApi;
    }

    public String getRunJobsApi() {
        return this.RunJobsApi;
    }

    public String getServerName() {
        return this.serverName;
    }

    public int getPort() {
        return this.port;
    }

    public void setSessionLoginApi(String sessionLoginApi) {
        this.sessionLoginApi = sessionLoginApi;
    }

    public void setOrderApi(String orderApi) {
        this.orderApi = orderApi;
    }

    public void setJobStatusApi(String jobStatusApi) {
        this.jobStatusApi = jobStatusApi;
    }

    public void setSLAStatusApi(String SLAStatusApi) {
        this.SLAStatusApi = SLAStatusApi;
    }

    public void setRunJobsApi(String RunJobsApi) {
        this.RunJobsApi = RunJobsApi;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ControlMConfig)) {
            return false;
        }
        ControlMConfig other = (ControlMConfig) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (this.getPort() != other.getPort()) {
            return false;
        }
        String this$sessionLoginApi = this.getSessionLoginApi();
        String other$sessionLoginApi = other.getSessionLoginApi();
        if (this$sessionLoginApi == null ? other$sessionLoginApi != null : !this$sessionLoginApi.equals(other$sessionLoginApi)) {
            return false;
        }
        String this$orderApi = this.getOrderApi();
        String other$orderApi = other.getOrderApi();
        if (this$orderApi == null ? other$orderApi != null : !this$orderApi.equals(other$orderApi)) {
            return false;
        }
        String this$jobStatusApi = this.getJobStatusApi();
        String other$jobStatusApi = other.getJobStatusApi();
        if (this$jobStatusApi == null ? other$jobStatusApi != null : !this$jobStatusApi.equals(other$jobStatusApi)) {
            return false;
        }
        String this$SLAStatusApi = this.getSLAStatusApi();
        String other$SLAStatusApi = other.getSLAStatusApi();
        if (this$SLAStatusApi == null ? other$SLAStatusApi != null : !this$SLAStatusApi.equals(other$SLAStatusApi)) {
            return false;
        }
        String this$RunJobsApi = this.getRunJobsApi();
        String other$RunJobsApi = other.getRunJobsApi();
        if (this$RunJobsApi == null ? other$RunJobsApi != null : !this$RunJobsApi.equals(other$RunJobsApi)) {
            return false;
        }
        String this$serverName = this.getServerName();
        String other$serverName = other.getServerName();
        return !(this$serverName == null ? other$serverName != null : !this$serverName.equals(other$serverName));
    }

    protected boolean canEqual(Object other) {
        return other instanceof ControlMConfig;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getPort();
        String $sessionLoginApi = this.getSessionLoginApi();
        result = result * 59 + ($sessionLoginApi == null ? 43 : $sessionLoginApi.hashCode());
        String $orderApi = this.getOrderApi();
        result = result * 59 + ($orderApi == null ? 43 : $orderApi.hashCode());
        String $jobStatusApi = this.getJobStatusApi();
        result = result * 59 + ($jobStatusApi == null ? 43 : $jobStatusApi.hashCode());
        String $SLAStatusApi = this.getSLAStatusApi();
        result = result * 59 + ($SLAStatusApi == null ? 43 : $SLAStatusApi.hashCode());
        String $RunJobsApi = this.getRunJobsApi();
        result = result * 59 + ($RunJobsApi == null ? 43 : $RunJobsApi.hashCode());
        String $serverName = this.getServerName();
        result = result * 59 + ($serverName == null ? 43 : $serverName.hashCode());
        return result;
    }

    public String toString() {
        return "ControlMConfig(sessionLoginApi=" + this.getSessionLoginApi() + ", orderApi=" + this.getOrderApi() + ", jobStatusApi=" + this.getJobStatusApi() + ", SLAStatusApi=" + this.getSLAStatusApi() + ", RunJobsApi=" + this.getRunJobsApi() + ", serverName=" + this.getServerName() + ", port=" + this.getPort() + ")";
    }
}
