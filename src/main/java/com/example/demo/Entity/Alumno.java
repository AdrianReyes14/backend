package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alumnos")
@Getter
@Setter
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 20)
    private String matricula;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String apellido;

    @Column (length = 255)
    private String segundoApellido;

    @Column(nullable = false, length = 10)
    private String generacion;

    @Column(length = 18, unique = true)
    private String curp;

    @Column (length = 255, unique = true)
    private String correoElectronico;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private Estatus estatus = Estatus.ACTIVO;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "plantel_id", nullable = false)
    private Plantel plantel;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    private Salon salon;

    public enum Estatus{
        ACTIVO, INACTIVO
    }
}
