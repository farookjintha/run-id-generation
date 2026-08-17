package com.trizenai.runidgenerationservice.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trizenai.runidgenerationservice.dto.JobStatusResponse;
import com.trizenai.runidgenerationservice.model.Error;
import com.trizenai.runidgenerationservice.model.ErrorResponse;
import com.trizenai.runidgenerationservice.model.JobsStatus;
import com.trizenai.runidgenerationservice.model.RunJobsStatus;
import com.trizenai.runidgenerationservice.utility.HttpHeaderGenerator;
import com.trizenai.runidgenerationservice.utility.ResponseJsonBodyGenerator;
import com.trizenai.runidgenerationservice.utility.URLBuilder;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RetryServiceImpl implements RetryService {

    Logger logger = LoggerFactory.getLogger(RetryServiceImpl.class);
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private ResponseJsonBodyGenerator jsonBodyGenerator = new ResponseJsonBodyGenerator();
    private URLBuilder urlBuilder = new URLBuilder();
    @Autowired
    private RestTemplate restTemplate;
    static int retryJobStatusResponseAPICounter = 0;
    static int retryCaptureJobIdByRunJobsAPICounter = 0;

    @Override
    public JobStatusResponse retryJobStatusResponseAPI(String alphaNumericId, String authHeader) throws Exception {
        if (++retryJobStatusResponseAPICounter == 1) {
            this.logger.info("retryJobStatusResponseAPI() method accessed.....");
        } else {
            this.logger.info("Retrying retryJobStatusResponseAPI() method....");
        }
        try {
            JobStatusResponse jobStatusResponse;
            StringBuffer sb = new StringBuffer();
            String JOB_STATUS_URL = sb.append(this.urlBuilder.buildJobStatusURL()).append(alphaNumericId).toString();
            this.logger.info("Job status url : " + JOB_STATUS_URL);
            HttpHeaders jobStatusHeaders = HttpHeaderGenerator.getHeaders();
            jobStatusHeaders.set("Authorization", authHeader);
            HttpEntity jobStatusEntity = new HttpEntity((MultiValueMap) jobStatusHeaders);
            jobStatusResponse = (JobStatusResponse) this.restTemplate.exchange(JOB_STATUS_URL, HttpMethod.GET, jobStatusEntity, JobStatusResponse.class, new Object[0]).getBody();
            return jobStatusResponse;
        } catch (Exception e) {
            this.logger.info(e.getMessage());
            if (this.jsonBodyGenerator.getStatusCode(e.getMessage()) == 401 || this.jsonBodyGenerator.getStatusCode(e.getMessage()) == 500) {
                ErrorResponse errorResponse = new ErrorResponse();
                Error error = new Error();
                error.setMessage("User not found. Session token is invalid or expired.");
                ArrayList<Error> errorList = new ArrayList<Error>();
                errorList.add(error);
                errorResponse.setErrors(errorList);
                e.printStackTrace();
                this.logger.info(ResponseEntity.status((HttpStatusCode) HttpStatus.UNAUTHORIZED).body((Object) this.gson.toJson((Object) errorResponse)).toString());
                throw e;
            }
            this.logger.info(ResponseEntity.status((int) this.jsonBodyGenerator.getStatusCode(e.getMessage())).body((Object) this.jsonBodyGenerator.getJsonBody(e.getMessage())).toString());
            throw e;
        }
    }

    @Override
    public String retryCaptureJobIdByRunJobsAPI(String authHeader, String folderId, String folderName) throws Exception {
        if (++retryCaptureJobIdByRunJobsAPICounter == 1) {
            this.logger.info("retryCaptureJobIdByRunJobsAPI() method accessed.....");
        } else {
            this.logger.info("Retrying retryCaptureJobIdByRunJobsAPI() method....");
        }
        try {
            String JobId = null;
            HttpHeaders runJobsHeaders = HttpHeaderGenerator.getHeaders();
            runJobsHeaders.set("Authorization", authHeader);
            HttpEntity jobStatusEntity = new HttpEntity((MultiValueMap) runJobsHeaders);
            this.logger.info("Required Http Entity for Run Jobs api: " + jobStatusEntity.toString());
            String RUN_JOBS_URL = this.urlBuilder.buildRunJobsURL(folderName);
            this.logger.info("RUN_JOBS_URL is : " + RUN_JOBS_URL);
            JobsStatus jobsStatus = (JobsStatus) this.restTemplate.exchange(RUN_JOBS_URL, HttpMethod.GET, jobStatusEntity, JobsStatus.class, new Object[0]).getBody();
            // TODO: photo showed `this.gson.toJson((Object)statuses)` here with
            // "statuses" undeclared at this point — reconstructed by mirroring the
            // identical pattern used in OrderService.captureFolderIdAndFolderNamebyJobStatusApi()
            // (declare a local "statuses" list right before logging it). Please
            // confirm against a clearer shot of this exact spot.
            ArrayList<RunJobsStatus> statuses = jobsStatus.getStatuses();
            this.logger.info("Statuses from RUN_JOBS_URL : " + this.gson.toJson((Object) statuses));
            for (RunJobsStatus runJobsStatus : jobsStatus.getStatuses()) {
                if (!runJobsStatus.getFolderId().equals(folderId)) continue;
                JobId = runJobsStatus.getJobId();
                this.logger.info("Job Id is of SLA job is : " + JobId);
                break;
            }
            return JobId;
        } catch (Exception e) {
            this.logger.error("Exception caught in retryCaptureJobIdByRunJobsAPI() method.. : " + e.getMessage());
            e.printStackTrace();
            if (this.jsonBodyGenerator.getStatusCode(e.getMessage()) == 401 || this.jsonBodyGenerator.getStatusCode(e.getMessage()) == 500) {
                ErrorResponse errorResponse = new ErrorResponse();
                Error error = new Error();
                error.setMessage("User not found. Session token is invalid or expired.");
                ArrayList<Error> errorList = new ArrayList<Error>();
                errorList.add(error);
                errorResponse.setErrors(errorList);
                e.printStackTrace();
                this.logger.info(ResponseEntity.status((HttpStatusCode) HttpStatus.UNAUTHORIZED).body((Object) this.gson.toJson((Object) errorResponse)).toString());
                throw e;
            }
            this.logger.info(ResponseEntity.status((int) this.jsonBodyGenerator.getStatusCode(e.getMessage())).body((Object) this.jsonBodyGenerator.getJsonBody(e.getMessage())).toString());
            throw e;
        }
    }
}
