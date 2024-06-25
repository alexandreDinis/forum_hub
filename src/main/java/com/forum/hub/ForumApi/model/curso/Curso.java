package com.forum.hub.ForumApi.model.curso;

import com.forum.hub.ForumApi.dto.curso.CursoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    public Curso(CursoDTO data) {
        this.name = data.name();
        this.category = data.category();
    }
}
