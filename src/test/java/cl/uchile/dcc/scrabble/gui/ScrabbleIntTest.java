package cl.uchile.dcc.scrabble.gui;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleIntTest {
    private ScrabbleInt intScr;
    private int exampleInt1;
    private int exampleInt2;
    private String exampleStrInt1;
    private String exampleStrInt2;
    private double exampleFloat1;
    private double exampleFloat2;
    private boolean exampleBoolean1;
    private boolean exampleBoolean2;
    private String exampleBinary1;
    private String exampleBinary2;
    private String exampleString1;
    private String exampleString2;
    private int seed;
    private Random rndm;



    @BeforeEach
    void setUp() {
        seed = new Random().nextInt();
        Random rndm = new Random(seed);
        exampleInt1 = rndm.nextInt(8);

        do{
            exampleInt2 = rndm.nextInt(8);
        } while (exampleInt1 == exampleInt2);


        exampleStrInt1 = Integer.toString(exampleInt1);
        exampleStrInt2 = Integer.toString(exampleInt2);

        exampleFloat1 = rndm.nextDouble();
        do{
            exampleFloat2 = rndm.nextDouble();
        } while (exampleFloat1 == exampleFloat2);

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

        intScr = new ScrabbleInt(exampleInt1);
    }

    @Test
    void testConstructor(){
        var expected = new ScrabbleInt(exampleInt1);
        var noExpected = new ScrabbleInt(exampleInt2);

        assertEquals(expected, intScr);
        assertEquals(expected.hashCode(), intScr.hashCode());

        assertNotEquals(noExpected, intScr);
        assertNotEquals(intScr, intScr.asFloat());
    }

    @Test
    void testToString() {
        assertEquals(exampleStrInt1, intScr.toString());
        assertNotEquals(exampleStrInt2, intScr.toString());

    }

    @Test
    void testAsString() {
        assertEquals(new ScrabbleString(exampleStrInt1), intScr.asString());
        assertNotEquals(new ScrabbleString(exampleStrInt2), intScr.asString());

    }

    @Test
    void testAsFloat(){
        assertEquals(new ScrabbleFloat(exampleFloat1), intScr.asFloat());
        assertNotEquals(new ScrabbleFloat(exampleFloat2), intScr.asFloat());
    }

    @Test
    void testAsInt(){
        assertEquals(new ScrabbleInt(exampleInt1), intScr.asInt());
        assertNotEquals(new ScrabbleInt(exampleInt2), intScr.asInt());
    }


    @Test
    void getContent() {
        assertEquals(exampleInt1, intScr.getContent());
        assertNotEquals(exampleInt2, intScr.getContent());

    }

    @Test
    void testHashCode() {
        var expected = new ScrabbleInt(exampleInt1);
        var noExpected = new ScrabbleInt(exampleInt2);

        assertEquals(intScr.hashCode(), expected.hashCode());
        assertNotEquals(intScr.hashCode(), noExpected.hashCode());
    }

    @Test
    void testEquals() {
        var expected = new ScrabbleInt(exampleInt1);
        var noExpected = new ScrabbleInt(exampleInt2);

        assertEquals(expected.hashCode(), intScr.hashCode());
        assertEquals(expected, intScr);
        assertNotEquals(noExpected, intScr);

    }

    @Test
    void asBinary() {
        ScrabbleBinary BinScr1 = new ScrabbleBinary(BinUtilities.intToBinary(exampleInt1));
        ScrabbleBinary BinScr2 = new ScrabbleBinary(BinUtilities.intToBinary(exampleInt2));
        assertEquals(BinScr1, intScr.asBinary());
        assertNotEquals(BinScr2, intScr.asBinary());
    }

    @Test
    void addWith() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intScr2 = new ScrabbleInt(exampleInt2);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.addWith(intScr2);
        ScrabbleInt solution1 = new ScrabbleInt(exampleInt1+exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void addedByString() {
        ScrabbleInt sInt1 = new ScrabbleInt(exampleInt1);
        ScrabbleString strScrabble = new ScrabbleString(exampleString1);
        ScrabbleString expected2 = (ScrabbleString) strScrabble.addWith(sInt1);
        ScrabbleString solution2 = new ScrabbleString(exampleString1+exampleInt1);
        assertEquals(expected2, solution2);
    }

    @Test
    void addedByInt() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intScr2 = new ScrabbleInt(exampleInt2);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.addWith(intScr2);
        ScrabbleInt solution1 = new ScrabbleInt(exampleInt1+exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void addedByFloat() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intFloat1 = new ScrabbleFloat(exampleFloat1);
        ScrabbleFloat expected1 = (ScrabbleFloat) intFloat1.addWith(intScr1);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleInt1+exampleFloat1);
        assertEquals(expected1, solution1);
    }

    @Test
    void addedByBinary() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var binScr1 = new ScrabbleBinary(exampleBinary1);
        ScrabbleBinary expected1 = (ScrabbleBinary) binScr1.addWith(intScr1);
        int sum = binScr1.asInt().getContent()+exampleInt1;
        ScrabbleBinary solution1 = new ScrabbleBinary(BinUtilities.intToBinary(sum));
        assertEquals(expected1, solution1);
    }

    @Test
    void addedByBool() {
        ScrabbleBoolean sBool1 = new ScrabbleBoolean(exampleBoolean1);
        var solution = sBool1.addWith(intScr);
        assertNull(solution);
    }

    @Test
    void subtractWith() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intScr2 = new ScrabbleInt(exampleInt2);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.subtractWith(intScr2);
        ScrabbleInt solution1 = new ScrabbleInt(exampleInt1-exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void subtractedByInt() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intScr2 = new ScrabbleInt(exampleInt2);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.subtractWith(intScr2);
        ScrabbleInt solution1 = new ScrabbleInt(exampleInt1-exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void subtractedByFloat() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intFloat1 = new ScrabbleFloat(exampleFloat1);
        ScrabbleFloat expected1 = (ScrabbleFloat) intFloat1.subtractWith(intScr1);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleInt1-exampleFloat1);
        assertEquals(expected1, solution1);
    }

    @Test
    void subtractedByBinary() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var binScr1 = new ScrabbleBinary(exampleBinary1);
        ScrabbleBinary expected1 = (ScrabbleBinary) binScr1.subtractWith(intScr1);
        int sum = binScr1.asInt().getContent()-exampleInt1;
        System.out.println(sum);
        ScrabbleBinary solution1 = new ScrabbleBinary(BinUtilities.intToBinary(sum));
        assertEquals(expected1, solution1);
    }

    @Test
    void multiplyWith() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intScr2 = new ScrabbleInt(exampleInt2);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.multipliedByInt(intScr2);
        ScrabbleInt solution1 = new ScrabbleInt(exampleInt1*exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void multipliedByInt() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intScr2 = new ScrabbleInt(exampleInt2);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.multipliedByInt(intScr2);
        ScrabbleInt solution1 = new ScrabbleInt(exampleInt1*exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void multipliedByFloat() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intFloat1 = new ScrabbleFloat(exampleFloat1);
        ScrabbleFloat expected1 = (ScrabbleFloat) intFloat1.multiplyWith(intScr1);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleInt1*exampleFloat1);
        assertEquals(expected1, solution1);
    }

    @Test
    void multipliedByBinary() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var binScr1 = new ScrabbleBinary(exampleBinary1);
        ScrabbleBinary expected1 = (ScrabbleBinary) binScr1.multiplyWith(intScr1);
        int sum = binScr1.asInt().getContent()*exampleInt1;
        ScrabbleBinary solution1 = new ScrabbleBinary(BinUtilities.intToBinary(sum));
        assertEquals(expected1, solution1);
    }

    @Test
    void divideWith() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intScr2 = new ScrabbleInt(exampleInt2);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.dividedByInt(intScr2);
        ScrabbleInt solution1 = new ScrabbleInt(exampleInt1/exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void dividedByInt() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intScr2 = new ScrabbleInt(exampleInt2);
        ScrabbleInt expected1 = (ScrabbleInt) intScr1.dividedByInt(intScr2);
        ScrabbleInt solution1 = new ScrabbleInt(exampleInt1/exampleInt2);
        assertEquals(expected1, solution1);
    }

    @Test
    void dividedByFloat() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var intFloat1 = new ScrabbleFloat(exampleFloat1);
        ScrabbleFloat expected1 = (ScrabbleFloat) intFloat1.dividedByInt(intScr1);
        ScrabbleFloat solution1 = new ScrabbleFloat(exampleInt1/exampleFloat1);
        assertEquals(expected1, solution1);
    }

    @Test
    void dividedByBinary() {
        var intScr1 = new ScrabbleInt(exampleInt1);
        var binScr1 = new ScrabbleBinary(exampleBinary1);
        ScrabbleBinary expected1 = (ScrabbleBinary) binScr1.multiplyWith(intScr1);
        int sum = binScr1.asInt().getContent()/exampleInt1;
        ScrabbleBinary solution1 = new ScrabbleBinary(BinUtilities.intToBinary(sum));
        assertEquals(expected1, solution1);
    }
}