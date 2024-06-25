package com.forum.hub.ForumApi.service;

import com.forum.hub.ForumApi.dto.user.AuthenticationDTO;
import com.forum.hub.ForumApi.dto.user.UserDTO;
import com.forum.hub.ForumApi.dto.user.UserResponseDTO;
import com.forum.hub.ForumApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.forum.hub.ForumApi.model.user.User;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    @Lazy
    private AuthenticationManager manager;


    public User regiter(UserDTO data) {

        var profile = profileService.register(data.profile().getName());

        var newUser = new User(data, profile);

        return userRepository.save(newUser);
    }

    public Page<UserResponseDTO> list(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserResponseDTO::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByName(username);
    }

    public Authentication authentication(AuthenticationDTO data) {

        var token = new UsernamePasswordAuthenticationToken(data.user(), data.password());
        return manager.authenticate(token);
    }
}
