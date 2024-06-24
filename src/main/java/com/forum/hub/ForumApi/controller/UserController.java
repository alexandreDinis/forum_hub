package com.forum.hub.ForumApi.controller;


import com.forum.hub.ForumApi.dto.UserDTO;
import com.forum.hub.ForumApi.dto.UserResponseDTO;
import com.forum.hub.ForumApi.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class UserController {


    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserDTO data){

        var newUser = service.regiter(data);

        return ResponseEntity.ok(new UserDTO(newUser));
    }

    @GetMapping
    public Page<UserResponseDTO> list (Pageable pageable) {
        return service.list(pageable);
    }
}
