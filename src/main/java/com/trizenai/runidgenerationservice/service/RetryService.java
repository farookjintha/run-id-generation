package com.trizenai.runidgenerationservice.service;

import com.trizenai.runidgenerationservice.dto.JobStatusResponse;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public interface RetryService {

    @Retryable(retryFor = {Exception.class}, maxAttempts = 4, backoff = @Backoff(delay = 4000L))
    JobStatusResponse retryJobStatusResponseAPI(String alphaNumericId, String authHeader) throws Exception;

    @Retryable(retryFor = {Exception.class}, maxAttempts = 4, backoff = @Backoff(delay = 4000L))
    String retryCaptureJobIdByRunJobsAPI(String authHeader, String folderId, String folderName) throws Exception;
}
