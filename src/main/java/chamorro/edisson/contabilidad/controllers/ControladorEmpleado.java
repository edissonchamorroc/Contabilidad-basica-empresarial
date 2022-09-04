package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.entities.Empleado;
import chamorro.edisson.contabilidad.entities.Empresa;
import chamorro.edisson.contabilidad.services.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ControladorEmpleado {
    @Autowired
    EmpleadoServicio servicio;

    @GetMapping("")
    public List<Empleado> getEmpleados() {

        return this.servicio.getEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado getEmpleado(@PathVariable("id") int id) {

        return this.servicio.getEmpleado(id);
    }

    @PostMapping("")
    public Empleado crearEmpleado(@RequestBody Empleado empresaNueva) {
        return this.servicio.postEmpleado(empresaNueva);
    }

    @PatchMapping("/{id}")
    public void patchEmpleado(@PathVariable("id") long id, @RequestBody Empleado datos) {
        this.servicio.patchEmpleado(id, datos);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable("id") int id) {
        this.servicio.deleteEmpleado(id);
    }
}
