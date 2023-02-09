package com.springmvc.contabilidad.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleados")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_e")
    private long id;


    private String name;
    @Column(unique = true)
    private String email;

    private String password;

    private Date dateCreation;

    private Date dateUpdate;

    private String position;

    @ManyToOne
    @JoinColumn(name = "id_c")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_r")
    private Perfil perfil;

}
