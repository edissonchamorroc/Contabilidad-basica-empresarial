package chamorro.edisson.contabilidad.repositories;

import chamorro.edisson.contabilidad.models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepositorio extends JpaRepository<Perfil,Long> {
}
