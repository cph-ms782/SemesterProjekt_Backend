package rest;

import dto.CitiesDTO;
import dto.TeamDTO;
import facades.ApiFacade;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * @author lam@cphbusiness.dk
 */
@Path("fb")
public class FootballResource {

    ApiFacade facade = ApiFacade.getApiFacade();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello football\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("data")
    // @RolesAllowed({"user", "admin"})
    public List<TeamDTO> getDataDTO() throws IOException, ProtocolException, ExecutionException, InterruptedException {
        List<TeamDTO> data = facade.getAllDataTeams();
        return data;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("teams")
    public List<TeamDTO> getTeams() throws IOException, ProtocolException, ExecutionException, InterruptedException {
        List<TeamDTO> data = facade.getAllTeams();
        return data;
    }

}
