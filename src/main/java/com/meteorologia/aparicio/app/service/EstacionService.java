package com.meteorologia.aparicio.app.service;

import com.meteorologia.aparicio.app.model.dto.EstacionDetalleDTO;
import com.meteorologia.aparicio.app.model.dto.EstacionMapaDTO;
import com.meteorologia.aparicio.app.model.dto.SerieDTO;
import com.meteorologia.aparicio.app.model.entity.EstacionDetalleEntity;
import com.meteorologia.aparicio.app.model.entity.SerieEntity;
import com.meteorologia.aparicio.app.repository.EstacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EstacionService {

    private final EstacionRepository repository;

    /**
     *  Estaciones ligeras para el mapa
     */
    public List<EstacionMapaDTO> getAllEstaciones() {
        List<EstacionDetalleEntity> estaciones = repository.findAll(); 
        return mapToEstacionMapaDTO(estaciones);
    }



    /**
     *  Estación completa con series
     */
    public EstacionDetalleDTO getEstacionDetalleById(String id) {

        EstacionDetalleEntity estacionDetalleEntity = repository.findByPuntoControl(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("No existe la estación " + id)
                );
        return mapToEstacionDetalleDTO(estacionDetalleEntity);
    }

    private static List<EstacionMapaDTO> mapToEstacionMapaDTO(List<EstacionDetalleEntity> estaciones) {
        return estaciones.stream()
                .map(estacion ->
                        new EstacionMapaDTO(
                                estacion.getNombre(),
                                estacion.getTipologia(),
                                estacion.getPuntoControl(),
                                estacion.getMunicipio(),
                                estacion.getProvincia(),
                                estacion.getPluviometro(),
                                estacion.getTermometro(),
                                estacion.getLatitud(),
                                estacion.getLongitud(),
                                estacion.getMedia(),
                                estacion.getAniosUtilizados(),
                                estacion.getPeriodo()
                        ))
                .toList();
    }

    private EstacionDetalleDTO mapToEstacionDetalleDTO(EstacionDetalleEntity estacion) {

        return new EstacionDetalleDTO(
                estacion.getNombre(),
                estacion.getTipologia(),
                estacion.getPuntoControl(),
                estacion.getMunicipio(),
                estacion.getProvincia(),
                estacion.getPluviometro(),
                estacion.getTermometro(),
                estacion.getLatitud(),
                estacion.getLongitud(),
                estacion.getMedia(),
                estacion.getAniosUtilizados(),
                estacion.getPeriodo(),
                mapToSerieDTO(estacion.getSeries())
        );
    }

    private List<SerieDTO> mapToSerieDTO(List<SerieEntity> series) {
        return series.stream()
                .map(serie ->
                        new SerieDTO(
                                serie.getEtiqueta(),
                                serie.getValor(),
                                serie.getCobertura(),
                                serie.getCheckValue(),
                                serie.getPctMedia()
                        ))
                .toList();
    }


}

