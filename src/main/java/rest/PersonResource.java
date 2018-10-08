package rest;

import DTO.PersonDTO;
import Facade.FacadePerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
public class PersonResource {

    private static FacadePerson f = new FacadePerson(Persistence.createEntityManagerFactory("courseassignment"));
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    public PersonResource() {
    }

    @GET
    @Path("/byphhone/{phnonenr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByPhonenr(@PathParam("phnonenr") int phonenr) {
        return Response.ok().entity(gson.toJson(f.getPersonInformation(phonenr))).build();
    }

    @GET
    @Path("/byhobby/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByhobby(@PathParam("hobby") String hobby) {
        return Response.ok().entity(gson.toJson(f.getPersonsByHobby(hobby))).build();
    }

    @GET
    @Path("/bycity/{zip}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByhobby(@PathParam("zip") int zip) {
        return Response.ok().entity(gson.toJson(f.getPersonByCity(zip))).build();
    }

    @GET
    @Path("/hobbysize/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gethobbysize(@PathParam("hobby") String hobby) {
        return Response.ok().entity(gson.toJson(f.getHobbySizeByHobby(hobby))).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPerson(String content) {
        Person p = gson.fromJson(content, Person.class);
        System.out.println("newCustomer: " + p);
        f.createPerson(p);
        return Response.ok().entity(gson.toJson(p)).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("id")int id) {
        PersonDTO pDTO = f.deletePerson(id);
        return Response.ok().entity(gson.toJson(pDTO)).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer( String content, @PathParam("id") int id){
        Person p = gson.fromJson(content, Person.class);
        f.updatePerson(id, p);
        return Response.ok().entity(gson.toJson(p)).build();
    }
}
