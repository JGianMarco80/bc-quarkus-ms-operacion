package com.nttd.ms.operacion.util;

import com.nttd.ms.operacion.client.dto.GastoCredito;
import com.nttd.ms.operacion.client.dto.PagoCredito;
import com.nttd.ms.operacion.entity.Operacion;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OperacionUtil {

    public PagoCredito savePagoCredito(Operacion operacion) {
        PagoCredito pagoCredito = new PagoCredito();
        if(operacion.getTipoOperacion().equals("4")){
            pagoCredito.setTipoPago("1");
        }

        if (operacion.getTipoOperacion().equals("5")){
            pagoCredito.setTipoPago("2");
        }

        pagoCredito.setNumeroCredito(operacion.getNumeroCuentaCredito());
        pagoCredito.setCantidadCuotas(1);
        pagoCredito.setMonto(operacion.getMonto());
        pagoCredito.setFecha(operacion.getFecha());
        return pagoCredito;
    }

    public GastoCredito saveGastoTarjetaCredito(Operacion operacion) {
        GastoCredito gastoCredito = new GastoCredito();
        gastoCredito.setNumeroCredito(operacion.getNumeroCuentaCredito());
        gastoCredito.setCuotasAPagar(operacion.getNumeroCuota());
        gastoCredito.setCuotasPagadas(0);
        gastoCredito.setMontoGastado(operacion.getMonto());
        gastoCredito.setMontoAPagar(operacion.getMonto());
        gastoCredito.setFecha(operacion.getFecha());
        return gastoCredito;
    }

}
