package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ScrabbleBooleanTest {

    private boolean exampleBoolean1;
    private boolean exampleBoolean2;
    private String exampleBooleanStr1;
    private String exampleBooleanStr2;
    private ScrabbleBoolean boolScr;

    private int seed;
    private Random rndm;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        exampleBoolean1 = rndm.nextBoolean();
        do{
            exampleBoolean2 = rndm.nextBoolean();
        } while (exampleBoolean1 == exampleBoolean2);

        exampleBooleanStr1 = Boolean.toString(exampleBoolean1);
        exampleBooleanStr2 = Boolean.toString(exampleBoolean2);

        boolScr = new ScrabbleBoolean(exampleBoolean1);
    }

    @Test
    void testConstructor() {
        var expected = new ScrabbleBoolean(exampleBoolean1);
        var noExpected = new ScrabbleBoolean(exampleBoolean2);

        assertEquals(expected, boolScr);
        assertEquals(expected.hashCode(), boolScr.hashCode());

        assertNotEquals(noExpected, boolScr);
        assertNotEquals(boolScr, noExpected.asString());

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

    @Test
    void negation() {
    }

    @Test
    void conjunctionWith() {
    }

    @Test
    void conjunctionByBoolean() {
    }

    @Test
    void conjunctionByBinary() {
    }

    @Test
    void disjunctionWith() {
    }

    @Test
    void disjunctionByBoolean() {
    }

    @Test
    void disjunctionByBinary() {
    }

    @Test
    void addWith() {
    }

    @Test
    void addedByString() {
    }

    @Test
    void addedByInt() {
    }

    @Test
    void addedByFloat() {
    }

    @Test
    void addedByBinary() {
    }

    @Test
    void addedByBool() {
    }
}