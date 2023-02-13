package com.nttd.ms.operacion.service.impl;

import com.nttd.ms.operacion.client.CuentaBancariaClient;
import com.nttd.ms.operacion.client.PagoCreditoClient;
import com.nttd.ms.operacion.entity.Operacion;
import com.nttd.ms.operacion.repository.OperacionRepository;
import com.nttd.ms.operacion.service.OperacionService;
import com.nttd.ms.operacion.util.OperacionUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class OperacionServiceImpl implements OperacionService {

    @Inject
    OperacionRepository operacionRepository;

    @Inject
    OperacionUtil operacionUtil;

    @RestClient
    CuentaBancariaClient cuentaBancaria;

    @RestClient
    PagoCreditoClient pagoCredito;

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
        switch (operacion.getTipoOperacion()) {
            case "1" -> {
                operacionRepository.persist(operacion);
                cuentaBancaria.depositarSaldoCuenta(operacion.getNumeroCuentaCredito(), operacion.getMonto());
            }
            case "2" -> {
                operacionRepository.persist(operacion);
                cuentaBancaria.retirarSaldoCuenta(operacion.getNumeroCuentaCredito(), operacion.getMonto());
            }
            case "3" -> {
                //operacionRepository.persist(operacion);
                System.out.println("transferencia.");
            }
            case "4", "5" -> {
                operacionRepository.persist(operacion);
                pagoCredito.save(operacionUtil.savePagoCredito(operacion));
            }
            default -> System.out.println("El tipo de Operación no es correcta.");
        }

    }
}
