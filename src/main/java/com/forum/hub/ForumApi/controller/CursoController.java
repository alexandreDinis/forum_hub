package com.forum.hub.ForumApi.controller;


import com.forum.hub.ForumApi.dto.CursoDTO;
import com.forum.hub.ForumApi.service.CursoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoService service;


    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid CursoDTO data) {

        var newCurso = service.register(data);

        return ResponseEntity.ok(newCurso);
    }

    @GetMapping
    public Page<CursoDTO> list(Pageable pageable) {

       return service.list(pageable);
    }
}
