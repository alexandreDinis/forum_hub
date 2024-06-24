package com.forum.hub.ForumApi.infra.exception;

public class TopicClosedException extends RuntimeException{

    public TopicClosedException(String message) {
        super(message);
    }

    public TopicClosedException(String message, Throwable cause) {
        super(message, cause);
    }
}
