package rest;

import Facade.FacadePerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
public class PersonResource {
    private static FacadePerson f = new FacadePerson(Persistence.createEntityManagerFactory("CourseAssignment"));
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
    @Path("/byhobby/{hobby}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gethobbysize(@PathParam("hobby") String hobby) {
        return Response.ok().entity(gson.toJson(f.getHobbySizeByHobby(hobby))).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
