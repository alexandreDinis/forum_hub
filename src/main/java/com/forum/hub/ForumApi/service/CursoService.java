package com.forum.hub.ForumApi.service;

import com.forum.hub.ForumApi.dto.CursoDTO;
import com.forum.hub.ForumApi.model.curso.Curso;
import com.forum.hub.ForumApi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public CursoDTO register(CursoDTO data) {

        var newCurso = repository.save(new Curso(data));

        return new CursoDTO(newCurso);
    }


    public Page<CursoDTO> list(Pageable pageable) {

        return repository.findAll(pageable).map(CursoDTO::new);
    }
}
