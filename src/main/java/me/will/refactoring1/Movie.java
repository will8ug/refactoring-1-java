package me.will.refactoring1;

import java.util.Enumeration;
import java.util.Vector;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;

    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public static void main(String[] args) {
        Movie theMatrix = new Movie("The Matrix", REGULAR);
        Movie iceAge = new Movie("Ice Age", CHILDRENS);
        Movie oppenheimer = new Movie("Oppenheimer", NEW_RELEASE);
        Rental rental1 = new Rental(theMatrix, 5);
        Rental rental2 = new Rental(iceAge, 5);
        Rental rental3 = new Rental(oppenheimer, 5);
        Customer bob = new Customer("Bob");
        bob.addRental(rental1);
        bob.addRental(rental2);
        bob.addRental(rental3);
        System.out.println(bob.statement());
    }

}

class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }
}

class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }
    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = rentals.nextElement();

            // determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR -> {
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                }

                case Movie.NEW_RELEASE -> thisAmount += each.getDaysRented() * 3;

                case Movie.CHILDRENS -> {
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                }
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)) {
                frequentRenterPoints++;
            }

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}