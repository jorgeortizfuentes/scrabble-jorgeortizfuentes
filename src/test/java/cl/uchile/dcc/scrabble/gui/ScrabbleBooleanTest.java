package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ScrabbleBooleanTest {

    private boolean exampleBoolean1;
    private boolean exampleBoolean2;
    private ScrabbleBoolean boolScr;
    private int seed;
    private Random rndm;

    @BeforeEach
    void setUp() {
        int seed = new Random().nextInt();
        rndm = new Random(seed);
        exampleBoolean1 = rndm.nextBoolean();
        do{
            exampleBoolean2 = rndm.nextBoolean();
        } while (exampleBoolean1 == exampleBoolean2);

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
        String exampleBooleanStr1 = Boolean.toString(exampleBoolean1);
        String exampleBooleanStr2 = Boolean.toString(exampleBoolean2);
        assertEquals(exampleBooleanStr1, boolScr.toString());
        assertNotEquals(exampleBooleanStr2, boolScr.toString());
    }

    @Test
    void testAsString(){
        String exampleBooleanStr1 = Boolean.toString(exampleBoolean1);
        String exampleBooleanStr2 = Boolean.toString(exampleBoolean2);
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

    @RepeatedTest(20)
    void negation() {
        var boolScrNeg = boolScr.negation();
        var expected = new ScrabbleBoolean(!exampleBoolean1);
        assertEquals(boolScrNeg, expected);
        assertNotEquals(boolScr, boolScrNeg);

    }

    @RepeatedTest(20)
    void conjunctionWith() {
        var boolScr2 = new ScrabbleBoolean(exampleBoolean2);
        var conjunction = boolScr.conjunctionWith(boolScr2);
        var expected = new ScrabbleBoolean(exampleBoolean1 && exampleBoolean2);
        var noExpected = new ScrabbleBoolean(!(exampleBoolean1 && exampleBoolean2));

        assertEquals(expected, conjunction);
        assertNotEquals(noExpected, conjunction);
    }

    @RepeatedTest(20)
    void conjunctionByBoolean() {
        var boolScr2 = new ScrabbleBoolean(exampleBoolean2);
        var conjunction = boolScr.conjunctionWith(boolScr2);
        var expected = new ScrabbleBoolean(exampleBoolean1 && exampleBoolean2);
        var noExpected = new ScrabbleBoolean(!(exampleBoolean1 && exampleBoolean2));

        assertEquals(expected, conjunction);
        assertNotEquals(noExpected, conjunction);
    }

    @RepeatedTest(20)
    void conjunctionByBinary() {
        String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1)+1), "01");

        ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);
        var conjunction = sBin1.conjunctionWith(boolScr);
        ScrabbleBinary expected;
        if (!exampleBoolean1) {
            expected = new ScrabbleBinary(exampleBinary1.replace("1", "0"));
        } else {
            expected = new ScrabbleBinary(exampleBinary1);
            }

        assertEquals(expected, conjunction);
    }

    @RepeatedTest(20)
    void disjunctionWith() {
        var boolScr2 = new ScrabbleBoolean(exampleBoolean2);
        var conjunction = boolScr.disjunctionWith(boolScr2);
        var expected = new ScrabbleBoolean(exampleBoolean1 || exampleBoolean2);
        var noExpected = new ScrabbleBoolean(!(exampleBoolean1 || exampleBoolean2));

        assertEquals(expected, conjunction);
        assertNotEquals(noExpected, conjunction);
    }

    @Test
    void disjunctionByBoolean() {
        var boolScr2 = new ScrabbleBoolean(exampleBoolean2);
        var conjunction = boolScr.disjunctionWith(boolScr2);
        var expected = new ScrabbleBoolean(exampleBoolean1 || exampleBoolean2);
        var noExpected = new ScrabbleBoolean(!(exampleBoolean1 || exampleBoolean2));

        assertEquals(expected, conjunction);
        assertNotEquals(noExpected, conjunction);
    }

    @RepeatedTest(20)
    void disjunctionByBinary() {
        String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1)+1), "01");
        ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);
        var disjunction = sBin1.disjunctionWith(boolScr);
        ScrabbleBinary expected;

        if (exampleBoolean1) {
            expected = new ScrabbleBinary(exampleBinary1.replace("0", "1"));

        } else {
            expected = new ScrabbleBinary(exampleBinary1);
        }

        assertEquals(expected, disjunction);
    }

    @RepeatedTest(20)
    void addWith() {
        var expected = boolScr.addWith(boolScr);
        assertNull(expected);

    }

    @RepeatedTest(20)
    void addedByString() {
        int strSize = Math.abs(rndm.nextInt(12));
        var exampleString1 = RandomStringUtils.random(strSize, 0, Character.MAX_CODE_POINT, true,
                true, null, rndm);

        ScrabbleBoolean sInt1 = new ScrabbleBoolean(exampleBoolean1);
        ScrabbleString strScrabble = new ScrabbleString(exampleString1);
        ScrabbleString expected2 = (ScrabbleString) strScrabble.addWith(sInt1);
        ScrabbleString solution2 = new ScrabbleString(exampleString1+exampleBoolean1);
        assertEquals(expected2, solution2);
    }

    @RepeatedTest(20)
    void addedByInt() {
        var exampleInt1 = rndm.nextInt();
        var sInt = new ScrabbleInt(exampleInt1);

        var expected = sInt.addWith(boolScr);
        assertNull(expected);


    }

    @RepeatedTest(20)
    void addedByFloat() {
        var exampleFloat1 = rndm.nextDouble();
        var sFloat = new ScrabbleFloat(exampleFloat1);

        var expected = sFloat.addWith(boolScr);
        assertNull(expected);
    }

    @RepeatedTest(20)
    void addedByBinary() {
        String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1)+1), "01");

        var sBin = new ScrabbleBinary(exampleBinary1);

        var expected = sBin.addWith(boolScr);
        assertNull(expected);
    }

    @RepeatedTest(20)
    void addedByBool() {
        var expected = boolScr.addWith(boolScr);
        assertNull(expected);


    }
}