package com.forum.hub.ForumApi.dto.topic;

import com.forum.hub.ForumApi.model.topic.Topic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(

        Long id,

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        Long autor,

        @NotNull
        Long curso) {

        public TopicDTO(Topic data) {
                this(data.getId(), data.getTitle(), data.getMessage(),data.getAuthor().getId(),data.getCurso().getId());
        }
}
