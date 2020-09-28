package videostore.horror;

import static videostore.horror.Movie.MovieCategories.NEW_RELEASE;

public class Rental {
    private final Movie movie;
    private final Integer rentedDays;
    private final int NEW_RELEASE_BONUS_POINTS = 2;
    private final int REGULAR_BONUS_POINTS = 2;

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

    public double computeBonusRenterPoints() {
        double thisAmount = 0;
        switch (getMovie().getMovieCategory()) {
            case REGULAR:
                thisAmount += 2;
                if (getRentedDays() > 2)
                    thisAmount += (getRentedDays() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += getRentedDays() * 3;
                break;
            case CHILDREN:
                thisAmount += 1.5;
                if (getRentedDays() > 3)
                    thisAmount += (getRentedDays() - 3) * 1.5;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getMovie().getMovieCategory());
        }
        return thisAmount;
    }

    public int computeBonusPoints() {
        if (getMovie().getMovieCategory() == NEW_RELEASE && getRentedDays() > 1) {
            return NEW_RELEASE_BONUS_POINTS;
        }
        return REGULAR_BONUS_POINTS;
    }
}
