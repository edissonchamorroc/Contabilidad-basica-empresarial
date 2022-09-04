package chamorro.edisson.contabilidad.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa")
    private long idempresa;
    @Column(name = "Nit")
    private String nit;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "empresa")
    private List<Empleado> empleadoList = new ArrayList<>();

    public Empresa() {

    }
}