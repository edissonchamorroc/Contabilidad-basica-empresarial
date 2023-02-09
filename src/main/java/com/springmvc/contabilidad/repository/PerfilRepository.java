package com.springmvc.contabilidad.repository;

import com.springmvc.contabilidad.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
