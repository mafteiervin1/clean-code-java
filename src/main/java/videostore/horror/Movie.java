package videostore.horror;

public class Movie {

    private String title;
    private MovieCategories priceCode;

    public Movie(String title, MovieCategories priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public MovieCategories getPriceCode() {
        return priceCode;
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