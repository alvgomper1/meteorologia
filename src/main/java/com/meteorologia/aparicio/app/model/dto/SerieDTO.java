package com.meteorologia.aparicio.app.model.dto;

public record SerieDTO(
        String etiqueta,
        Double valor,
        Double cobertura,
        String checkValue,
        Double pctMedia
) {}