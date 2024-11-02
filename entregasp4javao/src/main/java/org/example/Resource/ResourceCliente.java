package org.example.Resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Service.ServiceCliente;
import org.example.model.Cliente;

@Path("chatcarcliente")

public class ResourceCliente {
    ServiceCliente funfa = new ServiceCliente();
    @POST
    @Path("cadastrocliente")
    //cadastro cliente para o front
    public Response cadastrouCliente (Cliente cliente){
        try{
            Cliente cliente2 = funfa.cadastroCliente(cliente);
            return Response.ok(cliente2).build();
        } catch(Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("logincliente")
    //login e verifica o front
    public Response logouCliente (Cliente cliente){
        try{
            Cliente cliente2 = funfa.loginCliente(cliente);
            return Response.ok(cliente2).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    @Path("alteracliente")
    public Response alterouCliente (Cliente cliente){
        try {
            Cliente cliente2 = funfa.alteradoCliente(cliente);
            return Response.ok(cliente2).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage()).build();}
    }

    @GET
    @Path("lendocliente/{email}")
    public Response leoCliente (@PathParam("email")String email){
        try{
            Cliente cliente = funfa.lendoCliente(email);
            return Response.ok(cliente).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("autenticliente")
    public Response autentiCliente (Cliente cliente){
        try {
            Cliente cliente2 = funfa.autenticadoCliente(cliente);
            return Response.ok(cliente).build();
        }catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }

    }

    @DELETE
    @Path("deletecliente/{email}")
    public Response removeuCliente (@PathParam("email")String email){
        try{
            if(funfa.removoCliente(email)==1){
                return Response.ok().build();
            }else{
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }
        catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(e.getMessage()).build();
        }
    }
}
