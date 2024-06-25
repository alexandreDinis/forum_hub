package com.forum.hub.ForumApi.infra.exception;


public class ResponseNotFoundException extends RuntimeException{

    public ResponseNotFoundException(String message) {
        super(message);
    }
}
