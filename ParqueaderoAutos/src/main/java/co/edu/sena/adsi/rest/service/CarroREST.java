/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.service;

import co.edu.sena.adsi.jpa.entities.Carro;
import co.edu.sena.adsi.jpa.sessions.CarroFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author adsi1261718
 */
@Path("carros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroREST {
    @EJB
    private CarroFacade carroEJB;
    
     @GET
    public List<Carro> findAll() {
        return carroEJB.findAll();
    }

    @GET
    @Path("{id}")
    public Carro findBye(
            @PathParam("id") String id) {
        return carroEJB.find(id);
    }

    @POST
    public Response create(Carro carro){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        
        try{
            if (carroEJB.findByPlaca(carro.getPlaca()) == null) {
               // if(parque )
                carroEJB.create(carro);  
                
              return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("El carro se registró correctamente"))
                    .build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST)
                            .entity(gson.toJson("El Número de placa ya éxiste!."))
                            .build();
            }
            
        }catch (Exception e) {
            System.out.println("Err: " + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el carro!."))
                    .build();
        }
        
    }
    
}
