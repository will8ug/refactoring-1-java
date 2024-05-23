package me.will.refactoring1;

public class HtmlStatement extends Statement {
    public String value(Customer customer) {
        String result = headerString(customer);

        for (Rental each : customer.getRentals()) {
            result += eachRentalString(each);
        }

        result += footerString(customer);
        return result;
    }

    private String footerString(Customer customer) {
        return "<p>You owe <em>" +
                customer.getTotalCharge() +
                "</em><p>\n" +
                "On this rental you earned <em>" +
                customer.getTotalFrequentRenterPoints() +
                "</em> frequent renter points<p>";
    }

    private String eachRentalString(Rental each) {
        return each.getMovie().getTitle() + ": " + each.getCharge() + "<br>\n";
    }

    private String headerString(Customer customer) {
        return "<h1>Rentals for <em>" + customer.getName() + "</em></h1><p>\n";
    }

}
