package chamorro.edisson.contabilidad.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

enum Role{
    ADMIN,
    USER
}
@ToString
@Getter
@Setter
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    private long id;
    @Column
    private String nombre;


    @Column(unique = true)
    private String email;
    @Column
    private String password;


    @OneToOne
    private Perfil perfil;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "empleado")
    private Collection<MovimientoDinero> movimientoDineros;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;


    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<Role> roles;

    public Empleado(long id,String nombre,String email,String password, List<Role> roles){
        this.id=id;
        this.nombre=nombre;
        this.email=email;
        this.password=password;
        this.roles=roles;
    }
    public Empleado (){

    }

}
