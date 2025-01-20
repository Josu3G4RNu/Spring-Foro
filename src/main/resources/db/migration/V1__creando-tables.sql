CREATE TABLE cursos
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255) NULL,
    CONSTRAINT pk_cursos PRIMARY KEY (id)
);

CREATE TABLE respuestas
(
    id               BIGINT AUTO_INCREMENT NOT NULL,
    topico_id        BIGINT NULL,
    autor_id         BIGINT NULL,
    mensaje          VARCHAR(255) NULL,
    hora_de_creacion datetime NULL,
    CONSTRAINT pk_respuestas PRIMARY KEY (id)
);

CREATE TABLE topics
(
    id                BIGINT AUTO_INCREMENT NOT NULL,
    curso_id          BIGINT NULL,
    titulo            VARCHAR(255) NULL,
    descripcion       VARCHAR(255) NULL,
    autor_id          BIGINT NOT NULL,
    fecha_publicacion datetime NULL,
    estado            VARCHAR(255) NULL,
    CONSTRAINT pk_topics PRIMARY KEY (id)
);

CREATE TABLE usuarios
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    nombre   VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_usuarios PRIMARY KEY (id)
);

ALTER TABLE cursos
    ADD CONSTRAINT uc_cursos_nombre UNIQUE (nombre);

ALTER TABLE topics
    ADD CONSTRAINT uc_topics_descripcion UNIQUE (descripcion);

ALTER TABLE topics
    ADD CONSTRAINT uc_topics_titulo UNIQUE (titulo);

ALTER TABLE usuarios
    ADD CONSTRAINT uc_usuarios_email UNIQUE (email);

ALTER TABLE usuarios
    ADD CONSTRAINT uc_usuarios_nombre UNIQUE (nombre);

ALTER TABLE respuestas
    ADD CONSTRAINT FK_RESPUESTAS_ON_AUTOR FOREIGN KEY (autor_id) REFERENCES usuarios (id);

ALTER TABLE respuestas
    ADD CONSTRAINT FK_RESPUESTAS_ON_TOPICO FOREIGN KEY (topico_id) REFERENCES topics (id);

ALTER TABLE topics
    ADD CONSTRAINT FK_TOPICS_ON_AUTOR FOREIGN KEY (autor_id) REFERENCES usuarios (id);

ALTER TABLE topics
    ADD CONSTRAINT FK_TOPICS_ON_CURSO FOREIGN KEY (curso_id) REFERENCES cursos (id);