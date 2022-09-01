package chamorro.edisson.contabilidad.services;

import chamorro.edisson.contabilidad.entities.Empresa;
import chamorro.edisson.contabilidad.repositories.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServicio {

    EmpresaRepositorio repositorio;

    public EmpresaServicio(EmpresaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Empresa> getEmpresas(){
        return this.repositorio.findAll();
    }

    public Empresa getEmpresa(long id){
        return this.repositorio.getReferenceById(id);
    }
}
