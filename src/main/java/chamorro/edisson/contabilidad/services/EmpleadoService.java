package chamorro.edisson.contabilidad.services;

import chamorro.edisson.contabilidad.models.Empleado;
import chamorro.edisson.contabilidad.repositories.EmpleadoRepositorio;

import org.springframework.stereotype.Service;



import java.util.List;


@Service
public class EmpleadoService{

    EmpleadoRepositorio repositorio;

    public EmpleadoService(EmpleadoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Empleado> getEmpleados() {
        return this.repositorio.findAll();
    }

    public Empleado getEmpleado(long id) {
        return this.repositorio.findById(id).get();
    }

    public Empleado getEmpleado(String email){
        return repositorio.findByEmail(email);
    }

    public Empleado postEmpleado(Empleado empleadoNuevo) {

        return this.repositorio.save(empleadoNuevo);
    }

    public void patchEmpleado(long id, Empleado actualizarEmpleado) {
        Empleado empleadoActualizar = this.repositorio.findById(id).get();
        if (this.repositorio.findById(id).isPresent()) {
            if (actualizarEmpleado.getId() != 0) empleadoActualizar.setId(actualizarEmpleado.getId());
            if (actualizarEmpleado.getNombre() != null) empleadoActualizar.setNombre(actualizarEmpleado.getNombre());
            if (actualizarEmpleado.getEmail() != null) empleadoActualizar.setEmail(actualizarEmpleado.getEmail());
            this.repositorio.save(empleadoActualizar);
        }
    }

    public void deleteEmpleado(long id) {
        this.repositorio.deleteById(id);
    }

}
