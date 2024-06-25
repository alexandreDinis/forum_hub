package com.forum.hub.ForumApi.dto.topic;


import com.forum.hub.ForumApi.dto.curso.CursoDTO;
import com.forum.hub.ForumApi.dto.response.ResponseDTO;
import com.forum.hub.ForumApi.dto.user.ProfileDTO;
import com.forum.hub.ForumApi.model.topic.Topic;
import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

public record TopicDetalsDTO (Long id, String titulo, String mensagem, ProfileDTO profile, @Valid CursoDTO curso, List<ResponseDTO> responses) {

    public TopicDetalsDTO(Topic data) {
        this(data.getId(), data.getTitle(), data.getMessage(),new ProfileDTO(data.getAuthor().getProfile()),new CursoDTO(data.getCurso()),
                data.getResponses().stream().map(ResponseDTO::new).collect(Collectors.toList()));
    }
}
