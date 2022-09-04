package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.entities.Empresa;
import chamorro.edisson.contabilidad.services.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/enterprises")
public class ControladorEmpresa {

    @Autowired
    EmpresaServicio servicio;


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

    @PatchMapping("/{id}")
    public void patchEmpresa(@PathVariable("id") long id,@RequestBody Empresa datos) {
        this.servicio.patchEmpresa(id,datos);
    }

    @DeleteMapping("/{id}")
    public void deleteEmpresa(@PathVariable("id") int id){
        this.servicio.deleteEmpresa(id);
    }
}
