package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleFloatTest {
    private ScrabbleFloat floatScr;
    private double exampleFloat1;
    private String exampleStrFloat1;
    private double exampleFloat2;
    private String exampleStrFloat2;
    private String exampleBinary1;
    private String exampleBinary2;
    private String exampleString1;
    private String exampleString2;
    private int exampleInt1;
    private int exampleInt2;
    private boolean exampleBoolean1;
    private boolean exampleBoolean2;

    private int seed;
    private Random rndm;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        exampleFloat1 = rndm.nextDouble();

        do{
            exampleFloat2 = rndm.nextDouble();
        } while (exampleFloat1 == exampleFloat2);

        exampleStrFloat1 = Double.toString(exampleFloat1);
        exampleStrFloat2 = Double.toString(exampleFloat2);


        exampleInt1 = rndm.nextInt(8);
        do{
            exampleInt2 = rndm.nextInt(8);
        } while (exampleInt1 == exampleInt2);


        exampleBoolean1 = rndm.nextBoolean();
        do{
            exampleBoolean2 = rndm.nextBoolean();
        } while (exampleBoolean1 == exampleBoolean2);


        exampleBinary1 = RandomStringUtils.random(rndm.nextInt(16), "01");
        do{
            exampleBinary2 = RandomStringUtils.random(rndm.nextInt(16), "01");

        } while (exampleBinary1.equals(exampleBinary2));

        int strSize = rndm.nextInt(12);

        exampleString1 = RandomStringUtils.random(rndm.nextInt(20), 0, Character.MAX_CODE_POINT, true,
                true, null, rndm);

        do{
            exampleString2 = RandomStringUtils.random(rndm.nextInt(20), 0, Character.MAX_CODE_POINT, true,
                    true, null, rndm);
        } while (exampleString1.equals(exampleString2));


        floatScr = new ScrabbleFloat(exampleFloat1);



    }

    @Test
    void testConstructor(){
        var expected = new ScrabbleFloat(exampleFloat1);
        var noExpected = new ScrabbleFloat(exampleFloat2);
        var noExpected2 = new ScrabbleInt(20);

        assertEquals(expected.hashCode(), floatScr.hashCode());
        assertEquals(expected, floatScr);

        assertNotEquals(noExpected, floatScr);
        assertNotEquals(floatScr, noExpected2);

    }

    @Test
    void testToString() {
        assertEquals(exampleStrFloat1, floatScr.toString());
        assertNotEquals(exampleStrFloat2, floatScr.toString());

    }

    @Test
    void testGetContent() {
        assertEquals(exampleFloat1, floatScr.getContent());
        assertNotEquals(exampleFloat2, floatScr.getContent());

    }
    @Test
    void testAsFloat() {
        assertEquals(new ScrabbleFloat(exampleFloat1), floatScr.asFloat());
        assertNotEquals(new ScrabbleFloat(exampleFloat2), floatScr.asFloat());

    }

    @Test
    void testAsString() {
        assertEquals(new ScrabbleString(exampleStrFloat1), floatScr.asString());
        assertNotEquals(new ScrabbleString(exampleStrFloat2), floatScr.asString());
    }

    @Test
    void testHashCode() {
        var expected = new ScrabbleFloat(exampleFloat1);
        var noExpected = new ScrabbleFloat(exampleFloat2);

        assertEquals(floatScr.hashCode(), expected.hashCode());
        assertNotEquals(floatScr.hashCode(), noExpected.hashCode());
    }

    @Test
    void testEquals() {
        var expected = new ScrabbleFloat(exampleFloat1);
        var noExpected = new ScrabbleFloat(exampleFloat2);

        assertEquals(expected.hashCode(), floatScr.hashCode());
        assertEquals(expected, floatScr);
        assertNotEquals(noExpected, floatScr);

    }

    @Test
    void addWith() {
        var intScr1 = new ScrabbleFloat(exampleInt1);
        var intScr2 = new ScrabbleFloat(exampleInt2);
        ScrabbleFloat expected1 = (ScrabbleFloat) intScr1.addWith(intScr2);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleInt1+exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void addedByString() {
        ScrabbleFloat sInt1 = new ScrabbleFloat(exampleInt1);
        ScrabbleString strScrabble = new ScrabbleString(exampleString1);
        ScrabbleString expected2 = (ScrabbleString) strScrabble.addWith(sInt1);
        ScrabbleString solution2 = new ScrabbleString(exampleString1+exampleInt1);
        assertEquals(expected2, solution2);
    }

    @Test
    void addedByInt() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var floatScr1 = new ScrabbleFloat(exampleFloat1);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.addWith(floatScr1);
        ScrabbleInt solution1 = new ScrabbleInt((int) (exampleInt1+exampleFloat1));
        assertEquals(expected1, solution1);
    }

    @Test
    void addedByFloat() {
        var intFloat1 = new ScrabbleFloat(exampleFloat1);
        var intFloat2 = new ScrabbleFloat(exampleFloat2);
        ScrabbleFloat expected1 = (ScrabbleFloat) intFloat1.addWith(intFloat2);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleFloat1+exampleFloat2);
        assertEquals(expected1, solution1);
    }

    @Test
    void addedByBinary() {
        var floatScr1 = new ScrabbleFloat(exampleFloat1);
        var binScr1 = new ScrabbleBinary(exampleBinary1);
        var solution = binScr1.addWith(floatScr1);
        assertNull(solution);
    }

    @Test
    void addedByBool() {
        ScrabbleBoolean sBool1 = new ScrabbleBoolean(exampleBoolean1);
        var solution = sBool1.addWith(floatScr);
        assertNull(solution);
    }

    @Test
    void subtractWith() {
        var intScr1 = new ScrabbleFloat(exampleInt1);
        var intScr2 = new ScrabbleFloat(exampleInt2);
        ScrabbleFloat expected1 = (ScrabbleFloat) intScr1.subtractWith(intScr2);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleInt1-exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void subtractedByInt() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var floatScr1 = new ScrabbleFloat(exampleFloat1);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.subtractWith(floatScr1);
        ScrabbleInt solution1 = new ScrabbleInt((int) (exampleInt1-exampleFloat1));
        assertEquals(expected1, solution1);
    }

    @Test
    void subtractedByFloat() {
        var intFloat1 = new ScrabbleFloat(exampleFloat1);
        var intFloat2 = new ScrabbleFloat(exampleFloat2);
        ScrabbleFloat expected1 = (ScrabbleFloat) intFloat1.subtractWith(intFloat2);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleFloat1-exampleFloat2);
        assertEquals(expected1, solution1);
    }

    @Test
    void subtractedByBinary() {
        var floatScr1 = new ScrabbleFloat(exampleFloat1);
        var binScr1 = new ScrabbleBinary(exampleBinary1);
        var solution = binScr1.subtractWith(floatScr1);
        assertNull(solution);
    }

    @Test
    void multiplyWith() {
        var intScr1 = new ScrabbleFloat(exampleInt1);
        var intScr2 = new ScrabbleFloat(exampleInt2);
        ScrabbleFloat expected1 = (ScrabbleFloat) intScr1.multiplyWith(intScr2);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleInt1*exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void multipliedByInt() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var floatScr1 = new ScrabbleFloat(exampleFloat1);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.multiplyWith(floatScr1);
        ScrabbleInt solution1 = new ScrabbleInt((int) (exampleInt1*exampleFloat1));
        assertEquals(expected1, solution1);
    }

    @Test
    void multipliedByFloat() {
        var intFloat1 = new ScrabbleFloat(exampleFloat1);
        var intFloat2 = new ScrabbleFloat(exampleFloat2);
        ScrabbleFloat expected1 = (ScrabbleFloat) intFloat1.multiplyWith(intFloat2);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleFloat1*exampleFloat2);
        assertEquals(expected1, solution1);
    }

    @Test
    void multipliedByBinary() {
        var floatScr1 = new ScrabbleFloat(exampleFloat1);
        var binScr1 = new ScrabbleBinary(exampleBinary1);
        var solution = binScr1.multiplyWith(floatScr1);
        assertNull(solution);
    }

}