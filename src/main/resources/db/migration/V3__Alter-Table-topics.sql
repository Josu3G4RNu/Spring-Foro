ALTER TABLE topics
    ADD activo BIT(1) NULL;

ALTER TABLE topics
    ADD fecha_de_creacion datetime NULL;

ALTER TABLE topics
DROP
COLUMN fecha_publicacion;