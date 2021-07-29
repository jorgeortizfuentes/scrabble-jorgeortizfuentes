package cl.uchile.dcc.scrabble.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class ScrabbleBinaryTest {

  private String exampleBinary1;
  private String exampleBinary2;
  private ScrabbleBinary sBin;

  private int seed;
  private Random rndm;

  @BeforeEach
  void setUp() {
    seed = new Random().nextInt();
    rndm = new Random(seed);

    exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    do {
      exampleBinary2 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");

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
    String randomStringNonBinary = RandomStringUtils.random(16);

    AssertionError error =
        Assertions.assertThrows(
            AssertionError.class,
            () -> {
              new ScrabbleBinary(randomStringNonBinary);
            });
    Assertions.assertEquals("The string is not a binary.", error.getMessage());
  }

  @RepeatedTest(20)
  void testToString() {
    assertEquals(exampleBinary1, sBin.toString());
    assertNotEquals(exampleBinary2, sBin.toString());
  }

  @RepeatedTest(20)
  void testAsString() {
    Assertions.assertEquals(new ScrabbleString(exampleBinary1), sBin.asString());
    assertNotEquals(new ScrabbleString(exampleBinary2), sBin.asString());
  }

  @RepeatedTest(20)
  void testAsBinary() {
    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    assertEquals(sBin, sBin.asBinary());
    assertNotEquals(sBin, sBin2.asBinary());
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
    String negationString = exampleBinary1.replace("0", "x").replace("1", "0").replace("x", "1");
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
    rndm = new Random(seed);
    boolean exampleBoolean1 = rndm.nextBoolean();
    ScrabbleBoolean sBool1 = new ScrabbleBoolean(exampleBoolean1);

    var conjunction = sBin.conjunctionByBoolean(sBool1);
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
    var expected = sBin.conjunctionByBinary(sBin2);

    String v1;
    String v2;

    int lengthDifference = Math.abs(sBin.getContent().length() - sBin2.getContent().length());

    if (sBin.getContent().length() >= sBin2.getContent().length()) {
      v1 = sBin.getContent();
      v2 = sBin2.getContent();
    } else {
      v1 = sBin2.getContent();
      v2 = sBin.getContent();
    }
    var newV2 = new StringBuilder();
    newV2.append("0".repeat(lengthDifference));
    newV2.append(v2);
    v2 = newV2.toString();

    StringBuilder newBinary = new StringBuilder();
    for (int i = 0; i < v1.length(); i++) {
      if (v1.charAt(i) == '1' && v2.charAt(i) == '1') {
        newBinary.append("1");
      } else {
        newBinary.append("0");
      }
    }
    var conjunction = new ScrabbleBinary(newBinary.toString());

    assertEquals(expected, conjunction);
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
    assertEquals(expected, disjunction);
  }

  @RepeatedTest(20)
  void disjunctionByBoolean() {
    var exampleBoolean1 = rndm.nextBoolean();
    ScrabbleBoolean sBool = new ScrabbleBoolean(exampleBoolean1);
    var disjunction = sBin.disjunctionByBoolean(sBool);
    ScrabbleBinary expected;

    if (exampleBoolean1) {
      expected = new ScrabbleBinary(exampleBinary1.replace("0", "1"));

    } else {
      expected = new ScrabbleBinary(exampleBinary1);
    }
    assertEquals(expected, disjunction);
  }

  @RepeatedTest(20)
  void disjunctionByBinary() {
    var sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected = sBin.disjunctionByBinary(sBin2);

    String v1;
    String v2;

    int lengthDifference = Math.abs(sBin.getContent().length() - sBin2.getContent().length());

    if (sBin.getContent().length() >= sBin2.getContent().length()) {
      v1 = sBin.getContent();
      v2 = sBin2.getContent();
    } else {
      v1 = sBin2.getContent();
      v2 = sBin.getContent();
    }
    var newV2 = new StringBuilder();
    newV2.append("0".repeat(lengthDifference));
    newV2.append(v2);
    v2 = newV2.toString();

    StringBuilder newBinary = new StringBuilder();
    for (int i = 0; i < v1.length(); i++) {
      if (v1.charAt(i) == '0' && v2.charAt(i) == '0') {
        newBinary.append("0");
      } else {
        newBinary.append("1");
      }
    }
    var disjunction = new ScrabbleBinary(newBinary.toString());

    assertEquals(expected, disjunction);
  }

  @RepeatedTest(20)
  void addWith() {
    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected1 = sBin.addWith(sBin2);
    var actual =
        new ScrabbleInt(
            BinUtilities.binaryToInt(exampleBinary1) + BinUtilities.binaryToInt(exampleBinary2))
            .asBinary();
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void addedByString() {
    rndm = new Random(seed);
    String exampleString1 =
        RandomStringUtils.random(
            Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true, true, null, rndm);
    ScrabbleString sString1 = new ScrabbleString(exampleString1);

    var actual = sBin.addedByString(sString1);
    ScrabbleString expected = new ScrabbleString(exampleString1 + exampleBinary1);

    assertEquals(expected, actual);
  }

  @RepeatedTest(20)
  void addedByInt() {
    Random rndm = new Random(seed);
    int exampleInt1 = rndm.nextInt(100000);
    ScrabbleInt sInt = new ScrabbleInt(exampleInt1);
    var expected1 = sBin.addedByInt(sInt);
    var actual = new ScrabbleInt(BinUtilities.binaryToInt(exampleBinary1) + exampleInt1);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void addedByFloat() {
    rndm = new Random(seed);
    double exampleFloat1 = rndm.nextDouble();
    ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);
    var expected1 = sBin.addedByFloat(sFloat1);
    var actual = new ScrabbleFloat(BinUtilities.binaryToInt(exampleBinary1) + exampleFloat1);
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void addedByBinary() {
    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected1 = sBin.addedByBinary(sBin2);
    var actual =
        new ScrabbleInt(
            BinUtilities.binaryToInt(exampleBinary1) + BinUtilities.binaryToInt(exampleBinary2))
            .asBinary();
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void subtractWith() {
    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected1 = sBin2.subtractWith(sBin);
    var actual =
        new ScrabbleInt(
            BinUtilities.binaryToInt(exampleBinary2) - BinUtilities.binaryToInt(exampleBinary1))
            .asBinary();
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void subtractedByInt() {
    Random rndm = new Random(seed);
    int exampleInt1 = rndm.nextInt(100000);
    ScrabbleInt sInt = new ScrabbleInt(exampleInt1);
    var expected1 = sBin.subtractedByInt(sInt);
    var actual = new ScrabbleInt(exampleInt1 - BinUtilities.binaryToInt(exampleBinary1));
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void subtractedByFloat() {
    rndm = new Random(seed);
    double exampleFloat1 = rndm.nextDouble();
    ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);
    var expected1 = sBin.subtractedByFloat(sFloat1);
    var actual = new ScrabbleFloat(exampleFloat1 - BinUtilities.binaryToInt(exampleBinary1));
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void subtractedByBinary() {
    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected1 = sBin.subtractedByBinary(sBin2);
    var actual =
        new ScrabbleInt(
            BinUtilities.binaryToInt(exampleBinary2) - BinUtilities.binaryToInt(exampleBinary1))
            .asBinary();
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void multiplyWith() {
    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected1 = sBin2.multiplyWith(sBin);
    var actual =
        new ScrabbleInt(
            BinUtilities.binaryToInt(exampleBinary2) * BinUtilities.binaryToInt(exampleBinary1))
            .asBinary();
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void multipliedByInt() {
    Random rndm = new Random(seed);
    int exampleInt1 = rndm.nextInt(100000);
    ScrabbleInt sInt = new ScrabbleInt(exampleInt1);
    var expected1 = sBin.multipliedByInt(sInt);
    var actual = new ScrabbleInt(exampleInt1 * BinUtilities.binaryToInt(exampleBinary1));
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void multipliedByFloat() {
    rndm = new Random(seed);
    double exampleFloat1 = rndm.nextDouble();
    ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);
    var expected1 = sBin.multipliedByFloat(sFloat1);
    var actual = new ScrabbleFloat(exampleFloat1 * BinUtilities.binaryToInt(exampleBinary1));
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void multipliedByBinary() {
    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected1 = sBin.multipliedByBinary(sBin2);
    var actual =
        new ScrabbleInt(
            BinUtilities.binaryToInt(exampleBinary2) * BinUtilities.binaryToInt(exampleBinary1))
            .asBinary();
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void divideWith() {
    Random rndm = new Random(seed);
    String exampleBinary3;
    ScrabbleBinary sBin3;
    do {
      exampleBinary3 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
      sBin3 = new ScrabbleBinary(exampleBinary3);
    } while (BinUtilities.binaryToInt(exampleBinary3) == 0);

    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected1 = sBin2.divideWith(sBin3);
    var actual =
        new ScrabbleInt(
            BinUtilities.binaryToInt(exampleBinary2) / BinUtilities.binaryToInt(exampleBinary3))
            .asBinary();
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void dividedByInt() {
    Random rndm = new Random(seed);
    String exampleBinary3;
    ScrabbleBinary sBin3;
    do {
      exampleBinary3 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
      sBin3 = new ScrabbleBinary(exampleBinary3);
    } while (BinUtilities.binaryToInt(exampleBinary3) == 0);

    int exampleInt1 = rndm.nextInt(100000);
    ScrabbleInt sInt = new ScrabbleInt(exampleInt1);
    var expected1 = sBin3.dividedByInt(sInt);
    var actual = new ScrabbleInt(exampleInt1 / BinUtilities.binaryToInt(exampleBinary3));
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void dividedByFloat() {
    Random rndm = new Random(seed);
    String exampleBinary3;
    ScrabbleBinary sBin3;
    do {
      exampleBinary3 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
      sBin3 = new ScrabbleBinary(exampleBinary3);
    } while (BinUtilities.binaryToInt(exampleBinary3) == 0);

    double exampleFloat1 = rndm.nextDouble();
    ScrabbleFloat sFloat1 = new ScrabbleFloat(exampleFloat1);
    var expected1 = sBin3.dividedByFloat(sFloat1);
    var actual = new ScrabbleFloat(exampleFloat1 / BinUtilities.binaryToInt(exampleBinary3));
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void dividedByBinary() {
    Random rndm = new Random(seed);
    String exampleBinary3;
    ScrabbleBinary sBin3;
    do {
      exampleBinary3 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
      sBin3 = new ScrabbleBinary(exampleBinary3);
    } while (BinUtilities.binaryToInt(exampleBinary3) == 0);

    ScrabbleBinary sBin2 = new ScrabbleBinary(exampleBinary2);
    var expected1 = sBin3.dividedByBinary(sBin2);
    var actual =
        new ScrabbleInt(
            BinUtilities.binaryToInt(exampleBinary2) / BinUtilities.binaryToInt(exampleBinary3))
            .asBinary();
    assertEquals(expected1, actual);
  }

  @RepeatedTest(20)
  void evaluate() {
    var expected = sBin.evaluate();
    assertEquals(expected, sBin);
  }


  @RepeatedTest(20)
  void getColor() {
    var expected = "DARKSLATEGRAY";
    assertEquals(expected, sBin.getColor());

  }

  @RepeatedTest(20)
  void getLabel() {
    var expected = "BIN";
    assertEquals(expected, sBin.getLabel());

  }

}