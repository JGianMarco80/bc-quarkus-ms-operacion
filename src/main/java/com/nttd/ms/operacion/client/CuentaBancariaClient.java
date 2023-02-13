package com.nttd.ms.operacion.client;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/cuenta-bancaria")
public interface CuentaBancariaClient {

    /*@GET
    @Path("/consultar-saldo")
    CuentaBancaria consultaCuentaBancaria(@QueryParam("numeroCuenta") String numeroCuenta);*/

    @PUT
    @Path("/depositar-saldo")
    @Transactional
    void depositarSaldoCuenta(@QueryParam("numeroCuenta") String numeroCuenta,
                              @QueryParam("saldo") Double saldo);

    @PUT
    @Path("/retirar-saldo")
    @Transactional
    void retirarSaldoCuenta(@QueryParam("numeroCuenta") String numeroCuenta,
                            @QueryParam("saldo") Double saldo);
}
