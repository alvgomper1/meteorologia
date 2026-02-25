package com.meteorologia.aparicio.app.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "serie")
@Getter
@Setter
@ToString(exclude = "estacion")
public class SerieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * FK serie.punto_control -> estacion.punto_control
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "punto_control",
            referencedColumnName = "punto_control",
            nullable = false
    )
    private EstacionDetalleEntity estacion;

    private String etiqueta;
    private Double valor;
    private Double cobertura;

    @Column(name = "check_value")
    private String checkValue;

    private Double pctMedia;
}