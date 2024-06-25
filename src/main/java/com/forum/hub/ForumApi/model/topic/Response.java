package com.forum.hub.ForumApi.model.topic;


import com.forum.hub.ForumApi.dto.response.ResponseDataDTO;
import com.forum.hub.ForumApi.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "responses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;

    private Boolean solution;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    public Response(ResponseDataDTO data) {
        this.message = data.message();
        this.creationDate = data.dateCreation();
    }
}

