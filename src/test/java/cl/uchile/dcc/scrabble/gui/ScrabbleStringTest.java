package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class ScrabbleStringTest {

    private String exampleString1;
    private String exampleString2;
    private ScrabbleString strScr;

    private int seed;
    private Random rndm;



    @BeforeEach
     void setUp(){
        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        int strSize = rndm.nextInt(12);

        exampleString1 = RandomStringUtils.random(rndm.nextInt(20), 0, Character.MAX_CODE_POINT, true,
                true, null, rndm);

        do{
            exampleString2 = RandomStringUtils.random(rndm.nextInt(20), 0, Character.MAX_CODE_POINT, true,
                    true, null, rndm);
        } while (exampleString1.equals(exampleString2));

        strScr = new ScrabbleString(exampleString1);
    }

    @Test
    void testConstructor() {
        var expected = new ScrabbleString(exampleString1);
        var noExpected = new ScrabbleString(exampleString2);
        var noExpected2 = new ScrabbleFloat(1.5);

        assertEquals(expected, strScr);
        assertEquals(expected.hashCode(), strScr.hashCode());

        assertNotEquals(noExpected, strScr);

        assertNotEquals(strScr, noExpected2);
    }

    @Test
    void ToString(){
        assertEquals(exampleString1, strScr.toString());
        assertNotEquals(exampleString2, strScr.toString());
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