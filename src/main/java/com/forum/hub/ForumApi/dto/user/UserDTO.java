package com.forum.hub.ForumApi.dto.user;


import com.forum.hub.ForumApi.model.user.Profile;
import com.forum.hub.ForumApi.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public record UserDTO(


        Long id,

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String password,

        @NotNull
        @Valid
        Profile profile,

        @NotNull
        LocalDateTime dateCreate){

    public UserDTO(User data) {
        this(data.getId(), data.getName(), data.getEmail(), data.getPassword(),data.getProfile(), data.getCreationDate() );
    }
}
