package chamorro.edisson.contabilidad.controllers;

import chamorro.edisson.contabilidad.entities.Empresa;
import chamorro.edisson.contabilidad.services.EmpresaServicio;
import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/enterprises")
public class ControladorEmpresa {

    EmpresaServicio servicio;

    public ControladorEmpresa(EmpresaServicio servicio){
        this.servicio=servicio;
    }

    @GetMapping("/empresas")
    public List<Empresa> getEmpresas(){
        return this.servicio.getEmpresas();
    }

    @GetMapping("/empresa/{id}")
    public Empresa getEmpresa(@PathVariable("id") int id){return this.servicio.getEmpresa(id);}
}
