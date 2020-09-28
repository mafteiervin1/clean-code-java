package videostore.horror;

import static videostore.horror.Movie.MovieCategories.NEW_RELEASE;

public class Rental {
    private final Movie movie;
    private final Integer rentedDays;
    private final int NEW_RELEASE_BONUS_POINTS = 2;
    private final int REGULAR_BONUS_POINTS = 1;

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
        switch (getMovie().getMovieCategory()) {
            case REGULAR: return computeRegularRenterBonusPoints();
            case NEW_RELEASE: return computeNewReleaseRenterBonusPoints();
            case CHILDREN: return computeChildrenRenterBonusPoints();
            default:
                throw new IllegalStateException("Unexpected value: " + getMovie().getMovieCategory());
        }
    }

    private double computeChildrenRenterBonusPoints() {
        double bonusPoints = 1.5;
        return getRentedDays() <= 2
            ? bonusPoints
            : bonusPoints + (getRentedDays() - 3) * 1.5;
    }

    private double computeNewReleaseRenterBonusPoints() {
        return getRentedDays() * 3;
    }

    private double computeRegularRenterBonusPoints() {
        double bonusPoints = 2;
        return getRentedDays() <= 1
            ? bonusPoints
            : bonusPoints + (getRentedDays() - 2) * 1.5;
    }

    public int computeBonusPoints() {
        if (getMovie().getMovieCategory() == NEW_RELEASE && getRentedDays() > 1) {
            return NEW_RELEASE_BONUS_POINTS;
        }
        return REGULAR_BONUS_POINTS;
    }
}
