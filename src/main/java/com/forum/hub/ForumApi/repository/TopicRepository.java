package com.forum.hub.ForumApi.repository;

import com.forum.hub.ForumApi.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t FROM Topic t WHERE t.id = :id AND t.status = true")
    Topic findActiveTopicById(@Param("id") Long id);
}
