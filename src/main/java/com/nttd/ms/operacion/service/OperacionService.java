package com.nttd.ms.operacion.service;

import com.nttd.ms.operacion.entity.Operacion;

import java.util.List;

public interface OperacionService {

    List<Operacion> findAll();

    Operacion findById(Long id);

    void save(Operacion operacion);

}
