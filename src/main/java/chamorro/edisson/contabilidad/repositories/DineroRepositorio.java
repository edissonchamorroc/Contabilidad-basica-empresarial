package chamorro.edisson.contabilidad.repositories;

import chamorro.edisson.contabilidad.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DineroRepositorio extends JpaRepository<MovimientoDinero,Long> {
}
