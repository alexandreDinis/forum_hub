package com.forum.hub.ForumApi.controller;


import com.forum.hub.ForumApi.dto.user.AuthenticationDTO;
import com.forum.hub.ForumApi.dto.user.UserDTO;
import com.forum.hub.ForumApi.dto.user.UserResponseDTO;
import com.forum.hub.ForumApi.infra.security.TokenJWT;
import com.forum.hub.ForumApi.infra.security.TokenService;
import com.forum.hub.ForumApi.model.user.User;
import com.forum.hub.ForumApi.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserDTO data){

        var newUser = service.regiter(data);

        return ResponseEntity.ok(new UserDTO(newUser));
    }

    @GetMapping
    public Page<UserResponseDTO> list (Pageable pageable) {
        return service.list(pageable);
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthenticationDTO data) {

        var autetication = service.authentication(data);

        var token = tokenService.gerarToken((User) autetication.getPrincipal());

        return ResponseEntity.ok(new TokenJWT(token));
    }
}
