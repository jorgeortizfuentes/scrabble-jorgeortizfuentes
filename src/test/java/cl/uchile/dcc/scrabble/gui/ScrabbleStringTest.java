package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ScrabbleStringTest {

    private String exampleString1 = "example1";
    private String exampleString2 = "example2";
    private String exampleString3 = RandomStringUtils.random(10);
    private ScrabbleString strScr;

    @BeforeEach
     void setUp(){
         strScr = new ScrabbleString(exampleString1);
    }

    @Test
    void testConstructor() {
        var expected = new ScrabbleString(exampleString1);
        var noExpected = new ScrabbleString(exampleString2);

        assertEquals(expected, strScr);
        assertEquals(expected.hashCode(), strScr.hashCode());

        assertNotEquals(noExpected, strScr);
    }

    @Test
    void testAsString(){
        assertEquals(new ScrabbleString(exampleString1), strScr.asString());
        assertNotEquals(new ScrabbleString(exampleString2), strScr.asString());
    }

    @Test
    void testGetContent() {
        assertEquals(exampleString1, strScr.getContent());
        assertNotEquals(exampleString2, strScr.getContent());

    }


    @Test
    void testHashCode() {
        var expected = new ScrabbleString(exampleString1);
        var noExpected = new ScrabbleString(exampleString2);

        assertEquals(strScr.hashCode(), expected.hashCode());
        assertNotEquals(strScr.hashCode(), noExpected.hashCode());
    }

    @Test
    void testEquals() {
        var expected = new ScrabbleString(exampleString1);
        var noExpected = new ScrabbleString(exampleString2);

        assertEquals(expected.hashCode(), strScr.hashCode());
        assertEquals(expected, strScr);
        assertNotEquals(noExpected, strScr);

    }
}