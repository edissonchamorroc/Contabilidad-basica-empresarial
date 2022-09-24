package chamorro.edisson.contabilidad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private float monto;
    @Column
    private String concepto;
    @Column
    private LocalDate fecha;


    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;

    public MovimientoDinero(    ) {

    }


}
