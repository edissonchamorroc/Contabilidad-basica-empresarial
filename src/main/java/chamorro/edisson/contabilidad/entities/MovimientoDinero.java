package chamorro.edisson.contabilidad.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mov")
    private Long id;
    @Column(name = "Monto")
    private float monto;
    @Column(name = "Concepto")
    private String concepto;

    @JsonIgnore
    @JoinColumn(name = "id_emp")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;//es el mismo nombre plasmado en clase Empleado linea 13

    public MovimientoDinero(    ) {

    }


}
