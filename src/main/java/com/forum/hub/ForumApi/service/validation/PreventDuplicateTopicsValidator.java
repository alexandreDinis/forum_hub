package com.forum.hub.ForumApi.service.validation;

import com.forum.hub.ForumApi.infra.exception.DuplicateTopicException;
import com.forum.hub.ForumApi.model.topic.Topic;
import com.forum.hub.ForumApi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PreventDuplicateTopicsValidator implements ITopicsValidations{

    @Autowired
    private TopicRepository topicRepository;


    @Override
    public void validate(Topic data) {

        boolean exists = topicRepository.existsByTitleAndMessage(data.getTitle(), data.getMessage());
        if (exists) {
            throw new DuplicateTopicException("Topic with the same title and message already exists.");
        }
    }
}
