package videostore.horror;

import java.util.*;

import static videostore.horror.Movie.MovieCategories.NEW_RELEASE;

class Customer {
	private String name;
	private List <Rental> rentals = new ArrayList<>();
 	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Movie movie, int rentedDays) {
		rentals.add(new Rental(movie, rentedDays));
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";

		for (Rental rental : rentals) {
			double thisAmount = 0;
			Movie each = rental.getMovie();
			// determine amounts for each line
			int rentedDays = rental.getRentedDays();
			switch (each.getPriceCode()) {
				case REGULAR:
					thisAmount += 2;
					if (rentedDays > 2)
						thisAmount += (rentedDays - 2) * 1.5;
					break;
				case NEW_RELEASE:
					thisAmount += rentedDays * 3;
					break;
				case CHILDREN:
					thisAmount += 1.5;
					if (rentedDays > 3)
						thisAmount += (rentedDays - 3) * 1.5;
					break;
			}
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if (each.getPriceCode() != null &&
				(each.getPriceCode() == NEW_RELEASE)
				&& rentedDays > 1)
				frequentRenterPoints++;
			// show figures line for this rental
			result += "\t" + each.getTitle() + "\t"
				+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}
}