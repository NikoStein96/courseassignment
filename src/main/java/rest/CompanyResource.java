package rest;
import Facade.FacadeCompany;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("company")
public class CompanyResource {
    private static FacadeCompany f = new FacadeCompany(Persistence.createEntityManagerFactory("courseassignment"));
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    public CompanyResource() {
    }
    
    @GET
    @Path("/byphhone/{phnonenr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyInfoByPhone(@PathParam("phnonenr") int phonenr) {
       return Response.ok().entity(gson.toJson(f.getCompanyInformation(phonenr))).build();
    }
    
        @GET
    @Path("/byemployees/{employeesNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompanyByEmpl(@PathParam("employeesNumber") int employeesNumber) {
       return Response.ok().entity(gson.toJson(f.getCompanyByEmployees(employeesNumber))).build();
    }

}
