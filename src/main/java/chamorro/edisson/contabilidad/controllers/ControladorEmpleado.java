package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.entities.Empleado;
import chamorro.edisson.contabilidad.entities.Empresa;
import chamorro.edisson.contabilidad.services.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView crearEmpleado(@ModelAttribute Empleado empleadoNuevo, Model model) {
        model.addAttribute(empleadoNuevo);
        return new RedirectView("/RegistroExitoso");
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
