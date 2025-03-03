package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
@Table(name = "planteles")
@Getter
@Setter
public class Plantel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String clave;

    @OneToMany(mappedBy = "plantel", cascade = CascadeType.ALL)
    private List<Salon> salones;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;


}
