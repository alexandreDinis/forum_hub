package com.forum.hub.ForumApi.repository;

import com.forum.hub.ForumApi.model.topic.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}
