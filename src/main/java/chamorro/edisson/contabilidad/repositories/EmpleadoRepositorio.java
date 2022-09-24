package chamorro.edisson.contabilidad.repositories;

import chamorro.edisson.contabilidad.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpleadoRepositorio extends JpaRepository<Empleado,Long> {
   /* @Query("select * from Empleado" +
            " inner join EmpleadoRoles ON id=EmpleadoId" +
            " where email:=email")*/
    public Empleado findByEmail(String email);
}
