package com.springmvc.contabilidad.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movimientos")
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float cuantity;

    private String concept;

    private Date dateCreation;

    private Date dateUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_e")
    private Employee employee;

}
