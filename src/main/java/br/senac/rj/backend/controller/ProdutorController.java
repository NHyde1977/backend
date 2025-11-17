package br.senac.rj.backend.controller;

import br.senac.rj.backend.entity.Produtor;
import br.senac.rj.backend.service.ProdutorService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que é um controller REST (recurso JAX-RS) da sua aplicação, responsável por expor endpoints HTTP relacionados à entidade Produtor.
 */
@Path("/produtor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutorController {
    private final ProdutorService service = new ProdutorService();

    @POST
    @Path("/salvar")
    public Response salvar(Produtor a) {
        return service.salvar(a);
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        return service.buscar(id);
    }
}
