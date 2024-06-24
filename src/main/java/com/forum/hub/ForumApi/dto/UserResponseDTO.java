package com.forum.hub.ForumApi.dto;

import com.forum.hub.ForumApi.model.user.User;
import jakarta.validation.Valid;

public record UserResponseDTO(Long id, String name, String email, @Valid ProfileDTO profile) {
    public UserResponseDTO(User data) {
        this(data.getId(), data.getName(), data.getEmail(), new ProfileDTO(data.getProfile()));
    }
}
