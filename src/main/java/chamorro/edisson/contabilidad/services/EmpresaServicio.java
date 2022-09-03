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

    public List<Empresa> getEmpresas() {
        return this.repositorio.findAll();
    }

    public Empresa getEmpresa(long id) {
        return this.repositorio.findById(id).get();
    }

    public Empresa postEmpresa(Empresa empresaNueva) {
        return this.repositorio.save(empresaNueva);
    }

    public void patchEmpresa(Empresa actualizarEmpresa) {
        this.repositorio.save(actualizarEmpresa);
    }

    public void deleteEmpresa(long id){
        this.repositorio.deleteById(id);
    }
}
