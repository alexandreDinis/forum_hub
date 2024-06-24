package com.forum.hub.ForumApi.model.user;


import com.forum.hub.ForumApi.dto.UserDTO;
import com.forum.hub.ForumApi.model.topic.Response;
import com.forum.hub.ForumApi.model.topic.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "author")
    private List<Topic> topics = new ArrayList<>();

    @OneToMany(mappedBy = "author")
    private List<Response> responses = new ArrayList<>();



    public User(UserDTO data, Profile profile) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
        this.creationDate = data.dateCreate();
        this.profile = profile;
    }
}


