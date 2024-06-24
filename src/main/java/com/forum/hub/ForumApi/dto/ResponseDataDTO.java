package com.forum.hub.ForumApi.dto;

import com.forum.hub.ForumApi.model.topic.Response;

import java.time.LocalDateTime;

public record ResponseDataDTO( String message, Long user_id, LocalDateTime dateCreation) {

    public ResponseDataDTO(Response data) {
        this(data.getMessage(), data.getAuthor().getId(), data.getCreationDate() );
    }



}
