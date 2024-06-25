package com.forum.hub.ForumApi.model.topic;

import com.forum.hub.ForumApi.dto.topic.TopicDTO;
import com.forum.hub.ForumApi.model.curso.Curso;
import com.forum.hub.ForumApi.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;


    private Boolean status;

    @Column(nullable = false)
    private LocalDateTime creationDate;


    @OneToMany(mappedBy = "topic")
    private List<Response> responses = new ArrayList<>();

    public Topic(TopicDTO data) {
        this.status = true;
        this.title = data.titulo();
        this.message = data.mensagem();
        this.creationDate = LocalDateTime.now();
    }

    public void delete() {
        this.status = false;
    }
}

