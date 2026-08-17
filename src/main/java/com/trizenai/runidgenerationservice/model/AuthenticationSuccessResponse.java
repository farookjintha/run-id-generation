package com.trizenai.runidgenerationservice.model;

// TODO: confirm this matches the real Control-M login response body.
public class AuthenticationSuccessResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
