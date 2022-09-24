package chamorro.edisson.contabilidad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column
    private String nit;
    @Column
    private String nombre;
    @Column
    private String direccion;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "empresa")
    private List<Empleado> empleadoList = new ArrayList<>();

    public Empresa() {

    }
}