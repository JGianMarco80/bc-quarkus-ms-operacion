package com.nttd.ms.operacion.repository;

import com.nttd.ms.operacion.entity.Operacion;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperacionRepository implements PanacheRepository<Operacion> {
}
