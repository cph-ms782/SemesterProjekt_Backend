package facades;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dto.MatchDTO;
import dto.TeamDTO;

/**
 *
 */
public class ApiFacade {
    
    private static ApiFacade instance;

    //Private Constructor to ensure Singleton
    private ApiFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static ApiFacade getApiFacade() {
        if (instance == null) {
            instance = new ApiFacade();
        }
        return instance;
    }
    
    private String getFootballApi(String urlApi) throws MalformedURLException, IOException {
        URL url = new URL(urlApi);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("X-Auth-Token", "82e97af72ae34501ab126fc871128f61");
        String jsonStr;
        try (Scanner scan = new Scanner(con.getInputStream())) {
            jsonStr = null;
            if (scan.hasNext()) {
                jsonStr = scan.nextLine();
            }
        }
//        System.out.println("JSON " + jsonStr);
        return jsonStr;
    }
    
    public List<MatchDTO> getAllDataMatches(int id) throws IOException, InterruptedException, ExecutionException {
        
        List<String> URLS = new ArrayList();
        
        URLS.add("http://api.football-data.org/v2/teams/" + id + "/matches/");
        
        return getSeasonMatches(URLS);
    }
    
    public List<TeamDTO> getAllTeams() throws IOException, InterruptedException, ExecutionException {
        
        List<String> URLS = new ArrayList();
        URLS.add("http://api.football-data.org/v2/competitions/PL/teams?season=2019");
        
        return getAllTeamsData(URLS);
    }
    
    public List<MatchDTO> getSeasonMatches(List<String> URLS) throws ProtocolException, IOException, InterruptedException, ExecutionException {
        List<MatchDTO> results = new ArrayList();
        
        Queue<Future<JsonObject>> queue = new ArrayBlockingQueue(URLS.size());
        
        ExecutorService workingJack = Executors.newCachedThreadPool();
        for (String url : URLS) {
            Future<JsonObject> future;
            future = workingJack.submit(() -> {
                JsonObject jsonObject = new JsonParser().parse(getFootballApi(url)).getAsJsonObject();
                return jsonObject;
            });
            queue.add(future);
        }
        while (!queue.isEmpty()) {
            Future<JsonObject> cpo = queue.poll();
            if (cpo.isDone()) {
                try {
                    System.out.println("inde i koden");
                    // CHANGE WHEN USING OTHER API
                    // USE OTHER DTO FOR WHAT YOU NEED TO EXTRACT
                    for (JsonElement match : cpo.get().get("matches").getAsJsonArray()) {
                        String status = match.getAsJsonObject().get("status").getAsString();
                        if (status != null && status.equals("SCHEDULED")) {
//                        if (status != null && status.equals("FINISHED")) {
//
//                            JsonObject elHomeTeam = (JsonObject) match.getAsJsonObject().get("homeTeam");
//                            JsonObject elAwayTeam = (JsonObject) match.getAsJsonObject().get("awayTeam");
//                            JsonObject elScore = (JsonObject) match.getAsJsonObject().get("score");
//                            JsonObject elFullTime = (JsonObject) elScore.getAsJsonObject("fullTime");
//                            results.add(new MatchDTO(
//                                    elHomeTeam.get("name").getAsString(),
//                                    elFullTime.get("homeTeam").getAsString(),
//                                    elAwayTeam.get("name").getAsString(),
//                                    elFullTime.get("awayTeam").getAsString(),
//                                    elScore.get("winner").getAsString(),
//                                    match.getAsJsonObject().get("utcDate").getAsString()));

                            JsonObject elHomeTeam = (JsonObject) match.getAsJsonObject().get("homeTeam");
                            JsonObject elAwayTeam = (JsonObject) match.getAsJsonObject().get("awayTeam");
                            results.add(new MatchDTO(
                                    elHomeTeam.get("name").getAsString(),
                                    "",
                                    elAwayTeam.get("name").getAsString(),
                                    "",
                                    "",
                                    match.getAsJsonObject().get("utcDate").getAsString()));
                        }
                    }
                } catch (NullPointerException ex) {
                    System.out.println("NullPointerException: " + ex);
                }
            } else {
                queue.add(cpo);
            }
        }
        workingJack.shutdown();
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        return results;
    }
    
    public List<TeamDTO> getAllTeamsData(List<String> URLS) throws ProtocolException, IOException, InterruptedException, ExecutionException {
        List<TeamDTO> results = new ArrayList();
        
        Queue<Future<JsonObject>> queue = new ArrayBlockingQueue(URLS.size());
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        ExecutorService workingJack = Executors.newCachedThreadPool();
        for (String url : URLS) {
            Future<JsonObject> future;
            future = workingJack.submit(() -> {
                JsonObject jsonObject = new JsonParser().parse(getFootballApi(url)).getAsJsonObject();
                return jsonObject;
            });
            queue.add(future);
        }
        while (!queue.isEmpty()) {
            Future<JsonObject> cpo = queue.poll();
            if (cpo.isDone()) {
                try {
                    System.out.println("inde i koden");
                    // CHANGE WHEN USING OTHER API
                    // USE OTHER DTO FOR WHAT YOU NEED TO EXTRACT
                    for (JsonElement el : cpo.get().get("teams").getAsJsonArray()) {
                        results.add(new TeamDTO(
                                el.getAsJsonObject().get("name").getAsString(),
                                el.getAsJsonObject().get("crestUrl").getAsString()
                        ));
                    }
                } catch (NullPointerException ex) {
                    System.out.println("NullPointerException: " + ex);
                }
            } else {
                queue.add(cpo);
            }
        }
        workingJack.shutdown();
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        return results;
    }
    
}

//
//
//
//
//        while (!queue.isEmpty()) {
//            Future<JsonObject> cpo = queue.poll();
//            if (cpo.isDone()) {
//                try {
//                    // CHANGE WHEN USING OTHER API
//                    // USE OTHER DTO FOR WHAT YOU NEED TO EXTRACT
//                    for (Map.Entry<String, JsonElement> entry : cpo.get().entrySet()) {
//                        TeamDTO td = new TeamDTO();
//                        if (entry.getKey().equals("name")) {
//                            td.setName(entry.getValue().getAsString());
//                        }
//
////                        td.setName(cpo.get().get("name").getAsString());
////                        td.setCrestUrl(cpo.get().get("crestUrl").getAsString());
//                        results.add(td);
//                    }
////                    results.add(new TeamDTO(
////                            cpo.get().get("name").getAsString(),
////                            cpo.get().get("crestUrl").getAsString()
////                    ));
//                } catch (InterruptedException interruptedException) {
//                    System.out.println("interruptedException: " + interruptedException);
//                } catch (ExecutionException executionException) {
//                    System.out.println("executionException: " + executionException);
//                } catch (NullPointerException ex) {
//                    System.out.println("NullPointerException: " + ex);
//                }
//            } else {
//                queue.add(cpo);
//            }
//        }
//        workingJack.shutdown();
//        for (int i = 0; i < results.size(); i++) {
//            System.out.println(results.get(i));
//        }
//        return results;
//    }
//
//}
