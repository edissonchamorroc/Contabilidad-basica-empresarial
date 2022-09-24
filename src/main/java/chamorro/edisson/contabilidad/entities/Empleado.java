package chamorro.edisson.contabilidad.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Empleado {

    @Id
    @Column(name="id_emp")
    private long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "empleado")
    private List<MovimientoDinero> movimientoDineros;

    @JsonIgnore
    @JoinColumn(name = "id_empresa")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;


    public Empleado (){

    }

}
