package com.forum.hub.ForumApi.dto;

import com.forum.hub.ForumApi.model.topic.Response;
import com.forum.hub.ForumApi.model.user.User;

import java.time.LocalDateTime;

public record ResponseDTO(Long id, String message, ProfileDTO profile, LocalDateTime dateCreation, Boolean solution) {

    public ResponseDTO(Response data) {
        this(data.getId(),data.getMessage(), new ProfileDTO(data.getAuthor().getProfile()), data.getCreationDate(), data.getSolution());
    }



}
