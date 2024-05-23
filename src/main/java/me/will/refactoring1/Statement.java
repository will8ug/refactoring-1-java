package me.will.refactoring1;

public abstract class Statement {
    public String value(Customer customer) {
        String result = headerString(customer);

        for (Rental each : customer.getRentals()) {
            result += eachRentalString(each);
        }

        result += footerString(customer);
        return result;
    }

    protected abstract String headerString(Customer customer);

    protected abstract String eachRentalString(Rental each);

    protected abstract String footerString(Customer customer);
}
