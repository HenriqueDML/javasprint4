package org.example.Resource;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Service.ServiceVeiculo;

import org.example.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

@Path("chatcarveiculo")


public class ResourceVeiculo {
    ServiceVeiculo foi = new ServiceVeiculo();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastraveiculo")
    //cadastro veiculo para o front
    public Response cadastrouVeiculo (Veiculo veiculo){
        try{
            Veiculo veiculo2 = foi.cadastroVeiculo(veiculo);
            return Response.ok(veiculo2).build();
        } catch(Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    @Path("alteraveiculo")
    public Response alterouVeiculo (Veiculo veiculo){
        try {
            Veiculo veiculo2 = foi.alteradoVeiculo(veiculo);
            return Response.ok(veiculo2).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();}
    }

    @GET
    @Path("buscaveiculo/{idveiculo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarVeiculoPorId(@PathParam("idveiculo") int idVeiculo) {
        try {
            Veiculo veiculo = foi.buscarVeiculoPorId(idVeiculo);
            if (veiculo != null) {
                return Response.ok(veiculo).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("lendoveiculo/{idcliente}")
    public Response leoVeiculo (@PathParam("idcliente")int id_cliente){
        try{
            List<Veiculo> listao = new ArrayList<>();
            listao = foi.lendoVeiculo(id_cliente);
            return Response.ok(listao).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
    @DELETE
    @Path("deleteveiculo/{placa}")
    public Response removeuPlaca(@PathParam("placa") String placa) {
        try {
            if (foi.removoVeiculo(placa)) {
                return Response.ok().build(); // Retorna 200 OK se o veículo foi removido
            } else {
                return Response.status(Response.Status.NOT_FOUND).build(); // Retorna 404 se não encontrou
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build(); // Retorna 500 em caso de erro
        }
    }
}
