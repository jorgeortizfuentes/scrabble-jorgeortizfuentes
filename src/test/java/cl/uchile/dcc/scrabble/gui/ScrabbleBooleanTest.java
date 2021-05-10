package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleBooleanTest {

    private boolean exampleBoolean1 = true;
    private boolean exampleBoolean2 = false;
    private String exampleBooleanStr1 = "true";
    private String exampleBooleanStr2 = "false";
    private ScrabbleBoolean boolScr;

    @BeforeEach
    void setUp() {
        boolScr = new ScrabbleBoolean(exampleBoolean1);
    }

    @Test
    void testConstructor() {
        var expected = new ScrabbleBoolean(exampleBoolean1);
        var noExpected = new ScrabbleBoolean(exampleBoolean2);

        assertEquals(expected, boolScr);
        assertEquals(expected.hashCode(), boolScr.hashCode());

        assertNotEquals(noExpected, boolScr);
    }

    @Test
    void testToString(){
        assertEquals(exampleBooleanStr1, boolScr.toString());
        assertNotEquals(exampleBooleanStr2, boolScr.toString());
    }

    @Test
    void testAsString(){
        assertEquals(new ScrabbleString(exampleBooleanStr1), boolScr.asString());
        assertNotEquals(new ScrabbleString(exampleBooleanStr2), boolScr.asString());
    }

    @Test
    void testGetContent() {
        assertEquals(exampleBoolean1, boolScr.getContent());
        assertNotEquals(exampleBoolean2, boolScr.getContent());

    }

    @Test
    void testAsBool() {
        assertEquals(new ScrabbleBoolean(exampleBoolean1), boolScr.asBool());
        assertNotEquals(new ScrabbleBoolean(exampleBoolean2), boolScr.asBool());

    }

    @Test
    void testHashCode() {
        var expected = new ScrabbleBoolean(exampleBoolean1);
        var noExpected = new ScrabbleBoolean(exampleBoolean2);

        assertEquals(boolScr.hashCode(), expected.hashCode());
        assertNotEquals(boolScr.hashCode(), noExpected.hashCode());
    }

    @Test
    void testEquals() {
        var expected = new ScrabbleBoolean(exampleBoolean1);
        var noExpected = new ScrabbleBoolean(exampleBoolean2);

        assertEquals(expected.hashCode(), boolScr.hashCode());
        assertEquals(expected, boolScr);
        assertNotEquals(noExpected, boolScr);

    }
}