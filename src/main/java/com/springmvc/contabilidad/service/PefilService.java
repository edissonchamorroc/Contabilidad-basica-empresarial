package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Perfil;
import com.springmvc.contabilidad.repository.PerfilRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class PefilService {

    PerfilRepository perfilRepository;


    public List<Perfil> getRoles() {

        return this.perfilRepository.findAll();

    }
}
