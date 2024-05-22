package me.will.refactoring1;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;

    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR -> _price = new RegularPrice();
            case CHILDRENS -> _price = new ChildrensPrice();
            case NEW_RELEASE -> _price = new NewReleasePrice();
            default -> throw new IllegalArgumentException("Incorrect price code");
        }
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }

}

