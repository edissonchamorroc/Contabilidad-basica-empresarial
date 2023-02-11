package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Perfil;
import com.springmvc.contabilidad.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PefilService {

    @Autowired
    PerfilRepository perfilRepository;


    public List<Perfil> getRoles() {

        return this.perfilRepository.findAll();

    }
}
