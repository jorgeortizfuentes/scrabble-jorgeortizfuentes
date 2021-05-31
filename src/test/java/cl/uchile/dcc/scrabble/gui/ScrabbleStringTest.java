package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ScrabbleStringTest {

  private String exampleString1;
  private String exampleString2;
  private ScrabbleString strScr;
  private ScrabbleString strScr2;
  private Random rndm;

  @BeforeEach
  void setUp() {
    int seed = new Random().nextInt();
    rndm = new Random(seed);

    exampleString1 =
        RandomStringUtils.random(
            Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true, true, null, rndm);

    do {
      exampleString2 =
          RandomStringUtils.random(
              Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true, true, null, rndm);
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
  void ToString() {
    assertEquals(exampleString1, strScr.toString());
    assertNotEquals(exampleString2, strScr.toString());
  }

  @RepeatedTest(20)
  void testAsString() {
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
    var expected1 = strScr.addWith(strScr2);
    ScrabbleString solution1 = new ScrabbleString(exampleString1 + exampleString2);
    assertEquals(expected1, solution1);
  }

  @RepeatedTest(20)
  void addedByString() {
    strScr2 = new ScrabbleString(exampleString2);
    var expected1 = strScr2.addedByString(strScr);
    ScrabbleString solution1 = new ScrabbleString(exampleString1 + exampleString2);
    assertEquals(expected1, solution1);
  }

  @RepeatedTest(20)
  void addedByInt() {
    var exampleInt1 = rndm.nextInt();
    var sInt = new ScrabbleInt(exampleInt1);
    var solution = strScr.addedByInt(sInt);
    assertNull(solution);
  }

  @RepeatedTest(20)
  void addedByFloat() {
    var exampleFloat1 = rndm.nextDouble();
    var sFloat = new ScrabbleFloat(exampleFloat1);
    var solution = strScr.addedByFloat(sFloat);
    assertNull(solution);
  }

  @RepeatedTest(20)
  void addedByBinary() {
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1) + 1), "01");
    var sBin = new ScrabbleBinary(exampleBinary1);
    var solution = strScr.addedByBinary(sBin);
    assertNull(solution);
  }

}
