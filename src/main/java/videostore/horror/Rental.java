package videostore.horror;

public class Rental {
    private final Movie movie;
    private final Integer rentedDays;

    public Rental(Movie movie, Integer rentedDays) {
        this.movie = movie;
        this.rentedDays = rentedDays;
    }

    public Integer getRentedDays() {
        return rentedDays;
    }

    public Movie getMovie() {
        return movie;
    }
}
