package com.meteorologia.aparicio.app.repository;

import com.meteorologia.aparicio.app.model.dto.EstacionMapaDTO;
import com.meteorologia.aparicio.app.model.entity.EstacionDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstacionRepository extends JpaRepository<EstacionDetalleEntity, String> {

    Optional<EstacionDetalleEntity> findByPuntoControl(String id);
    List<EstacionDetalleEntity> findAllByProcedencia(String procedencia);

}