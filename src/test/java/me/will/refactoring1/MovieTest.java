package me.will.refactoring1;

import org.junit.jupiter.api.Test;

import static me.will.refactoring1.Movie.REGULAR;
import static me.will.refactoring1.Movie.CHILDRENS;
import static me.will.refactoring1.Movie.NEW_RELEASE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTest {
    @Test
    public void testStart() {
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

        String statement = bob.statement();
        System.out.println(statement);
        assertNotNull(statement);
        assertTrue(statement.contains("The Matrix\t6.5"));
        assertTrue(statement.contains("Ice Age\t4.5"));
        assertTrue(statement.contains("Oppenheimer\t15.0"));
        assertTrue(statement.contains("Amount owed is 26.0"));
        assertTrue(statement.contains("You earned 4 frequent renter points"));
    }
}
