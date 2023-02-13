package com.nttd.ms.operacion.client.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PagoCredito {

    private Long id;

    private String tipoPago;

    private String numeroCredito;

    private Integer cantidadCuotas;

    private Double monto;

    private LocalDate fecha;

}
