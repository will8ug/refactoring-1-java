package me.will.refactoring1;

public class HtmlStatement extends Statement {
    public String value(Customer customer) {
        String result = "<h1>Rentals for <em>" + customer.getName() + "</em></h1><p>\n";

        for (Rental each : customer.getRentals()) {
            // show figures for this rental
            result += each.getMovie().getTitle() + ": " + each.getCharge() + "<br>\n";
        }

        // add footer lines
        result += "<p>You owe <em>" + customer.getTotalCharge() + "</em><p>\n";
        result += "On this rental you earned <em>" + customer.getTotalFrequentRenterPoints() + "</em> frequent renter points<p>";
        return result;
    }
}
