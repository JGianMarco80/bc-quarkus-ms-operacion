package com.nttd.ms.operacion.client;

import com.nttd.ms.operacion.client.dto.PagoCredito;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient
@Path("/pago-credito")
public interface PagoCreditoClient {

    @POST
    @Transactional
    void save(PagoCredito pagoCredito);

}
