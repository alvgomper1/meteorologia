package com.meteorologia.aparicio.app.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(
        name = "estacion",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "punto_control")
        }
)
@Getter
@Setter
@ToString(exclude = "series")
public class EstacionDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipologia;

    @Column(name = "punto_control", nullable = false, unique = true)
    private String puntoControl;

    private String municipio;
    private String provincia;
    private Boolean pluviometro;
    private Boolean termometro;
    private double latitud;
    private double longitud;
    private Double media;
    private Integer aniosUtilizados;
    private String periodo;

    @OneToMany(mappedBy = "estacion", fetch = FetchType.LAZY)
    private List<SerieEntity> series;
}