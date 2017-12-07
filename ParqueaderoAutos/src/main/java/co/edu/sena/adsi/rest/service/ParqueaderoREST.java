
package co.edu.sena.adsi.rest.service;

import co.edu.sena.adsi.jpa.entities.Parqueadero;
import co.edu.sena.adsi.jpa.entities.Puestos;
import co.edu.sena.adsi.jpa.sessions.CarroFacade;
import co.edu.sena.adsi.jpa.sessions.ParqueaderoFacade;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author yurani
 */
@Path("parqueadero")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ParqueaderoREST {
    
    @EJB
    private ParqueaderoFacade parqueaderoEJB;
    
   /* @EJB
    private CarroFacade carroEJB;
    */
    @GET
    public List<Parqueadero> findAll() {
        return parqueaderoEJB.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public int findBye(
            @PathParam("id") Integer id) {
        int cont = 0;
        Parqueadero p = parqueaderoEJB.find(id);
        
        for (Puestos pu : p.getPuestosList()) {
            if (pu.getIdCarro() == null) {
                cont+=1;
            }
        }
        return cont;
    }
 
    /*
    @POST
    public Response create(
            @QueryParam("tarifa") double tarifa) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Parqueadero newParqueadero = new Parqueadero();
        parqueaderoEJB.create(newParqueadero);

        try {
            newParqueadero.setValorPagar(pagarValor(tarifa));
            newParqueadero.setCaja(darMontoCaja() + tarifa);
            newParqueadero.setPuestos(newParqueadero.getPuestos() - 1);
            newParqueadero.setAbierto(estaAbierto());
            newParqueadero.setTarifa(tarifaParcial());
            newParqueadero.setHoraActual(darHoraActual());
            if (false) {
                return Response.status(Response.Status.CREATED)
                        .entity(gson.toJson("El parqueo se registró correctamente"))
                        .build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("El Número de placa ya éxiste!."))
                        .build();
            }
        } catch (Exception e) {
            System.out.println("Err: " + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el parqueo!."))
                    .build();
        }
    }
    private int resta = 1;
    private int horaActual;
    private int horaLlegada;
    private boolean abierto;
    private int caja;
    private int tarifa;

    private double pagarValor(double tarifa) {
        tarifa = tarifaParcial() * restaHora();
        return tarifa;
    }

    //Cambiar tarifa
    private double tarifaParcial() {
        return 1200;
    }

    public int restaHora() {
        resta = horaActual - horaLlegada;
        return resta;

    }
    public static final int PARQUEADERO_CERRADO = -2;
    public static final int CARRO_NO_EXISTE = -3;
    public static final int CARRO_YA_EXISTE = -4;
    public static final int HORA_INICIAL = 6;
    public static final int HORA_CIERRE = 20;
    public static final int NOHAYPUESTO = -1;
    public static final int TAMAÑO = 40;

    private PuestoREST puestos[];

    public int ingresarCarro(String placa) {
        if (false) {
            return PARQUEADERO_CERRADO;
        }
        // Buscar un puesto libre para el carro y agregarlo
        int numPuesto = 0;
        if (numPuesto != NOHAYPUESTO) {
            Carro carroEntrando = new Carro();//placa, horaActual
            puestos[numPuesto].parquearCarro(carroEntrando);
        }
        return numPuesto;

    }

    public int calcularPuestos() {
        int puestosLibres = 0;
        for (int i = 0; i < TAMAÑO; i++) {
            if (!puestos[i].puestoOcupado()) {
                puestosLibres = puestosLibres + 1;
            }
        }
        return puestosLibres;
    }

    public boolean estaOcupado(int i) {
        return puestos[i].puestoOcupado();
    }

    private CarroREST carros;

    public int sacarCarro(String placa) {
        if (!abierto) {
            return PARQUEADERO_CERRADO;
        }

        int numPuesto = buscarPuestoCarro(placa.toUpperCase());
        if (numPuesto == CARRO_NO_EXISTE) {
            return CARRO_NO_EXISTE;
        } else {
            Carro carro = puestos[numPuesto].darCarro();
            int nHoras = carros.darTiempoEnParqueadero(horaActual);
            int porPagar = nHoras * tarifa;
            caja = caja + porPagar;
            puestos[numPuesto].sacarCarro();
            return porPagar;
        }
    }

    public boolean estaAbierto() {
        return abierto;
    }

    public int darHoraActual() {
        return horaActual;
    }

    private int buscarPuestoCarro(String placa) {
        int puesto = CARRO_NO_EXISTE;
        for (int i = 0; i < TAMAÑO && puesto == CARRO_NO_EXISTE; i++) {
            if (puestos[i].tieneCarroConPlaca(placa)) {
                puesto = i;
            }
        }
        return puesto;
    }

    public int darMontoCaja() {
        return caja;
    }
    */
    

}
     

