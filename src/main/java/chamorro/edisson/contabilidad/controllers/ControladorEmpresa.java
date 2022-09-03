package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.entities.Empresa;
import chamorro.edisson.contabilidad.services.EmpresaServicio;
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

    @GetMapping("/{id}")
    public Empresa getEmpresa(@PathVariable("id") int id) {
        return this.servicio.getEmpresa(id);
    }

    @PostMapping("")
    public Empresa crearEmpresa(@RequestBody Empresa empresaNueva) {
        return this.servicio.postEmpresa(empresaNueva);
    }

    @PutMapping("/{id}")
    public void patchEmpresa(@PathVariable("id") int id) {
        this.servicio.patchEmpresa(this.getEmpresa(id));
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable("id") int id){
        this.servicio.deleteEmpresa(id);
    }
}
