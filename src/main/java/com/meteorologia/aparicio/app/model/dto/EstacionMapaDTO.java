package com.meteorologia.aparicio.app.model.dto;

public record EstacionMapaDTO(
        String nombre,
        String tipologia,
        String puntoControl,
        String municipio,
        String provincia,
        Boolean pluviometro,
        Boolean termometro,
        Double latitud,
        Double longitud,
        Double media,
        Integer aniosUtilizados,
        String periodo,
        String procedencia
) {}




