package com.nttd.ms.operacion.resource;

import com.nttd.ms.operacion.entity.Operacion;
import com.nttd.ms.operacion.service.OperacionService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/operacion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperacionResource {

    @Inject
    OperacionService operacionService;

    @GET
    public List<Operacion> findAll() {
        return operacionService.findAll();
    }

    @GET
    @Path("/{id}")
    public Operacion findAll(@PathParam("id") Long id) {
        return operacionService.findById(id);
    }

    @POST
    @Transactional
    public void save(Operacion operacion){
        operacionService.save(operacion);
    }
}
