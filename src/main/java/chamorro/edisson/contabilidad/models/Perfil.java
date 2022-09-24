package chamorro.edisson.contabilidad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nombre;

    @Column
    private String cargo;

    @JsonIgnore
    @OneToOne(mappedBy = "perfil")
    private Empleado Empleado;
}
