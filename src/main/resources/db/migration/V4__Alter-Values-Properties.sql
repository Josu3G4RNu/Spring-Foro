ALTER TABLE usuarios
    MODIFY email VARCHAR (255) NOT NULL;

ALTER TABLE cursos
    MODIFY nombre VARCHAR (255) NOT NULL;

ALTER TABLE usuarios
    MODIFY nombre VARCHAR (255) NOT NULL;

ALTER TABLE usuarios
    MODIFY password VARCHAR (255) NOT NULL;