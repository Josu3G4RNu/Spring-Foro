package com.JosueGarNu.SpringForo.Domain.Topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findByActivoTrue();

    @Query("SELECT true FROM Topico t where t.id = :id and t.activo = true ")
    boolean existeYEstaActivo(Long id);

}
