import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    private static final int OVERVIEW_MAX_LENGTH = 40;

    private int id;
    private String title;
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("vote_average")
    private double voteAverage;

    public Movie() {
    }

    public Movie(int id, String title, String overview, String releaseDate, double voteAverage) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    @Override
    public String toString() {
        return "id:" + id +
                ", title='" + title + '\'' +
                ", release_date=" + releaseDate +
                ", vote_average=" + voteAverage +
                ", overview='" + subtringOverview();
    }

    private String subtringOverview(){
        if (overview==null || overview.isEmpty()){
            return "N/A";
        }
        if (overview.length()>OVERVIEW_MAX_LENGTH){
            return overview.substring(0,OVERVIEW_MAX_LENGTH)+"...";
        }
        return overview;
    }
}
