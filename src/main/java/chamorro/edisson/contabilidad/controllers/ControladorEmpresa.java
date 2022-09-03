package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.entities.Empresa;
import chamorro.edisson.contabilidad.services.EmpresaServicio;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/enterprises")
public class ControladorEmpresa {

    EmpresaServicio servicio;

    public ControladorEmpresa(EmpresaServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("")
    public List<Empresa> getEmpresas() {
        return this.servicio.getEmpresas();
    }

    @GetMapping("/empresa/{id}")
    public Empresa getEmpresa(@PathVariable("id") int id) {
        return this.servicio.getEmpresa(id);
    }

    @PostMapping("")
    public Empresa crearEmpresa(@RequestBody Empresa empresaNueva) {
        return this.servicio.postEmpresa(empresaNueva);
    }

    @PatchMapping("/{id}")
    public void patchEmpresa(@PathVariable("id") int id,@RequestBody Empresa actualizarEmpresa) {
        this.servicio.actualizarEmpresa(id,actualizarEmpresa);
    }
}
