package com.forum.hub.ForumApi.dto.curso;

import com.forum.hub.ForumApi.model.curso.Category;
import com.forum.hub.ForumApi.model.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CursoDTO(

        Long id,

        @NotBlank
        String name,

        @NotNull
        Category category) {

    public CursoDTO(Curso data) {
        this(data.getId(), data.getName(), data.getCategory());
    }

}
