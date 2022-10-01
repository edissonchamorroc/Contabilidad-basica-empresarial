package chamorro.edisson.contabilidad.services;

import chamorro.edisson.contabilidad.models.Empleado;
import chamorro.edisson.contabilidad.models.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    EmpleadoService empleadoService;
    private static Empleado empleado;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        empleado =null;
        try{
            empleado=empleadoService.getEmpleado(username);
            return new MyUserDetails(empleado);
        }catch (Exception e){
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());

        }

    }

    public Empleado getEmpleado(){
        return empleado;
    }
}