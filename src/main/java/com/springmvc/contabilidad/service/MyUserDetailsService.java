package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Employee;
import com.springmvc.contabilidad.model.Perfil;
import com.springmvc.contabilidad.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class MyUserDetailsService implements IMyUserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    PefilService pefilService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findByEmail(username);

        if (employee != null) throw new UsernameNotFoundException("Usuario no válido");

        return new User(employee.getEmail(), employee.getPassword(), authoritiesToRoles(employee.getPerfil()));
    }

    public Collection<? extends GrantedAuthority> authoritiesToRoles(Perfil role) {

        return Collections.singleton(new SimpleGrantedAuthority(role.getName()));

    }

}
