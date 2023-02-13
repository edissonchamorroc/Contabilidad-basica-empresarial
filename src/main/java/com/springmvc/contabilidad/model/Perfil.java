package com.springmvc.contabilidad.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_r")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "perfil",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<>();

}
