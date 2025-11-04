import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class TmdbService {
    private final TmdbRepository repository;
    private String json;

    public TmdbService(TmdbRepository repository) {
        this.repository=repository;
    }

    public List<Movie> mostrarData(String type){
    String url;
        switch (type){
            case "playing"-> url=repository.getUrlNowPlaying();
            case "popular"->url=repository.getUrlPopular();
            case "top"->url=repository.getUrlTopRated();
            case "upcoming"->url=repository.getUrlUpcoming();
            default -> throw new IllegalArgumentException("El comando ingresado no existe:"+type);
        }

        json=repository.apiMovie(url);
        ObjectMapper mapper=new ObjectMapper();
        MovieResponse listMovie = null;

        try {
            listMovie = mapper.readValue(json,MovieResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return listMovie.getResults();

    }
}
