package com.nttd.ms.operacion.client.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class GastoCredito {

    private Long id;

    private String numeroCredito;

    private Integer cuotasAPagar;

    private Integer cuotasPagadas;

    private Double montoGastado;

    private Double montoAPagar;

    private LocalDate fecha;

}
