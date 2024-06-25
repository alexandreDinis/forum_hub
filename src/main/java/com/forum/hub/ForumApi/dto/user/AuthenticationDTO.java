package com.forum.hub.ForumApi.dto.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(@NotBlank String user, @NotBlank String password) {
}
