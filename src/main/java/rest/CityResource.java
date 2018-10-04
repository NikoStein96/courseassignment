package rest;

import Facade.FacadeCity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("city")
public class CityResource {
    private static FacadeCity f = new FacadeCity(Persistence.createEntityManagerFactory("CourseAssignment"));
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    public CityResource() {
    }
        @GET
    @Path("/danishzips")
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAllDanishZips() {
       return Response.ok().entity(gson.toJson(f.danishZipcodes())).build();
    }


}
