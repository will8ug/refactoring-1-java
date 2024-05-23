package me.will.refactoring1;

public class TextStatement extends Statement {
    protected String footerString(Customer customer) {
        return "Amount owed is " +
                customer.getTotalCharge() +
                "\n" +
                "You earned " +
                customer.getTotalFrequentRenterPoints() +
                " frequent renter points";
    }

    protected String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
    }

    protected String headerString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
