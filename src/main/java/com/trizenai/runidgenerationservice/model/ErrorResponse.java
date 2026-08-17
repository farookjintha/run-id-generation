package com.trizenai.runidgenerationservice.model;

import java.util.ArrayList;

/**
 * TODO: only errors confirmed so far, via OrderService's error-handling
 * blocks (errorResponse.setErrors(errorList)); confirm against the real
 * decompiled source.
 */
public class ErrorResponse {

    private ArrayList<Error> errors;

    public ArrayList<Error> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<Error> errors) {
        this.errors = errors;
    }
}
