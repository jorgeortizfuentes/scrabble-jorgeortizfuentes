package cl.uchile.dcc.scrabble.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ScrabbleIntTest {

  private ScrabbleInt sInt;
  private int exampleInt1;
  private int exampleInt2;

  private int seed;
  private Random rndm;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    Random rndm = new Random(seed);
    exampleInt1 = rndm.nextInt(100000);

    do {
      exampleInt2 = rndm.nextInt(100000);
    } while (exampleInt1 == exampleInt2);

    sInt = new ScrabbleInt(exampleInt1);
  }

  @RepeatedTest(20)
  void testConstructor() {
    var expected = new ScrabbleInt(exampleInt1);
    var noExpected = new ScrabbleInt(exampleInt2);

    assertEquals(expected, sInt);
    assertEquals(expected.hashCode(), sInt.hashCode());

    assertNotEquals(noExpected, sInt);
    assertNotEquals(sInt, sInt.asFloat());
  }

  @RepeatedTest(20)
  void testToString() {
    String exampleStrInt1 = Integer.toString(exampleInt1);
    String exampleStrInt2 = Integer.toString(exampleInt2);

    assertEquals(exampleStrInt1, sInt.toString());
    assertNotEquals(exampleStrInt2, sInt.toString());
  }

  @RepeatedTest(20)
  void testAsString() {
    String exampleStrInt1 = Integer.toString(exampleInt1);
    String exampleStrInt2 = Integer.toString(exampleInt2);
    Assertions.assertEquals(new ScrabbleString(exampleStrInt1), sInt.asString());
    assertNotEquals(new ScrabbleString(exampleStrInt2), sInt.asString());
  }

  @RepeatedTest(20)
  void testAsFloat() {
    ScrabbleFloat actual = sInt.asFloat();

    double int1LikeFloat = exampleInt1;
    ScrabbleFloat expected = new ScrabbleFloat(int1LikeFloat);

    double int2LikeFloat = exampleInt2;
    ScrabbleFloat noExpected = new ScrabbleFloat(int2LikeFloat);

    assertEquals(expected, actual);
    assertNotEquals(noExpected, actual);
  }

  @RepeatedTest(20)
  void testAsInt() {
    assertEquals(sInt, sInt.asInt());
    assertNotEquals(new ScrabbleInt(exampleInt2), sInt.asInt());
  }

  @RepeatedTest(20)
  void getContent() {
    assertEquals(exampleInt1, sInt.getContent());
    assertNotEquals(exampleInt2, sInt.getContent());
  }

  @RepeatedTest(20)
  void testHashCode() {
    var expected = new ScrabbleInt(exampleInt1);
    var noExpected = new ScrabbleInt(exampleInt2);

    assertEquals(sInt.hashCode(), expected.hashCode());
    assertNotEquals(sInt.hashCode(), noExpected.hashCode());
  }

  @RepeatedTest(20)
  void testEquals() {
    var expected = new ScrabbleInt(exampleInt1);
    var noExpected = new ScrabbleInt(exampleInt2);

    assertEquals(expected.hashCode(), sInt.hashCode());
    assertEquals(expected, sInt);
    assertNotEquals(noExpected, sInt);
  }

  @RepeatedTest(20)
  void asBinary() {
    ScrabbleBinary BinScr1 = new ScrabbleBinary(BinUtilities.intToBinary(exampleInt1));
    ScrabbleBinary BinScr2 = new ScrabbleBinary(BinUtilities.intToBinary(exampleInt2));
    assertEquals(BinScr1, sInt.asBinary());
    assertNotEquals(BinScr2, sInt.asBinary());
  }

  @RepeatedTest(20)
  void addWith() {
    var sInt1 = new ScrabbleInt(exampleInt1);
    var sInt2 = new ScrabbleInt(exampleInt2);
    ScrabbleInt expected = (ScrabbleInt) sInt1.addWith(sInt2);
    ScrabbleInt actual = new ScrabbleInt(exampleInt1 + exampleInt2);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void addedByString() {
    rndm = new Random(seed);
    String exampleString1 =
        RandomStringUtils.random(
            Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true, true, null, rndm);
    ScrabbleString sString1 = new ScrabbleString(exampleString1);

    var actual = sInt.addedByString(sString1);
    ScrabbleString expected = new ScrabbleString(exampleString1 + exampleInt1);

    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void addedByInt() {
    rndm = new Random(seed);
    var sInt2 = new ScrabbleInt(exampleInt2);
    var expected = sInt2.addedByInt(sInt);
    ScrabbleInt actual = new ScrabbleInt(exampleInt1 + exampleInt2);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void addedByFloat() {
    rndm = new Random(seed);
    var exampleFloat1 = rndm.nextDouble();
    ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);
    ScrabbleFloat expected = (ScrabbleFloat) sInt.addedByFloat(sFloat1);
    ScrabbleFloat actual = new ScrabbleFloat(exampleInt1 + exampleFloat1);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void addedByBinary() {
    rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);

    var expected = sInt.addedByBinary(sBin1);
    int sum = sBin1.asInt().getContent() + exampleInt1;
    ScrabbleBinary actual = new ScrabbleBinary(BinUtilities.intToBinary(sum));
    assertEquals(expected, actual, "Error ");
  }

  @RepeatedTest(20)
  void subtractWith() {
    rndm = new Random(seed);
    var sInt1 = new ScrabbleInt(exampleInt1);
    var sInt2 = new ScrabbleInt(exampleInt2);
    ScrabbleInt expected = (ScrabbleInt) sInt1.subtractWith(sInt2);
    ScrabbleInt actual = new ScrabbleInt(exampleInt1 - exampleInt2);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void subtractedByInt() {
    rndm = new Random(seed);
    var sInt2 = new ScrabbleInt(exampleInt2);
    var expected = sInt2.subtractedByInt(sInt);
    ScrabbleInt actual = new ScrabbleInt(exampleInt1 - exampleInt2);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void subtractedByFloat() {
    rndm = new Random(seed);
    double exampleFloat1 = rndm.nextDouble();
    ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);

    System.out.println(exampleFloat1);
    System.out.println(exampleInt1);
    double subtraction = exampleFloat1 - exampleInt1;
    System.out.println("expected");
    System.out.println(subtraction);
    var actual = sInt.subtractedByFloat(sFloat1);
    ScrabbleFloat expected = new ScrabbleFloat(subtraction);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void subtractedByBinary() {
    rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);

    var expected = sInt.subtractedByBinary(sBin1);
    int sum = sBin1.asInt().getContent() - exampleInt1;
    ScrabbleBinary actual = new ScrabbleBinary(BinUtilities.intToBinary(sum));
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void multiplyWith() {
    rndm = new Random(seed);
    var sInt2 = new ScrabbleInt(exampleInt2);
    var expected = sInt2.multiplyWith(sInt);
    ScrabbleInt actual = new ScrabbleInt(exampleInt1 * exampleInt2);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void multipliedByInt() {
    rndm = new Random(seed);
    var sInt2 = new ScrabbleInt(exampleInt2);
    var expected = sInt.multipliedByInt(sInt2);
    ScrabbleInt actual = new ScrabbleInt(exampleInt1 * exampleInt2);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void multipliedByFloat() {
    rndm = new Random(seed);
    double exampleFloat1 = rndm.nextDouble();
    ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);

    var expected = sInt.multipliedByFloat(sFloat1);
    ScrabbleFloat actual = new ScrabbleFloat(exampleInt1 * exampleFloat1);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void multipliedByBinary() {
    rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);

    var expected = sInt.multipliedByBinary(sBin1);
    int sum = sBin1.asInt().getContent() * exampleInt1;
    ScrabbleBinary actual = new ScrabbleBinary(BinUtilities.intToBinary(sum));
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void divideWith() {
    if (exampleInt2 == 0) {
      exampleInt2 += 1;
    }
    var sInt2 = new ScrabbleInt(exampleInt2);
    int division = Math.round(exampleInt1 / exampleInt2);
    var expected = new ScrabbleInt(division);
    var actual = sInt.divideWith(sInt2);

    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void dividedByInt() {
    if (exampleInt2 == 0) {
      exampleInt2 += 1;
    }
    var sInt2 = new ScrabbleInt(exampleInt2);
    int division = Math.round(exampleInt1 / exampleInt2);
    var expected = new ScrabbleInt(division);
    var actual = sInt2.dividedByInt(sInt);

    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void dividedByFloat() {
    rndm = new Random(seed);
    double exampleFloat1 = rndm.nextDouble();
    if (exampleInt1 == 0) {
      exampleInt1 += 1;
    }
    ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);
    var expected = sInt.dividedByFloat(sFloat1);
    ScrabbleFloat actual = new ScrabbleFloat(exampleFloat1 / exampleInt1);
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void dividedByBinary() {
    rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    ScrabbleBinary sBin1 = new ScrabbleBinary(exampleBinary1);

    var expected = sBin1.divideWith(sInt);
    int sum = sBin1.asInt().getContent() / exampleInt1;
    ScrabbleBinary actual = new ScrabbleBinary(BinUtilities.intToBinary(sum));
    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void evaluate() {
    var expected = sInt.evaluate();
    assertEquals(expected, sInt);
  }
}
