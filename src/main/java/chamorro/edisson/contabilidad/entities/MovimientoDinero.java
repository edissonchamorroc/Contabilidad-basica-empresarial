package chamorro.edisson.contabilidad.entities;

import javax.persistence.*;

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

    @JoinColumn(name = "id_empresa")
    @ManyToOne()
    private Empleado empleado;//es el mismo nombre plasmado en clase Empleado linea 13

    public MovimientoDinero(    ) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
