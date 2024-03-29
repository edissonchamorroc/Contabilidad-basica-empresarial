package com.springmvc.contabilidad.model;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@ToString
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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Transaction> transactions = new ArrayList<>();


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_r")
    private Perfil perfil;

}
