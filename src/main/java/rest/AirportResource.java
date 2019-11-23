package rest;

import dto.AirportsDTO;
import dto.TeamAirportDTO;
import facades.AirportFacade;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 */
@Path("air")
public class AirportResource {

    AirportFacade facade = AirportFacade.getAirportFacade();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello airport\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("airports")
    public AirportsDTO getAllAirports() throws IOException, ProtocolException, ExecutionException, InterruptedException {
        List<String> data = facade.getAllAirports();
        return new AirportsDTO(data);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("nearestairport/{team}")
    public String getNearestAirport(@PathParam("team") String team) throws IOException, ProtocolException, ExecutionException, InterruptedException {
        String data = facade.getNearestAirportFromTeam(team);
        return "{\"airport\":\""+ data +"\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("nearestteam/{airport}")
    public TeamAirportDTO getNearestTeam(@PathParam("airport") String airport) throws IOException, ProtocolException, ExecutionException, InterruptedException {
        List<String> data = facade.getNearestTeamfromAirport(airport);
        return new TeamAirportDTO(data);
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
//    @Path("allteammatchresults/{id}")
//    public List<MatchDTO> getMatchResults(@PathParam("id") int id) throws IOException, ProtocolException, ExecutionException, InterruptedException {
//        List<MatchDTO> data = facade.getAllDataMatches(id, true);
//        return data;
//    }
}
