package me.will.refactoring1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static me.will.refactoring1.Movie.REGULAR;
import static me.will.refactoring1.Movie.CHILDRENS;
import static me.will.refactoring1.Movie.NEW_RELEASE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTest {
    private final Movie theMatrix = new Movie("The Matrix", REGULAR);
    private final Movie iceAge = new Movie("Ice Age", CHILDRENS);
    private final Movie oppenheimer = new Movie("Oppenheimer", NEW_RELEASE);

    private Customer bob;

    @BeforeEach
    public void beforeEach() {
        bob = new Customer("Bob");
    }
    
    @Test
    public void testStatement_3Rentals_1Day() {
        Rental rental1 = new Rental(theMatrix, 1);
        Rental rental2 = new Rental(iceAge, 1);
        Rental rental3 = new Rental(oppenheimer, 1);
        bob.addRental(rental1);
        bob.addRental(rental2);
        bob.addRental(rental3);

        String statement = bob.statement();
        assertNotNull(statement);
        System.out.println(statement);

        assertTrue(statement.contains("Rental Record for Bob"));
        assertTrue(statement.contains("The Matrix\t2.0"));
        assertTrue(statement.contains("Ice Age\t1.5"));
        assertTrue(statement.contains("Oppenheimer\t3.0"));
        assertTrue(statement.contains("Amount owed is 6.5"));
        assertTrue(statement.contains("You earned 3 frequent renter points"));
    }

    @Test
    public void testStatement_3Rentals_5Day() {
        Rental rental1 = new Rental(theMatrix, 5);
        Rental rental2 = new Rental(iceAge, 5);
        Rental rental3 = new Rental(oppenheimer, 5);
        bob.addRental(rental1);
        bob.addRental(rental2);
        bob.addRental(rental3);

        String statement = bob.statement();
        assertNotNull(statement);
        System.out.println(statement);

        assertTrue(statement.contains("The Matrix\t6.5"));
        assertTrue(statement.contains("Ice Age\t4.5"));
        assertTrue(statement.contains("Oppenheimer\t15.0"));
        assertTrue(statement.contains("Amount owed is 26.0"));
        assertTrue(statement.contains("You earned 4 frequent renter points"));
    }

    @Test
    public void testStatement_OneRegularRental_2Days() {
        Rental rental = new Rental(theMatrix, 2);
        bob.addRental(rental);

        String statement = bob.statement();
        assertTrue(statement.contains("The Matrix\t2.0"));
        assertTrue(statement.contains("Amount owed is 2.0"));
        assertTrue(statement.contains("You earned 1 frequent renter points"));
    }

    @Test
    public void testStatement_OneRegularRental_3Days() {
        Rental rental = new Rental(theMatrix, 3);
        bob.addRental(rental);

        String statement = bob.statement();
        assertTrue(statement.contains("The Matrix\t3.5"));
        assertTrue(statement.contains("Amount owed is 3.5"));
        assertTrue(statement.contains("You earned 1 frequent renter points"));
    }

    @Test
    public void testStatement_OneChildrenRental_3Days() {
        Rental rental = new Rental(iceAge, 3);
        bob.addRental(rental);

        String statement = bob.statement();
        assertTrue(statement.contains("Ice Age\t1.5"));
        assertTrue(statement.contains("Amount owed is 1.5"));
        assertTrue(statement.contains("You earned 1 frequent renter points"));
    }

    @Test
    public void testStatement_OneChildrenRental_4Days() {
        Rental rental = new Rental(iceAge, 4);
        bob.addRental(rental);

        String statement = bob.statement();
        assertTrue(statement.contains("Ice Age\t3.0"));
        assertTrue(statement.contains("Amount owed is 3.0"));
        assertTrue(statement.contains("You earned 1 frequent renter points"));
    }

    @Test
    public void testStatement_OneNewReleaseRental_1Day() {
        Rental rental = new Rental(oppenheimer, 1);
        bob.addRental(rental);

        String statement = bob.statement();
        assertTrue(statement.contains("Oppenheimer\t3.0"));
        assertTrue(statement.contains("Amount owed is 3.0"));
        assertTrue(statement.contains("You earned 1 frequent renter points"));
    }

    @Test
    public void testStatement_OneNewReleaseRental_2Day() {
        Rental rental = new Rental(oppenheimer, 2);
        bob.addRental(rental);

        String statement = bob.statement();
        assertTrue(statement.contains("Oppenheimer\t6.0"));
        assertTrue(statement.contains("Amount owed is 6.0"));
        assertTrue(statement.contains("You earned 2 frequent renter points"));
    }
}
