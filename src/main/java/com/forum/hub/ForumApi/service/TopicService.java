package com.forum.hub.ForumApi.service;


import com.forum.hub.ForumApi.dto.response.ResponseDTO;
import com.forum.hub.ForumApi.dto.response.ResponseDataDTO;
import com.forum.hub.ForumApi.dto.topic.TopicDTO;
import com.forum.hub.ForumApi.dto.topic.TopicDetalsDTO;
import com.forum.hub.ForumApi.dto.topic.TopicResponseDTO;
import com.forum.hub.ForumApi.infra.exception.ResponseNotFoundException;
import com.forum.hub.ForumApi.infra.exception.TopicClosedException;
import com.forum.hub.ForumApi.infra.exception.UserNotFoundException;
import com.forum.hub.ForumApi.model.topic.Response;
import com.forum.hub.ForumApi.model.topic.Topic;
import com.forum.hub.ForumApi.repository.CursoRepository;
import com.forum.hub.ForumApi.repository.ResponseRepository;
import com.forum.hub.ForumApi.repository.TopicRepository;
import com.forum.hub.ForumApi.repository.UserRepository;
import com.forum.hub.ForumApi.service.validation.ITopicsValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {


    @Autowired
    private TopicRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private List<ITopicsValidations> validations;


    public TopicDTO createTopic(TopicDTO data) {

        var user = userRepository.findById(data.autor())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        var curso = cursoRepository.findById(data.curso())
                .orElseThrow(() -> new UserNotFoundException("curso not found"));

        var newTopic = new Topic(data);

        validations.forEach(v -> v.validate(newTopic));

        newTopic.setAuthor(user);
        newTopic.setCurso(curso);

        repository.save(newTopic);

        user.getTopics().add(newTopic);

        return new TopicDTO(newTopic);

    }
      public Page<TopicResponseDTO> list(Pageable pageable) {
            return   repository.findAll(pageable).map(TopicResponseDTO::new);
      }

    public TopicDetalsDTO getTopicDetails(Long id) {
        Topic topic = repository.findById(id)
                .orElseThrow(() -> new TopicClosedException("Topic with id " + id + " not found"));

        if (!topic.getStatus()) {
            throw new TopicClosedException("Topic with id " + id + " is closed");
        }
        return new TopicDetalsDTO(topic);
    }

    public void delete(Long id) {
       var topic = repository.getReferenceById(id);
       topic.delete();
    }

    public ResponseDTO createResponse(Long topic_id, ResponseDataDTO data) {

        var topic = repository.findById(topic_id)
                .orElseThrow(() -> new TopicClosedException("Topic with id " + topic_id + " not found"));

        var user = userRepository.findById(data.user_id())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        var newResponse = new Response(data);
        newResponse.setTopic(topic);
        newResponse.setAuthor(user);

        responseRepository.save(newResponse);

        topic.getResponses().add(newResponse);
        user.getResponses().add(newResponse);

        return new ResponseDTO(newResponse);
    }

    public void updateResponse(Long id, Long userId, Long response_id) {

        var topic = repository.findById(id)
                .orElseThrow(() -> new TopicClosedException("Topic with id " + id + " not found"));

        if(topic.getAuthor().getId().equals(userId)) {

            Response responseToUpdate = topic.getResponses().stream()
                    .filter(response -> response.getId().equals(response_id))
                    .findFirst()
                    .orElseThrow(() -> new ResponseNotFoundException("Response with id " + response_id + " not found in topic with id " + id));

            responseToUpdate.setSolution(true);
            repository.save(topic);
        } else {
            throw new UserNotFoundException("User is not the owner of the topic");
        }
    }
}
