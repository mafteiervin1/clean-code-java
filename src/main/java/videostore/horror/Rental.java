package videostore.horror;

import java.util.Objects;

import static videostore.horror.Movie.MovieCategories.NEW_RELEASE;

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

    public int computeNewReleaseBonusPoints() {
        int bonusPoints = 1;
        if (!Objects.isNull(getMovie().getMovieCategory()) &&
            (getMovie().getMovieCategory() == NEW_RELEASE)
            && getRentedDays() > 1) {
            return bonusPoints + 1;
        }
        return bonusPoints;
    }
}
