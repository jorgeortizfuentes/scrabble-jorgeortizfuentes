package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ScrabbleBinaryTest {

    private String exampleString1 = "10101011100";
    private String exampleString2 = "11110111";
    private ScrabbleBinary strScr;
    private String randomString1 = RandomStringUtils.random(10);

    @BeforeEach
    void setUp(){
        strScr = new ScrabbleBinary(exampleString1);
    }

    @Test
    void testConstructor() {
        var expected = new ScrabbleBinary(exampleString1);
        var noExpected = new ScrabbleBinary(exampleString2);

        assertEquals(expected, strScr);
        assertEquals(expected.hashCode(), strScr.hashCode());

        assertNotEquals(noExpected, strScr);

        }

    @Test
    void exceptionConstructorTesting() {

        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            new ScrabbleBinary(randomString1);
        });
        Assertions.assertEquals("The string is not a binary.", error.getMessage());
    }


    @Test
    void testToString(){
        assertEquals(exampleString1, strScr.toString());
        assertNotEquals(exampleString2, strScr.toString());
    }

    @Test
    void getContent() {
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

    @Test
    void test(){
        assertEquals(exampleString1, strScr.toString());
        assertNotEquals(exampleString2, strScr.toString());
    }

}