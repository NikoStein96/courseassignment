package Exceptions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Context
    ServletContext context;

    @Override
    public Response toResponse(PersonNotFoundException e) {
        Boolean isDebug = context.getInitParameter("debug").equals("true");
        ExceptionDTO err = new ExceptionDTO(e, 404, isDebug);
        err.setDescription("You tried to call...");
        
        return Response.status(404)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON).
                build();
    }
    
}
