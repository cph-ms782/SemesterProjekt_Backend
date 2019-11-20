package facades;

import com.google.gson.JsonArray;
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
import dto.TeamDTO;
import java.util.Collection;
import java.util.Map;

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

    public List<TeamDTO> getAllDataInParallelWithQueueAndDTO() throws ProtocolException, IOException, InterruptedException, ExecutionException {
        List<TeamDTO> results = new ArrayList();
        List<String> URLS = new ArrayList();
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/57");
        URLS.add("http://api.football-data.org/v2/teams/57");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/58");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/61");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/62");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/64");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/65");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/66");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/67");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/68");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/73");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/76");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/328");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/338");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/340");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/346");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/354");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/356");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/397");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/563");
//        URLS.add("http://api.football-data.org/v2/competitions/PL/teams/1044");

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
                    results.add(new TeamDTO(
                            cpo.get().get("name").getAsString(),
                            cpo.get().get("crestUrl").getAsString()));
                    //                    List l = (List) cpo.get().get("teams");
                    //                    System.out.println(l);

                } catch (InterruptedException interruptedException) {
                    System.out.println("interruptedException: " + interruptedException);
                } catch (ExecutionException executionException) {
                    System.out.println("executionException: " + executionException);
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
