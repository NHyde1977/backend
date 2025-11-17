package br.senac.rj.backend.service;

import br.senac.rj.backend.dao.ProdutorDao;
import br.senac.rj.backend.entity.Produtor;

import jakarta.ws.rs.core.Response;

/**
 * 
 * @author reinaldo.jose
 * Classe que tem a função de centralizar a lógica de negócio relacionada à entidade Produtor.
 */
public class ProdutorService {
    private final ProdutorDao dao = new ProdutorDao();

    public Response salvar(Produtor produtor) {
        Produtor produtorSalvo = dao.salvar(produtor);
        if (produtorSalvo == null) {
            return Response.status(Response.Status.BAD_REQUEST)
            		.entity("{\"erro\":\"Não foi possível salvar o produtor.\"}")
            		.build();
        }
        return Response.ok(produtorSalvo).build();
    }

    public Response buscar(Long id) {
        Produtor ProdutorObtido = dao.buscarPorId(id);
        if (ProdutorObtido == null) {
            return Response.status(Response.Status.NOT_FOUND)
            		.entity("{\"erro\":\"Produtor não encontrado.\"}")
            		.build();
        }
        return Response.ok(ProdutorObtido).build();
    }
}
