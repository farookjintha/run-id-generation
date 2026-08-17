package com.trizenai.runidgenerationservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.trizenai.runidgenerationservice.config.ModelMapperConfig;
import com.trizenai.runidgenerationservice.dto.JobStatusResponse;
import com.trizenai.runidgenerationservice.dto.OrderDTO;
import com.trizenai.runidgenerationservice.dto.Status;
import com.trizenai.runidgenerationservice.model.ActiveService;
import com.trizenai.runidgenerationservice.model.Error;
import com.trizenai.runidgenerationservice.model.ErrorResponse;
import com.trizenai.runidgenerationservice.model.JobStatus;
import com.trizenai.runidgenerationservice.model.LoginRequest;
import com.trizenai.runidgenerationservice.model.Order;
import com.trizenai.runidgenerationservice.model.OrderResponse;
import com.trizenai.runidgenerationservice.model.SLAServices;
import com.trizenai.runidgenerationservice.utility.HttpHeaderGenerator;
import com.trizenai.runidgenerationservice.utility.RandomRunIdGenerator;
import com.trizenai.runidgenerationservice.utility.ResponseJsonBodyGenerator;
import com.trizenai.runidgenerationservice.utility.RunIdPersister;
import com.trizenai.runidgenerationservice.utility.URLBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RetryService retryService;
    private JobStatus jobStatus = new JobStatus();
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private RunIdPersister runIdPersister = new RunIdPersister();
    private ModelMapperConfig mapperConfig = new ModelMapperConfig();
    private ModelMapper modelMapper = this.mapperConfig.getModelMapper();
    private URLBuilder urlBuilder = new URLBuilder();
    private ResponseJsonBodyGenerator jsonBodyGenerator = new ResponseJsonBodyGenerator();

    /*
     * CFR flagged this method with: "WARNING - Removed try catching itself -
     * possible behaviour change." The try/catch reconstruction below is CFR's
     * best guess at the original control flow, not guaranteed accurate —
     * worth a close look when you test this against the real jar's behavior.
     *
     * TODO: the photo's throws clause only listed JsonSyntaxException and
     * JsonProcessingException, but urlBuilder.buildLoginURL() declares
     * "throws FileNotFoundException, IOException" — added IOException here
     * so this compiles; the photo's throws clause was likely cropped.
     */
    public ResponseEntity<Object> authenticateUser(LoginRequest loginRequest) throws JsonSyntaxException, JsonProcessingException, IOException {
        ResponseEntity authenticationResponse = null;
        block5: {
            this.logger.trace("authenticateUser method accessed...");
            this.logger.trace("Inside try block...");
            String loginDetails = this.gson.toJson((Object) loginRequest);
            HttpHeaders authenticationHeaders = HttpHeaderGenerator.getHeaders();
            HttpEntity authenticationEntity = new HttpEntity((Object) loginDetails, (MultiValueMap) authenticationHeaders);
            this.logger.info("authenticationEntity : " + authenticationEntity.toString());
            String LOGIN_URL = this.urlBuilder.buildLoginURL();
            this.logger.info("Login URL : " + LOGIN_URL);
            // TODO: the photo was cut off between the LOGIN_URL log line and the
            // "Authentication Response Body" log line below — the exact
            // restTemplate.exchange(...) call wasn't directly visible here.
            // This line mirrors the equivalent call in sendNumericRunId/
            // sendJobStatusBySLAApi, but please resend a clear shot of this
            // exact spot to confirm it matches.
            authenticationResponse = this.restTemplate.exchange(LOGIN_URL, HttpMethod.POST, authenticationEntity, Object.class, new Object[0]);
            this.logger.info("Authentication Response Body : " + authenticationResponse.getBody());
            this.logger.info("Authentication Response Body code : " + authenticationResponse.getStatusCodeValue());
            if (authenticationResponse.getStatusCodeValue() != 200) break block5;
            ResponseEntity.status((HttpStatusCode) HttpStatus.OK).build();
            ResponseEntity responseEntity = ResponseEntity.of(Optional.of(authenticationResponse.getBody()));
            return responseEntity;
        }
        try {
            this.logger.trace("Inside else block..");
            ErrorResponse authenticationErrorResponse = (ErrorResponse) this.gson.fromJson((String) this.jsonBodyGenerator.getJsonBody(authenticationResponse.getBody()), ErrorResponse.class);
            this.logger.info("Authentication Error Response : " + this.gson.toJson((Object) authenticationErrorResponse));
            ResponseEntity.status((HttpStatusCode) HttpStatus.INTERNAL_SERVER_ERROR).build();
            ResponseEntity responseEntity = ResponseEntity.of(Optional.of(authenticationErrorResponse));
            return responseEntity;
        } catch (Exception e) {
            this.logger.error("Exception caught in authenticateUser() method: " + e);
            JsonElement je = JsonParser.parseString((String) this.jsonBodyGenerator.getJsonBody(e.getMessage()));
            String json = this.gson.toJson(je);
            ResponseEntity responseEntity = ResponseEntity.status((int) this.jsonBodyGenerator.getStatusCode(e.getMessage())).body((Object) json);
            return responseEntity;
        }
    }

    /*
     * CFR flagged this method with: "WARNING - Removed try catching itself -
     * possible behaviour change." Same caveat as authenticateUser() above.
     */
    public ResponseEntity<Object> sendNumericRunId(OrderDTO orderDTO, String authHeader) throws Exception {
        ResponseEntity responseEntity;
        ResponseEntity runOrderResponse = null;
        block8: {
            ArrayList<HashMap<String, String>> variables = orderDTO.getVariables();
            HashMap<String, String> runIdMap = new HashMap<String, String>();
            String numericRunId = null;
            Order order = (Order) this.modelMapper.map((Object) orderDTO, Order.class);
            if (variables == null) {
                variables = new ArrayList<HashMap<String, String>>();
                numericRunId = RandomRunIdGenerator.generateRandomRunId();
                runIdMap.put("AZ_RUN_ID", numericRunId);
                variables.add(runIdMap);
                order.setVariables(variables);
            } else {
                numericRunId = RandomRunIdGenerator.generateRandomRunId();
                runIdMap.put("AZ_RUN_ID", numericRunId);
                variables.add(runIdMap);
                order.setVariables(variables);
            }
            String orderDetails = this.gson.toJson((Object) order);
            HttpHeaders orderDetailsHeaders = HttpHeaderGenerator.getHeaders();
            orderDetailsHeaders.set("Authorization", authHeader);
            this.logger.info("Headers : " + orderDetailsHeaders.toString());
            HttpEntity orderDetailsEntity = new HttpEntity((Object) orderDetails, (MultiValueMap) orderDetailsHeaders);
            this.logger.info("Order Details Entity : " + orderDetailsEntity.toString());
            String RUN_ORDER_URL = this.urlBuilder.buildRunOrderURL();
            this.logger.info("RUN_ORDER_URL : " + RUN_ORDER_URL);
            runOrderResponse = this.restTemplate.exchange(RUN_ORDER_URL, HttpMethod.POST, orderDetailsEntity, Object.class, new Object[0]);
            this.logger.info("Run Order Response Body: " + runOrderResponse.getBody());
            this.logger.info("Run Order Response Code value: " + runOrderResponse.getStatusCodeValue());
            if (runOrderResponse.getStatusCodeValue() != 200) break block8;
            this.logger.trace("Inside if block...");
            OrderResponse orderResponse = (OrderResponse) this.gson.fromJson(this.gson.toJson(runOrderResponse.getBody()), OrderResponse.class);
            // TODO: the photo showed a line here reading roughly
            // "this.jobStatus.getRunId(orderResponse.get..." — cut off and
            // ambiguous (get vs set, and which OrderResponse field it reads).
            // Left out rather than guessed; please resend a clear shot of
            // this exact line.
            this.jobStatus.setStatusURI(orderResponse.getStatusURI());
            this.jobStatus.setNumericRunId(Integer.valueOf(Integer.parseInt(numericRunId)));
            String lastJobId = this.captureFolderIdAndFolderNamebyJobStatusApi(numericRunId, authHeader, this.jobStatus.getAlphanumericRunId());
            this.logger.info("Last job id from Job Status Api is: " + lastJobId);
            this.runIdPersister.saveRunIdAndLastJobId(this.jobStatus.getNumericRunId().toString(), lastJobId);
            this.logger.info("Final Job status Response after appending run ID : " + this.gson.toJson((Object) this.jobStatus));
            this.logger.info("Final response Entity : " + ResponseEntity.ok((Object) this.jobStatus).toString());
            responseEntity = ResponseEntity.ok((Object) this.jobStatus);
            return responseEntity;
        }
        try {
            this.logger.trace("Inside Else block..");
            responseEntity = runOrderResponse;
            return responseEntity;
        } catch (Exception e) {
            block9: {
                this.logger.error("Exception caught in sendNumericRunId() method.. : " + e.getMessage());
                if (this.jsonBodyGenerator.getStatusCode(e.getMessage()) != 401) break block9;
                ErrorResponse errorResponse = new ErrorResponse();
                Error error = new Error();
                error.setMessage("User not found. Session token is invalid or expired.");
                ArrayList<Error> errorList = new ArrayList<Error>();
                errorList.add(error);
                errorResponse.setErrors(errorList);
                responseEntity = ResponseEntity.status((HttpStatusCode) HttpStatus.UNAUTHORIZED).body((Object) this.gson.toJson((Object) errorResponse));
                return responseEntity;
            }
            responseEntity = ResponseEntity.status((int) this.jsonBodyGenerator.getStatusCode(e.getMessage())).body((Object) this.jsonBodyGenerator.getJsonBody(e.getMessage()));
            return responseEntity;
        }
    }

    private String captureFolderIdAndFolderNamebyJobStatusApi(String numericRunId, String authHeader, String alphanumericRunId) throws Exception {
        String folderId = null;
        String folderName = null;
        String jobId = null;
        try {
            HttpHeaders jobStatusHeaders = HttpHeaderGenerator.getHeaders();
            jobStatusHeaders.set("Authorization", authHeader);
            this.logger.info("Required Header : " + jobStatusHeaders.toString());
            HttpEntity jobStatusEntity = new HttpEntity((MultiValueMap) jobStatusHeaders);
            this.logger.info("Required Http Entity : " + jobStatusEntity.toString());
            StringBuffer sb = new StringBuffer();
            String JOB_STATUS_URL = sb.append(this.urlBuilder.buildJobStatusURL()).append(alphanumericRunId).toString();
            this.logger.info("JOB_STATUS_URL :" + JOB_STATUS_URL);
            JobStatusResponse jobStatusResponse = this.retryService.retryJobStatusResponseAPI(alphanumericRunId, authHeader);
            ArrayList statuses = jobStatusResponse.getStatuses();
            this.logger.info("Statuses from Job Status Response: " + this.gson.toJson((Object) statuses));
            for (Status status : jobStatusResponse.getStatuses()) {
                if (!status.getType().equals("Folder")) continue;
                folderId = status.getJobId();
                folderName = status.getName();
                this.logger.info("folder Id : " + folderId + " folder Name : " + folderName);
                if (folderId == null || folderName == null) break;
                jobId = this.retryService.retryCaptureJobIdByRunJobsAPI(authHeader, folderId, folderName);
                this.logger.info("Job id from RunJobsApi is : " + jobId);
                break;
            }
            return jobId;
        } catch (Exception e) {
            this.logger.error("Exception caught in captureFolderIdAndFolderNamebyJobStatusApi() method.. : " + e.getMessage());
            this.logger.info(ResponseEntity.status((int) this.jsonBodyGenerator.getStatusCode(e.getMessage())).body((Object) this.jsonBodyGenerator.getJsonBody(e.getMessage())).toString());
            throw e;
        }
    }

    @Retryable(retryFor = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 8000L))
    public Object sendJobStatusBySLAApi(String numericRunId, String authHeader) {
        try {
            HttpHeaders SLAHeaders = HttpHeaderGenerator.getHeaders();
            SLAHeaders.set("Authorization", authHeader);
            this.logger.info("Required Header : " + SLAHeaders.toString());
            HttpEntity SLAEntity = new HttpEntity((MultiValueMap) SLAHeaders);
            this.logger.info("Required Http Entity : " + SLAEntity.toString());
            String SLA_SERVICES_URL = this.urlBuilder.buildSLAServicesURL();
            this.logger.info("SLA_SERVICES_URL :" + SLA_SERVICES_URL);
            SLAServices slaServiceResponse = (SLAServices) this.restTemplate.exchange(SLA_SERVICES_URL, HttpMethod.GET, SLAEntity, SLAServices.class, new Object[0]).getBody();
            this.logger.debug("Job Status SLA response : " + this.gson.toJson((Object) slaServiceResponse));
            ArrayList<ActiveService> activeServices = slaServiceResponse.getActiveServices();
            // TODO: the photo showed runIdPersister.getLastJobIdByNumericRunId(numericRunId)
            // here, but the real RunIdPersister.java you sent has no such method — its
            // 4 real methods are saveRunIdAndAlphanumericRunId, getAlphanumericRunId,
            // getNumericRunIdUsingAlphaNumericRunId, and saveRunIdAndLastJobId.
            // Provisionally mapped to getAlphanumericRunId(numericRunId), the closest
            // signature match — please confirm this is right, or resend this exact
            // line if either this call or the persister's method list was misread.
            String jobId = this.runIdPersister.getAlphanumericRunId(numericRunId);
            this.logger.info("JOB ID from mapping file is : " + jobId);
            if (jobId == null) {
                ErrorResponse errorResponse = new ErrorResponse();
                Error error = new Error();
                error.setMessage("Unknown run ID " + numericRunId);
                ArrayList<Error> errorList = new ArrayList<Error>();
                errorList.add(error);
                errorResponse.setErrors(errorList);
                return ResponseEntity.status((HttpStatusCode) HttpStatus.NOT_FOUND).body((Object) this.gson.toJson((Object) errorResponse));
            }
            ActiveService activeService1 = new ActiveService();
            for (ActiveService activeService : activeServices) {
                if (!activeService.getServiceJob().equals(jobId)) continue;
                activeService1 = activeService;
            }
            this.logger.info("Active service with SLA job : " + this.gson.toJson((Object) activeService1));
            return ResponseEntity.ok((Object) this.gson.toJson((Object) activeService1));
        } catch (Exception e) {
            this.logger.error("Exception caught in sendJobStatusBySLAApi() method.. : " + e.getMessage());
            if (this.jsonBodyGenerator.getStatusCode(e.getMessage()) == 401 || this.jsonBodyGenerator.getStatusCode(e.getMessage()) == 500) {
                ErrorResponse errorResponse = new ErrorResponse();
                Error error = new Error();
                error.setMessage("User not found. Session token is invalid or expired.");
                ArrayList<Error> errorList = new ArrayList<Error>();
                errorList.add(error);
                errorResponse.setErrors(errorList);
                e.printStackTrace();
                return ResponseEntity.status((HttpStatusCode) HttpStatus.UNAUTHORIZED).body((Object) this.gson.toJson((Object) errorResponse));
            }
            return ResponseEntity.status((int) this.jsonBodyGenerator.getStatusCode(e.getMessage())).body((Object) this.jsonBodyGenerator.getJsonBody(e.getMessage()));
        }
    }
}
