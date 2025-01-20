package com.JosueGarNu.SpringForo.Domain.Curso;

public enum Materia {
    CODING("Código"),
    DATABASE ("Bases de Datos"),
    SOFTWARE("Aplicaciones/Herramientas"),
    CURSE("Formación"),
    SPRINGBOOT("SPRING BOOT 3");

    private String materiaEs;

    Materia(String materiaEnEspañol) {
        this.materiaEs = materiaEnEspañol;
    }

    public String getMateriaEs() {
        return materiaEs;
    }

    public static Materia obtenerMateria(String materia) {
        for (Materia m : values()) {
            if (m.materiaEs.equalsIgnoreCase(materia)) {
                return m;
            }
        }
        throw new IllegalArgumentException("No se encontró la materia: " + materia);
}
}
