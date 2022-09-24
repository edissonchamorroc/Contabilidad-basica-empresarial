package chamorro.edisson.contabilidad.repositories;

import chamorro.edisson.contabilidad.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa,Long> {

}
