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
    private ScrabbleString strScr2;
    private int seed;

    private int exampleInt1;
    private double exampleFloat1;
    private boolean exampleBoolean1;
    private String exampleBinary1;

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
        strScr2 = new ScrabbleString(exampleString2);
    }

    @Test
    void testConstructor() {
        ScrabbleString expected = new ScrabbleString(exampleString1);
        ScrabbleString noExpected = new ScrabbleString(exampleString2);
        ScrabbleFloat noExpected2 = new ScrabbleFloat(1.5);

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
        ScrabbleString expected = new ScrabbleString(exampleString1);
        ScrabbleString noExpected = new ScrabbleString(exampleString2);

        assertEquals(strScr.hashCode(), expected.hashCode());
        assertNotEquals(strScr.hashCode(), noExpected.hashCode());
    }

    @Test
    void testEquals() {
        ScrabbleString expected = new ScrabbleString(exampleString1);
        ScrabbleString noExpected = new ScrabbleString(exampleString2);

        assertEquals(expected.hashCode(), strScr.hashCode());
        assertEquals(expected, strScr);
        assertNotEquals(noExpected, strScr);

    }

    @Test
    void addWith() {
        strScr = new ScrabbleString(exampleString1);
        strScr2 = new ScrabbleString(exampleString2);
        ScrabbleString expected1 = (ScrabbleString) strScr.addWith(strScr2);
        ScrabbleString solution1 = new ScrabbleString(exampleString1+exampleString2);
        assertEquals(expected1, solution1);


        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        exampleInt1 = rndm.nextInt(8);
        exampleFloat1 = (float) exampleInt1;
        exampleBoolean1 = rndm.nextBoolean();

        int strSize = rndm.nextInt(16);
        exampleBinary1 = RandomStringUtils.random(rndm.nextInt(strSize), "01");


        ScrabbleInt sInt1 = new ScrabbleInt(exampleInt1);
        ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);
        ScrabbleBoolean sBool1 = new ScrabbleBoolean(exampleBoolean1);
        ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);


        ScrabbleString expected2 = (ScrabbleString) strScr.addWith(sInt1);
        ScrabbleString solution2 = new ScrabbleString(exampleString1+exampleInt1);
        assertEquals(expected2, solution2);

        ScrabbleString expected3 = (ScrabbleString) strScr.addWith(sFloat1);
        ScrabbleString solution3 = new ScrabbleString(exampleString1+exampleFloat1);
        assertEquals(expected3, solution3);

        ScrabbleString expected4 = (ScrabbleString) strScr.addWith(sBool1);
        ScrabbleString solution4 = new ScrabbleString(exampleString1+sBool1.toString());
        assertEquals(expected4, solution4);

        ScrabbleString expected5 = (ScrabbleString) strScr.addWith(sBin1);
        ScrabbleString solution5 = new ScrabbleString(exampleString1+exampleBinary1);
        assertEquals(expected5, solution5);

    }

    @Test
    void addedByString() {
        strScr = new ScrabbleString(exampleString1);
        strScr2 = new ScrabbleString(exampleString2);
        ScrabbleString expected1 = (ScrabbleString) strScr.addWith(strScr2);
        ScrabbleString solution1 = new ScrabbleString(exampleString1+exampleString2);
        assertEquals(expected1, solution1);

    }

    @Test
    void addedByInt() {
        ScrabbleInt sInt1 = new ScrabbleInt(exampleInt1);
        var solution = sInt1.addWith(strScr);
        assertNull(solution);

    }

    @Test
    void addedByFloat() {
        exampleFloat1 = (float) exampleInt1;
        ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);
        var solution = sFloat1.addWith(strScr);
        assertNull(solution);

    }

    @Test
    void addedByBinary() {
        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        int strSize = rndm.nextInt(16);
        exampleBinary1 = RandomStringUtils.random(rndm.nextInt(strSize), "01");
        ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);
        var solution = sBin1.addWith(strScr);
        assertNull(solution);

    }

    @Test
    void addedByBool() {
        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        exampleBoolean1 = rndm.nextBoolean();
        ScrabbleBoolean sBool1 = new ScrabbleBoolean(exampleBoolean1);
        var solution = sBool1.addWith(strScr);
        assertNull(solution);

    }
}