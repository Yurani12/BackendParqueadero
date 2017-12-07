/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.service;

import co.edu.sena.adsi.jpa.entities.Puestos;
import co.edu.sena.adsi.jpa.sessions.PuestosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */
@Path("puestos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PuestoREST {
    
    @EJB
    private PuestosFacade puestoEJB;
    
    @GET
    public List<Puestos> findAll() {
        return puestoEJB.findAll();
    }

    @GET
    @Path("{id}")
    public Puestos findBye(
            @PathParam("id") String id) {
        return puestoEJB.find(id);
    }
    
    @GET
    @Path("contarPuestos")
    @Produces(MediaType.TEXT_PLAIN)
    public Long consultarPuestosDisponibles(){
        return puestoEJB.contarPuestosDisponibles();
    }
}
