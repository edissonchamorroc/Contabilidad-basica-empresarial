package chamorro.edisson.contabilidad.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_emp")
    private long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "empleado")
    private List<MovimientoDinero> movimientoDineros;

    @JoinColumn(name = "id_empresa")
    @ManyToOne()
    private Empresa empresa;


    public Empleado (){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MovimientoDinero> getMovimientoDineros() {
        return movimientoDineros;
    }

    public void setMovimientoDineros(List<MovimientoDinero> movimientoDineros) {
        this.movimientoDineros = movimientoDineros;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresaList(Empresa empresa) {
        this.empresa = empresa;
    }
}
