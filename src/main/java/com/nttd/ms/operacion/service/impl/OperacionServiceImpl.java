package com.nttd.ms.operacion.service.impl;

import com.nttd.ms.operacion.entity.Operacion;
import com.nttd.ms.operacion.repository.OperacionRepository;
import com.nttd.ms.operacion.service.OperacionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OperacionServiceImpl implements OperacionService {

    @Inject
    OperacionRepository operacionRepository;

    @Override
    public List<Operacion> findAll() {
        List<Operacion> operaciones = operacionRepository.listAll();
        List<Operacion> operacionesActivas = new ArrayList<>();

        for (Operacion operacion : operaciones) {
            if(operacion.getEstado().equals("1")){
                operacionesActivas.add(operacion);
            }
        }

        return operacionesActivas;
    }

    @Override
    public Operacion findById(Long id) {
        return operacionRepository.findById(id);
    }

    @Override
    public void save(Operacion operacion) {
        operacionRepository.persist(operacion);
    }

    /*@Override
    public void update(Long id, Operacion operacion) {

    }

    @Override
    public void delete(Long id) {
        Operacion oObtenido = operacionRepository.findById(id);
        oObtenido.setEstado("0");
        operacionRepository.persist(oObtenido);
    }*/
}
