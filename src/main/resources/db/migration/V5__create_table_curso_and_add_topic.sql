-- Criação da tabela Cursos
CREATE TABLE cursos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);

-- Adição da coluna curso_id na tabela Topics
ALTER TABLE topics ADD COLUMN curso_id BIGINT;
ALTER TABLE topics ADD CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES cursos(id);

