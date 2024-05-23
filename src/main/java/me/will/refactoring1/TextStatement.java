package me.will.refactoring1;

public class TextStatement extends Statement {
    public String value(Customer customer) {
        String result = headerString(customer);

        for (Rental each : customer.getRentals()) {
            result += eachRentalString(each);
        }

        result += footerString(customer);
        return result;
    }

    private String footerString(Customer customer) {
        return "Amount owed is " +
                customer.getTotalCharge() +
                "\n" +
                "You earned " +
                customer.getTotalFrequentRenterPoints() +
                " frequent renter points";
    }

    private String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
    }

    private String headerString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
