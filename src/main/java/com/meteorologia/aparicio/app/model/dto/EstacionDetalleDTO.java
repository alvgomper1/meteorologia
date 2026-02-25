package com.meteorologia.aparicio.app.model.dto;

import java.util.List;


public record EstacionDetalleDTO(
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
        List<SerieDTO> series
) {}
