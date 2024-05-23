package me.will.refactoring1;

public class TextStatement extends Statement {
    public String value(Customer customer) {
        String result = "Rental Record for " + customer.getName() + "\n";

        for (Rental each : customer.getRentals()) {
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }

        // add footer lines
        result += "Amount owed is " + customer.getTotalCharge() + "\n";
        result += "You earned " + customer.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }
}
