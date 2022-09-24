package chamorro.edisson.contabilidad.services;

import chamorro.edisson.contabilidad.models.Empresa;
import chamorro.edisson.contabilidad.repositories.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    EmpresaRepositorio repositorio;

    public EmpresaService(EmpresaRepositorio repositorio) {
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

    public void patchEmpresa(long id, Empresa actualizarEmpresa) {
        Empresa empresaActualizar = this.repositorio.findById(id).get();
        if (this.repositorio.findById(id).isPresent()) {
            if (actualizarEmpresa.getId()!= 0) empresaActualizar.setId(actualizarEmpresa.getId());
            if (actualizarEmpresa.getDireccion() != null)
                empresaActualizar.setDireccion(actualizarEmpresa.getDireccion());
            if (actualizarEmpresa.getNit() != null) empresaActualizar.setNit(actualizarEmpresa.getNit());
            if (actualizarEmpresa.getNombre() != null) empresaActualizar.setNombre(actualizarEmpresa.getNombre());
            this.repositorio.save(empresaActualizar);
        }
    }

    public void deleteEmpresa(long id) {
        this.repositorio.deleteById(id);
    }
}
