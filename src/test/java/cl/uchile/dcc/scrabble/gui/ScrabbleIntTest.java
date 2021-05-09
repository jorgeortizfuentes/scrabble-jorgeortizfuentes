package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleIntTest {
    private ScrabbleInt intScr;
    private int exampleInt1 = 10;
    private String exampleStrInt1 = "10";
    private int exampleInt2 = 20;

    @BeforeEach
    void setUp() {
        intScr = new ScrabbleInt(exampleInt1);
    }


    @Test
    void testConstructor(){
        var expected = new ScrabbleInt(exampleInt1);
        var noExpected = new ScrabbleInt(exampleInt2);

        assertEquals(expected, intScr);
        assertEquals(expected.hashCode(), intScr.hashCode());
        assertNotEquals(noExpected, intScr);
    }

    @Test
    void testToString() {
        assertEquals(exampleStrInt1, intScr.toString());
    }

    @Test
    void getContent() {
        assertEquals(exampleInt1, intScr.getContent());
        assertNotEquals(exampleInt2, intScr.getContent());

    }

    @Test
    void testHashCode() {
        var expected = new ScrabbleInt(exampleInt1);
        var noExpected = new ScrabbleInt(exampleInt2);

        assertEquals(intScr.hashCode(), expected.hashCode());
        assertNotEquals(intScr.hashCode(), noExpected.hashCode());
    }

    @Test
    void testEquals() {
        var expected = new ScrabbleInt(exampleInt1);
        var noExpected = new ScrabbleInt(exampleInt2);

        assertEquals(expected.hashCode(), intScr.hashCode());
        assertEquals(expected, intScr);
        assertNotEquals(noExpected, intScr);

    }
}