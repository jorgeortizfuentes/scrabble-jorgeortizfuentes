package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ScrabbleStringTest {

    private final String exampleString = "example";
    private ScrabbleString strScr;

    @BeforeEach
     void setUp(){
        ScrabbleString strScr = new ScrabbleString(exampleString);
    }

    @Test
    void testConstructor() {
        var expected = new ScrabbleString(exampleString);
        assertEquals(expected, strScr);
    }
}