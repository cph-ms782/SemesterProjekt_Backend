package rest;

import dto.MatchDTO;
import dto.TeamDTO;
import facades.AirportFacade;
import facades.ApiFacade;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
@Path("air")
public class AirportResource {

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);

    AirportFacade facade = AirportFacade.getAirportFacade(emf);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello airport\"}";
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("teams")
//    public List<TeamDTO> getTeams() throws IOException, ProtocolException, ExecutionException, InterruptedException {
//        List<TeamDTO> data = facade.getAllTeams();
//        return data;
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("allteammatchdates/{id}")
//    public List<MatchDTO> getMatchDates(@PathParam("id") int id) throws IOException, ProtocolException, ExecutionException, InterruptedException {
//        List<MatchDTO> data = facade.getAllDataMatches(id, false);
//        return data;
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("allteammatchresults/{id}")
//    public List<MatchDTO> getMatchResults(@PathParam("id") int id) throws IOException, ProtocolException, ExecutionException, InterruptedException {
//        List<MatchDTO> data = facade.getAllDataMatches(id, true);
//        return data;
//    }
}
