package com.forum.hub.ForumApi.dto;

import com.forum.hub.ForumApi.model.user.Profile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfileDTO(@NotNull Long id, @NotBlank String nome) {

        public ProfileDTO(Profile data) {
                this(data.getId(), data.getName());
        }
}
