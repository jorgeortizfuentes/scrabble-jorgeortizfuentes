package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleFloatTest {
    private ScrabbleFloat floatScr;
    private double exampleFloat1 = 10.55;
    private String exampleStrFloat1 = "10.55";
    private double exampleFloat2 = 20.111;
    private String exampleStrFloat2 = "20.111";

    @BeforeEach
    void setUp() {
        floatScr = new ScrabbleFloat(exampleFloat1);
    }

    @Test
    void testConstructor(){
        var expected = new ScrabbleFloat(exampleFloat1);
        var noExpected = new ScrabbleFloat(exampleFloat2);

        assertEquals(expected.hashCode(), floatScr.hashCode());
        assertEquals(expected, floatScr);
        assertNotEquals(noExpected, floatScr);

    }

    @Test
    void testGetContent() {
        assertEquals(exampleFloat1, floatScr.getContent());
        assertNotEquals(exampleFloat2, floatScr.getContent());

    }
    @Test
    void testAsFloat() {
        assertEquals(new ScrabbleFloat(exampleFloat1), floatScr.asFloat());
        assertNotEquals(new ScrabbleFloat(exampleFloat2), floatScr.asFloat());

    }

    @Test
    void testAsString() {
        assertEquals(new ScrabbleString(exampleStrFloat1), floatScr.asString());
        assertNotEquals(new ScrabbleString(exampleStrFloat2), floatScr.asString());
    }

    @Test
    void testHashCode() {
        var expected = new ScrabbleFloat(exampleFloat1);
        var noExpected = new ScrabbleFloat(exampleFloat2);

        assertEquals(floatScr.hashCode(), expected.hashCode());
        assertNotEquals(floatScr.hashCode(), noExpected.hashCode());
    }

    @Test
    void testEquals() {
        var expected = new ScrabbleFloat(exampleFloat1);
        var noExpected = new ScrabbleFloat(exampleFloat2);

        assertEquals(expected.hashCode(), floatScr.hashCode());
        assertEquals(expected, floatScr);
        assertNotEquals(noExpected, floatScr);

    }
}