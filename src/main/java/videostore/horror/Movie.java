package videostore.horror;

public class Movie {

    private String title;
    private MovieCategories movieCategory;

    public Movie(String title, MovieCategories movieCategory) {
        this.title = title;
        this.movieCategory = movieCategory;
    }

    public MovieCategories getMovieCategory() {
        return movieCategory;
    }

    public String getTitle() {
        return title;
    }

    enum MovieCategories {
        REGULAR(),
        NEW_RELEASE(),
        CHILDREN()
    }

}