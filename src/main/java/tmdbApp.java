import java.util.List;

public class tmdbApp {
    public static void main(String[] args) { args=new String[]{"--type","top"};
        if(args.length==2){
            if(args[0].equals("--type") && !args[1].isEmpty()){
                TmdbRepository repository=new TmdbRepository();
                TmdbService service=new TmdbService(repository);
                List<Movie> movieList=service.mostrarData(args[1]);
                for (Movie movie : movieList) {
                    System.out.println(movie.toString());
                }
            }
        }
    }
}
