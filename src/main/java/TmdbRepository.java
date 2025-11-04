import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class TmdbRepository {

    private final Properties properties;
    private final String token;

    public TmdbRepository() {
        this.properties=new Properties();
        try {
            properties.load(new FileReader("config.properties"));
            this.token=properties.getProperty("TMDB_TOKEN");
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de porpiedades");
        }
        catch (Exception ex){
            throw new RuntimeException("Error al conectar con TMDB: " + ex.getMessage(), ex);
        }
    }

    public String apiMovie(String uri){
        try{
            HttpResponse<String> response;
            HttpClient client=HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .GET()
                    .header("accept","application/json")
                    .header("Authorization","Bearer "+token)
                    .build();
             response=client.send(request,HttpResponse.BodyHandlers.ofString());
            return response.body();
        }catch (Exception ex){
            throw new RuntimeException("No se pudo tener acceso al API de TMDB");
        }
    }

    public String getUrlNowPlaying(){
        return "https://api.themoviedb.org/3/movie/now_playing?language=es-ES&page=1";
    }

    public String getUrlPopular(){
        return "https://api.themoviedb.org/3/movie/popular?language=es-ES&page=1";
    }

    public String getUrlTopRated(){
        return "https://api.themoviedb.org/3/movie/top_rated?language=es-ES&page=1";
    }

    public String getUrlUpcoming(){
        return "https://api.themoviedb.org/3/movie/upcoming?language=es-ES&page=1";
    }
}
