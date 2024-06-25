package com.forum.hub.ForumApi.service;

import com.forum.hub.ForumApi.dto.user.UserDTO;
import com.forum.hub.ForumApi.dto.user.UserResponseDTO;
import com.forum.hub.ForumApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.forum.hub.ForumApi.model.user.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileService profileService;


    public User regiter(UserDTO data) {

        var profile = profileService.register(data.profile().getName());

        var newUser = new User(data, profile);

        return userRepository.save(newUser);
    }

    public Page<UserResponseDTO> list(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserResponseDTO::new);
    }
}
