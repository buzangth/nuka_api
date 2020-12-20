package com.genetics.nuka_api.exception.UserException;


public class UserIdExceptionResponse {

    private String username;

    public UserIdExceptionResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
