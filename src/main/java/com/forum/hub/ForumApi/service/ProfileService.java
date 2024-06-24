package com.forum.hub.ForumApi.service;

import com.forum.hub.ForumApi.model.user.Profile;
import com.forum.hub.ForumApi.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    public Profile register(String name) {

        return repository.save(new Profile(name));
    }
}
