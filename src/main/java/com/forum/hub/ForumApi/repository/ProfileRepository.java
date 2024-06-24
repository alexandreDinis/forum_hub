package com.forum.hub.ForumApi.repository;

import com.forum.hub.ForumApi.model.user.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
