package com.springmvc.contabilidad.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "empresas")
@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_c")
    private long id;
    @Column
    private String nit;
    @Column
    private String name;
    @Column
    private String adress;
    @Column
    private Date dateCreation;
    @Column
    private Date dateUpdate;

    @OneToMany(mappedBy = "enterprise",cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();



}
