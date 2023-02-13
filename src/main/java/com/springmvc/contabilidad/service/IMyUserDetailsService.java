package com.springmvc.contabilidad.service;

import com.springmvc.contabilidad.model.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IMyUserDetailsService extends UserDetailsService {

    public Employee getUserDetailsService();
}
