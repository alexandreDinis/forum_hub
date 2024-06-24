package com.forum.hub.ForumApi.dto;


import com.forum.hub.ForumApi.model.topic.Topic;
import jakarta.validation.Valid;

public record TopicResponseDTO(Long id, String titulo, String mensagem, String autor, @Valid CursoDTO curso) {

    public TopicResponseDTO(Topic data) {
        this(data.getId(), data.getTitle(), data.getMessage(), data.getAuthor().getName(),new CursoDTO(data.getCurso()));
    }
}
