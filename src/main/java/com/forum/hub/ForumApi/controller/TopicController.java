package com.forum.hub.ForumApi.controller;

import com.forum.hub.ForumApi.dto.response.ResponseDataDTO;
import com.forum.hub.ForumApi.dto.topic.TopicDTO;
import com.forum.hub.ForumApi.dto.topic.TopicResponseDTO;
import com.forum.hub.ForumApi.dto.topic.UpdateTopicDTO;
import com.forum.hub.ForumApi.service.TopicService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicController {


    @Autowired
    private TopicService service;


    @PostMapping
    @Transactional
    public ResponseEntity createTopic(@RequestBody  @Valid TopicDTO data) {

        var newTopic = service.createTopic(data);

        return ResponseEntity.ok(newTopic);
    }

    @GetMapping
    public Page<TopicResponseDTO> list (Pageable pageable) {
        return  service.list(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity getTopicDetails (@PathVariable Long id) {
        var topic = service.getTopicDetails(id);

        return ResponseEntity.ok(topic);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete (@PathVariable Long id) {
         service.delete(id);

         return ResponseEntity.noContent().build();
    }
    @PostMapping("/{id}/resposta")
    @Transactional
    public ResponseEntity createResponse(@PathVariable Long id, @RequestBody ResponseDataDTO data) {

        var  newResponse = service.createResponse(id , data );

        return ResponseEntity.ok(newResponse);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<?> update (@PathVariable Long id, @RequestBody @Valid UpdateTopicDTO data) {

        service.updateResponse(id, data.user_id(), data.response_id());

        return ResponseEntity.ok().build();
    }
}
