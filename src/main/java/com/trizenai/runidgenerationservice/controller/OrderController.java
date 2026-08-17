package com.trizenai.runidgenerationservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.trizenai.runidgenerationservice.dto.OrderDTO;
import com.trizenai.runidgenerationservice.model.LoginRequest;
import com.trizenai.runidgenerationservice.service.OrderService;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    public OrderService orderService;
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderController() {
    }

    @PostMapping(value = {"/login"})
    public ResponseEntity<Object> authenticate(@RequestBody LoginRequest loginRequest) throws JsonSyntaxException, JsonProcessingException, IOException {
        this.logger.trace("Authenticate Method accessed..");
        this.logger.info("Login details : " + this.gson.toJson((Object) loginRequest));
        return this.orderService.authenticateUser(loginRequest);
    }

    @PostMapping(value = {"/run/order"})
    public ResponseEntity<Object> sendNumericRunId(@RequestBody OrderDTO order, @RequestHeader(value = "Authorization") String authHeader) throws Exception {
        this.logger.trace("sendNumericRunId method accessed..");
        return this.orderService.sendNumericRunId(order, authHeader);
    }

    @GetMapping(value = {"/run/order/status/{numericRunId}"})
    public Object sendJobStatusByNumericRunId(@PathVariable(value = "numericRunId") String numericRunId, @RequestHeader(value = "Authorization") String authHeader) throws IOException {
        this.logger.trace("sendJobStatusByNumericRunId method accessed..");
        this.logger.info("Numeric Run Id from request :" + numericRunId);
        return this.orderService.sendJobStatusBySLAApi(numericRunId, authHeader);
    }
}
