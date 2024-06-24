package com.forum.hub.ForumApi.repository;

import com.forum.hub.ForumApi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
