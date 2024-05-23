package me.will.refactoring1;

public class HtmlStatement extends Statement {
    protected String footerString(Customer customer) {
        return "<p>You owe <em>" +
                customer.getTotalCharge() +
                "</em><p>\n" +
                "On this rental you earned <em>" +
                customer.getTotalFrequentRenterPoints() +
                "</em> frequent renter points<p>";
    }

    protected String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " + each.getCharge() + "<br>\n";
    }

    protected String headerString(Customer customer) {
        return "<h1>Rentals for <em>" + customer.getName() + "</em></h1><p>\n";
    }

}
