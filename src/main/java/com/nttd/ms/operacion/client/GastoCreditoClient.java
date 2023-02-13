package com.nttd.ms.operacion.client;

import com.nttd.ms.operacion.client.dto.GastoCredito;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/gasto-tarjeta-credito")
public interface GastoCreditoClient {

    @POST
    @Transactional
    void save(GastoCredito gastoCredito);

}
