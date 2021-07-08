package cl.uchile.dcc.scrabble.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ScrabbleFloatTest {

  private ScrabbleFloat sFloat;
  private double exampleFloat1;
  private double exampleFloat2;

  private int seed;
  private Random rndm;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    Random rndm = new Random(seed);
    exampleFloat1 = rndm.nextDouble();

    do {
      exampleFloat2 = rndm.nextDouble();
    } while (exampleFloat1 == exampleFloat2);

    sFloat = new ScrabbleFloat(exampleFloat1);
  }

  @RepeatedTest(20)
  void testConstructor() {
    var expected = new ScrabbleFloat(exampleFloat1);
    var noExpected = new ScrabbleFloat(exampleFloat2);
    var noExpected2 = new ScrabbleInt(20);

    assertEquals(expected.hashCode(), sFloat.hashCode());
    assertEquals(expected, sFloat);

    assertNotEquals(noExpected, sFloat);
    assertNotEquals(sFloat, noExpected2);
  }

  @RepeatedTest(20)
  void testToString() {
    String exampleStrFloat1 = Double.toString(exampleFloat1);
    String exampleStrFloat2 = Double.toString(exampleFloat2);
    assertEquals(exampleStrFloat1, sFloat.toString());
    assertNotEquals(exampleStrFloat2, sFloat.toString());
  }

  @RepeatedTest(20)
  void testGetContent() {
    assertEquals(exampleFloat1, sFloat.getContent());
    assertNotEquals(exampleFloat2, sFloat.getContent());
  }

  @RepeatedTest(20)
  void testAsFloat() {
    assertEquals(new ScrabbleFloat(exampleFloat1), sFloat.asFloat());
    assertNotEquals(new ScrabbleFloat(exampleFloat2), sFloat.asFloat());
  }

  @RepeatedTest(20)
  void testAsString() {
    String exampleStrFloat1 = Double.toString(exampleFloat1);
    String exampleStrFloat2 = Double.toString(exampleFloat2);
    Assertions.assertEquals(new ScrabbleString(exampleStrFloat1), sFloat.asString());
    assertNotEquals(new ScrabbleString(exampleStrFloat2), sFloat.asString());
  }

  @RepeatedTest(20)
  void testHashCode() {
    var expected = new ScrabbleFloat(exampleFloat1);
    var noExpected = new ScrabbleFloat(exampleFloat2);

    assertEquals(sFloat.hashCode(), expected.hashCode());
    assertNotEquals(sFloat.hashCode(), noExpected.hashCode());
  }

  @RepeatedTest(20)
  void testEquals() {
    var expected = new ScrabbleFloat(exampleFloat1);
    var noExpected = new ScrabbleFloat(exampleFloat2);

    assertEquals(expected.hashCode(), sFloat.hashCode());
    assertEquals(expected, sFloat);
    assertNotEquals(noExpected, sFloat);
  }

  @RepeatedTest(20)
  void addWith() {
    ScrabbleFloat sFloat2 = new ScrabbleFloat(exampleFloat2);
    ScrabbleFloat expected1 = (ScrabbleFloat) sFloat.addWith(sFloat2);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 + exampleFloat2);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void addedByString() {
    rndm = new Random(seed);
    String exampleString1 =
        RandomStringUtils.random(
            Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true, true, null, rndm);
    ScrabbleString sString1 = new ScrabbleString(exampleString1);

    var expected2 = sFloat.addedByString(sString1);
    ScrabbleString solution2 = new ScrabbleString(exampleString1 + exampleFloat1);
    assertEquals(expected2, solution2);
  }

  @RepeatedTest(20)
  void addedByInt() {
    Random rndm = new Random(seed);
    int exampleInt1 = rndm.nextInt(100000);
    ScrabbleInt sInt = new ScrabbleInt(exampleInt1);
    var expected1 = sFloat.addedByInt(sInt);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 + exampleInt1);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void addedByFloat() {
    ScrabbleFloat sFloat2 = new ScrabbleFloat(exampleFloat2);
    var expected1 = sFloat.addWith(sFloat2);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 + exampleFloat2);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void addedByBinary() {
    rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);

    var solution = sFloat.addedByBinary(sBin1);
    assertNull(solution);
  }

  @RepeatedTest(20)
  void subtractWith() {
    ScrabbleFloat sFloat2 = new ScrabbleFloat(exampleFloat2);
    var expected1 = sFloat.subtractWith(sFloat2);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 - exampleFloat2);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void subtractedByInt() {
    Random rndm = new Random(seed);
    int exampleInt1 = rndm.nextInt(100000);
    ScrabbleInt sInt = new ScrabbleInt(exampleInt1);
    var expected1 = sFloat.subtractedByInt(sInt);
    double doubleResult = exampleInt1 - exampleFloat1;
    ScrabbleFloat actual = new ScrabbleFloat(doubleResult);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void subtractedByFloat() {
    ScrabbleFloat sFloat2 = new ScrabbleFloat(exampleFloat2);
    var expected1 = sFloat.subtractWith(sFloat2);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 - exampleFloat2);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void subtractedByBinary() {
    rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);
    var solution = sFloat.subtractedByBinary(sBin1);
    assertNull(solution);
  }

  @RepeatedTest(20)
  void multiplyWith() {
    ScrabbleFloat sFloat2 = new ScrabbleFloat(exampleFloat2);
    var expected1 = sFloat.multiplyWith(sFloat2);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 * exampleFloat2);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void multipliedByInt() {
    Random rndm = new Random(seed);
    int exampleInt1 = rndm.nextInt(100000);
    ScrabbleInt sInt = new ScrabbleInt(exampleInt1);
    var expected1 = sFloat.multipliedByInt(sInt);
    double doubleResult = exampleInt1 * exampleFloat1;
    ScrabbleFloat actual = new ScrabbleFloat(doubleResult);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void multipliedByFloat() {
    ScrabbleFloat sFloat2 = new ScrabbleFloat(exampleFloat2);
    var expected1 = sFloat.multipliedByFloat(sFloat2);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 * exampleFloat2);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void multipliedByBinary() {
    rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);
    var solution = sFloat.multipliedByBinary(sBin1);
    assertNull(solution);
  }

  @RepeatedTest(20)
  void divideWith() {
    if (exampleFloat2 == 0) {
      exampleFloat2 += 1;
    }
    ScrabbleFloat sFloat2 = new ScrabbleFloat(exampleFloat2);
    var expected1 = sFloat.divideWith(sFloat2);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 / exampleFloat2);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void dividedByInt() {
    Random rndm = new Random(seed);
    int exampleInt1 = rndm.nextInt(100000);
    ScrabbleInt sInt = new ScrabbleInt(exampleInt1);
    var expected1 = sFloat.dividedByInt(sInt);
    double doubleResult = exampleInt1 / exampleFloat1;
    ScrabbleFloat actual = new ScrabbleFloat(doubleResult);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void dividedByFloat() {
    ScrabbleFloat sFloat2 = new ScrabbleFloat(exampleFloat2);
    var expected1 = sFloat.dividedByFloat(sFloat2);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat2 / exampleFloat1);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void dividedByBinary() {
    rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);
    var solution = sFloat.dividedByBinary(sBin1);
    assertNull(solution);
  }

  @RepeatedTest(20)
  void evaluate() {
    var expected = sFloat.evaluate();
    assertEquals(expected, sFloat);
  }
}
