package chamorro.edisson.contabilidad.repositories;

import chamorro.edisson.contabilidad.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long> {
}
