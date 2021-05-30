package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class ScrabbleBinaryTest {

    private String exampleBinary1;
    private String exampleBinary2;
    private ScrabbleBinary sBin;

    private int seed;
    private Random rndm;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rndm = new Random(seed);
        int strSize = rndm.nextInt(12);

        String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1)+1), "01");

        do{
            exampleBinary2 = RandomStringUtils.random(rndm.nextInt(16-1)+1, "01");

        } while (exampleBinary1.equals(exampleBinary2));


        sBin = new ScrabbleBinary(exampleBinary1);
    }

    @RepeatedTest(20)
    void testConstructor() {
        var expected = new ScrabbleBinary(exampleBinary1);
        var noExpected = new ScrabbleBinary(exampleBinary2);
        var noExpected2 = new ScrabbleInt(1010);


        assertEquals(expected, sBin);
        assertEquals(expected.hashCode(), sBin.hashCode());

        assertNotEquals(noExpected, sBin);
        assertNotEquals(sBin, noExpected2);


    }

    @RepeatedTest(20)
    void exceptionConstructorTesting() {
        String randomStringNonBinary = RandomStringUtils.random(10);

        AssertionError error = Assertions.assertThrows(AssertionError.class, () -> {
            new ScrabbleBinary(randomStringNonBinary);
        });
        Assertions.assertEquals("The string is not a binary.", error.getMessage());
    }

    @RepeatedTest(20)
    void testToString(){
        assertEquals(exampleBinary1, sBin.toString());
        assertNotEquals(exampleBinary2, sBin.toString());
    }

    @RepeatedTest(20)
    void testAsString(){
        assertEquals(new ScrabbleString(exampleBinary1), sBin.asString());
        assertNotEquals(new ScrabbleString(exampleBinary2), sBin.asString());
    }

    @RepeatedTest(20)
    void testGetContent() {
        assertEquals(exampleBinary1, sBin.getContent());
        assertNotEquals(exampleBinary2, sBin.getContent());

    }

    @RepeatedTest(20)
    void testHashCode() {
        var expected = new ScrabbleBinary(exampleBinary1);
        var noExpected = new ScrabbleBinary(exampleBinary2);

        assertEquals(sBin.hashCode(), expected.hashCode());
        assertNotEquals(sBin.hashCode(), noExpected.hashCode());
    }

    @RepeatedTest(20)
    void testEquals() {
        var expected = new ScrabbleBinary(exampleBinary1);
        var noExpected = new ScrabbleBinary(exampleBinary2);

        assertEquals(expected.hashCode(), sBin.hashCode());
        assertEquals(expected, sBin);
        assertNotEquals(noExpected, sBin);

    }


    @RepeatedTest(20)
    void negation() {
        var sBinNMeg = sBin.negation();
        String negationString = exampleBinary1.replace("0","x").replace("1","0").replace("x","1");
        var expected = new ScrabbleBinary(negationString);
        assertEquals(expected, sBinNMeg);
        assertNotEquals(sBin, sBinNMeg);
    }

    @RepeatedTest(20)
    void conjunctionWith() {

        var exampleBoolean1 = rndm.nextBoolean();
        ScrabbleBoolean sBool = new ScrabbleBoolean(exampleBoolean1);
        var conjunction = sBin.conjunctionWith(sBool);
        ScrabbleBinary expected;
        if (!exampleBoolean1) {
            expected = new ScrabbleBinary(exampleBinary1.replace("1", "0"));
        } else {
            expected = new ScrabbleBinary(exampleBinary1);
        }

        assertEquals(expected, conjunction);
    }

    @RepeatedTest(20)
    void conjunctionByBoolean() {
        var exampleBoolean1 = rndm.nextBoolean();
        ScrabbleBoolean sBool = new ScrabbleBoolean(exampleBoolean1);
        var conjunction = sBool.conjunctionWith(sBin);
        ScrabbleBinary expected;
        if (!exampleBoolean1) {
            expected = new ScrabbleBinary(exampleBinary1.replace("1", "0"));
        } else {
            expected = new ScrabbleBinary(exampleBinary1);
        }
        assertEquals(expected, conjunction);
    }

    @RepeatedTest(20)
    void conjunctionByBinary() {
        var sBin2 = new ScrabbleBinary(exampleBinary2);
        var expected = sBin.conjunctionWith(sBin2);
        assertNull(expected);
    }

    @RepeatedTest(20)
    void disjunctionWith() {
        var exampleBoolean1 = rndm.nextBoolean();
        ScrabbleBoolean sBool = new ScrabbleBoolean(exampleBoolean1);
        var disjunction = sBin.disjunctionWith(sBool);
        ScrabbleBinary expected;

        if (exampleBoolean1) {
            expected = new ScrabbleBinary(exampleBinary1.replace("0", "1"));

        } else {
            expected = new ScrabbleBinary(exampleBinary1);
        }
        System.out.println(expected);
        System.out.println(disjunction);
        assertEquals(expected, disjunction);
    }

    @RepeatedTest(20)
    void disjunctionByBoolean() {
        var exampleBoolean1 = rndm.nextBoolean();
        ScrabbleBoolean sBool = new ScrabbleBoolean(exampleBoolean1);
        var disjunction = sBool.disjunctionWith(sBin);
        ScrabbleBinary expected;

        if (exampleBoolean1) {
            expected = new ScrabbleBinary(exampleBinary1.replace("0", "1"));

        } else {
            expected = new ScrabbleBinary(exampleBinary1);
        }
        System.out.println(expected);
        System.out.println(disjunction);
        assertEquals(expected, disjunction);
    }

    @Test
    void disjunctionByBinary() {
        var sBin2 = new ScrabbleBinary(exampleBinary2);
        var expected = sBin.disjunctionWith(sBin2);
        assertNull(expected);
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

    @Test
    void subtractWith() {
    }

    @Test
    void subtractedByInt() {
    }

    @Test
    void subtractedByFloat() {
    }

    @Test
    void subtractedByBinary() {
    }

    @Test
    void multiplyWith() {
    }

    @Test
    void multipliedByInt() {
    }

    @Test
    void multipliedByFloat() {
    }

    @Test
    void multipliedByBinary() {
    }

    @Test
    void divideWith() {
    }

    @Test
    void dividedByInt() {
    }

    @Test
    void dividedByFloat() {
    }

    @Test
    void dividedByBinary() {
    }
}