package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class ScrabbleStringTest {

    private String exampleString1;
    private String exampleString2;
    private ScrabbleString strScr;
    private ScrabbleString strScr2;
    private int seed;
    private Random rndm;


    @BeforeEach
     void setUp(){
        int seed = new Random().nextInt();
        rndm = new Random(seed);

        exampleString1 = RandomStringUtils.random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
                true, null, rndm);

        do{
            exampleString2 = RandomStringUtils.random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
                    true, null, rndm);
        } while (exampleString1.equals(exampleString2));

        strScr = new ScrabbleString(exampleString1);
        strScr2 = new ScrabbleString(exampleString2);
    }

    @RepeatedTest(20)
    void testConstructor() {
        ScrabbleString expected = new ScrabbleString(exampleString1);
        ScrabbleString noExpected = new ScrabbleString(exampleString2);

        assertEquals(expected, strScr);
        assertEquals(expected.hashCode(), strScr.hashCode(), "Hashes don't match");

        assertNotEquals(noExpected, strScr, "The content has the same value.");
    }

    @RepeatedTest(20)
    void ToString(){
        assertEquals(exampleString1, strScr.toString());
        assertNotEquals(exampleString2, strScr.toString());
    }

    @RepeatedTest(20)
    void testAsString(){
        assertEquals(new ScrabbleString(exampleString1), strScr.asString());
        assertNotEquals(new ScrabbleString(exampleString2), strScr.asString());
    }

    @RepeatedTest(20)
    void testGetContent() {
        assertEquals(exampleString1, strScr.getContent());
        assertNotEquals(exampleString2, strScr.getContent());

    }

    @RepeatedTest(20)
    void testHashCode() {
        ScrabbleString expected = new ScrabbleString(exampleString1);
        ScrabbleString noExpected = new ScrabbleString(exampleString2);

        assertEquals(strScr.hashCode(), expected.hashCode());
        assertNotEquals(strScr.hashCode(), noExpected.hashCode());
    }

    @RepeatedTest(20)
    void testEquals() {
        ScrabbleString expected = new ScrabbleString(exampleString1);
        ScrabbleString noExpected = new ScrabbleString(exampleString2);

        assertEquals(expected.hashCode(), strScr.hashCode());
        assertEquals(expected, strScr);
        assertNotEquals(noExpected, strScr);

    }

    @RepeatedTest(20)
    void addWith() {
        strScr2 = new ScrabbleString(exampleString2);
        ScrabbleString expected1 = (ScrabbleString) strScr.addWith(strScr2);
        ScrabbleString solution1 = new ScrabbleString(exampleString1+exampleString2);
        assertEquals(expected1, solution1);


        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        var exampleInt1 = rndm.nextInt(8);
        var exampleFloat1 = (float) exampleInt1;
        var exampleBoolean1 = rndm.nextBoolean();

        int strSize = Math.abs(rndm.nextInt(16));
        var exampleBinary1 = RandomStringUtils.random(strSize, "01");


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

    @RepeatedTest(20)
    void addedByString() {
        strScr = new ScrabbleString(exampleString1);
        strScr2 = new ScrabbleString(exampleString2);
        ScrabbleString expected1 = (ScrabbleString) strScr.addWith(strScr2);
        ScrabbleString solution1 = new ScrabbleString(exampleString1+exampleString2);
        assertEquals(expected1, solution1);

    }

    @RepeatedTest(20)
    void addedByInt() {
        var exampleInt1 = rndm.nextInt();
        var sInt = new ScrabbleInt(exampleInt1);
        var solution = sInt.addWith(strScr);
        assertNull(solution);

    }

    @RepeatedTest(20)
    void addedByFloat() {
        var exampleFloat1 = rndm.nextDouble();
        var sFloat = new ScrabbleFloat(exampleFloat1);
        var solution = sFloat.addWith(strScr);
        assertNull(solution);

    }

    @RepeatedTest(20)
    void addedByBinary() {
        String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1)+1), "01");
        var sBin = new ScrabbleBinary(exampleBinary1);
        var solution = sBin.addWith(strScr);
        assertNull(solution);

    }

    @RepeatedTest(20)
    void addedByBool() {
        var exampleBoolean1 = rndm.nextBoolean();
        ScrabbleBoolean sBool = new ScrabbleBoolean(exampleBoolean1);
        var solution = sBool.addWith(strScr);
        assertNull(solution);

    }
}