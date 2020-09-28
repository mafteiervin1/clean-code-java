package videostore.horror;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List <Rental> rentals = new ArrayList <>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String buildStatement() {
        StringBuilder result = buildStatementHeader();

        result.append(buildStatementBody());

        result.append(buildStatementFooter(computeTotalRentalPoints(), computeBonusRenterPoints()));

        return result.toString();
    }

    private StringBuilder buildStatementFooter(double totalRentalPoints, int frequentRenterPoints) {
        StringBuilder result = new StringBuilder();

        result.append("Amount owed is ").append(totalRentalPoints).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return result;
    }

    private StringBuilder buildStatementHeader() {
        return new StringBuilder("Rental Record for " + getName() + "\n");
    }

    private StringBuilder buildStatementBody() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append("\t").append(rental.getMovie().getTitle()).append("\t")
                  .append(rental.computeBonusRenterPoints()).append("\n");
        }
        return result;
    }

    private int computeBonusRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.computeBonusPoints();
        }
        return frequentRenterPoints;
    }

    private double computeTotalRentalPoints() {
        double totalRentalPoints = 0;
        for (Rental rental : rentals) {
            totalRentalPoints += rental.computeBonusRenterPoints();
        }
        return totalRentalPoints;
    }
}