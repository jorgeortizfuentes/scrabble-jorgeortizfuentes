package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class ScrabbleBinaryTest {

    private String exampleString1;
    private String exampleString2;
    private ScrabbleBinary strScr;
    private String randomStringNonBinary;

    private int seed;
    private Random rndm;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        int strSize = rndm.nextInt(12);

        exampleString1 = RandomStringUtils.random(rndm.nextInt(20), "01");

        do{
            exampleString2 = RandomStringUtils.random(rndm.nextInt(20), "01");

        } while (exampleString1.equals(exampleString2));

        randomStringNonBinary = RandomStringUtils.random(10);

        strScr = new ScrabbleBinary(exampleString1);
    }

    @Test
    void testConstructor() {
        var expected = new ScrabbleBinary(exampleString1);
        var noExpected = new ScrabbleBinary(exampleString2);
        var noExpected2 = new ScrabbleInt(1010);


        assertEquals(expected, strScr);
        assertEquals(expected.hashCode(), strScr.hashCode());

        assertNotEquals(noExpected, strScr);
        assertNotEquals(strScr, noExpected2);


    }

    @Test
    void exceptionConstructorTesting() {

        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            new ScrabbleBinary(randomStringNonBinary);
        });
        Assertions.assertEquals("The string is not a binary.", error.getMessage());
    }

    @Test
    void testToString(){
        assertEquals(exampleString1, strScr.toString());
        assertNotEquals(exampleString2, strScr.toString());
    }

    @Test
    void testAsString(){
        assertEquals(new ScrabbleString(exampleString1), strScr.asString());
        assertNotEquals(new ScrabbleString(exampleString2), strScr.asString());
    }

    @Test
    void TestGetContent() {
        assertEquals(exampleString1, strScr.getContent());
        assertNotEquals(exampleString2, strScr.getContent());

    }

    @Test
    void testHashCode() {
        var expected = new ScrabbleBinary(exampleString1);
        var noExpected = new ScrabbleBinary(exampleString2);

        assertEquals(strScr.hashCode(), expected.hashCode());
        assertNotEquals(strScr.hashCode(), noExpected.hashCode());
    }

    @Test
    void testEquals() {
        var expected = new ScrabbleBinary(exampleString1);
        var noExpected = new ScrabbleBinary(exampleString2);

        assertEquals(expected.hashCode(), strScr.hashCode());
        assertEquals(expected, strScr);
        assertNotEquals(noExpected, strScr);

    }


}