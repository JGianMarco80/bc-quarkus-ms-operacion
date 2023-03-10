package com.nttd.ms.operacion.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "operacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operacion {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    private LocalDate fecha = LocalDate.now();

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "monto")
    private Double monto;

    //1:Deposito
    //2:Retiro
    //3:transferencia
    //4:Pago de credito
    //5:Pago de tarjeta de credito
    @Column(name = "tipo_operacion")
    private String tipoOperacion;

    @Column(name = "numero_cuenta_credito")
    private String numeroCuentaCredito;

    @Column(name = "numero_cuotas")
    private Integer numeroCuota;

    @Column(name = "estado")
    private String estado = "1";
}
