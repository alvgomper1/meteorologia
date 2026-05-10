package com.meteorologia.aparicio.app.controller;

import com.meteorologia.aparicio.app.model.dto.EstacionDetalleDTO;
import com.meteorologia.aparicio.app.model.dto.EstacionMapaDTO;
import com.meteorologia.aparicio.app.service.EstacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class EstacionController {

    private final EstacionService service;

    public EstacionController(EstacionService service) {
        this.service = service;
    }

    /**
     *  Todas las estaciones para el mapa (carga inicial)
     */
    @GetMapping("/estaciones")
    public List<EstacionMapaDTO> getMapa() {
        return service.getAllEstaciones();
    }

    /**
     *  Todas las estaciones para el mapa (carga inicial)
     */
    @GetMapping("/estaciones/{procedencia}")
    public List<EstacionMapaDTO> getMapaPorProcedencia(@PathVariable String procedencia) {
        return service.getAllEstacionesByProcedencia(procedencia);
    }

    /**
     *  Datos completos de una estación (modal)
     */
    @GetMapping("/estacion/{id}")
    public EstacionDetalleDTO getEstacion(@PathVariable String id) {
        return service.getEstacionDetalleById(id);
    }
}
