package cl.uchile.dcc.scrabble.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.ScrabbleBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleBoolean;
import cl.uchile.dcc.scrabble.model.ScrabbleFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleInt;
import cl.uchile.dcc.scrabble.model.ScrabbleString;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.RepeatedTest;

class ScrabbleFactoryTest {

  @RepeatedTest(20)
  void testGetString() {
    int seed = new Random().nextInt();
    var rndm = new Random(seed);
    String exampleString1 = RandomStringUtils
        .random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
            true, null, rndm);
    String exampleString2;

    do {
      exampleString2 = RandomStringUtils
          .random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
              true, null, rndm);
    } while (exampleString1.equals(exampleString2));

    ScrabbleString a = ScrabbleFactory.getString(exampleString1);
    ScrabbleString b = ScrabbleFactory.getString(exampleString1);
    ScrabbleString c = new ScrabbleString(exampleString1);
    ScrabbleString d = ScrabbleFactory.getString(exampleString2);

    assertEquals(a, b);
    assertEquals(a, c);
    assertTrue(a == b);
    assertFalse(a == c);
    assertNotEquals(a, d);

  }

  @RepeatedTest(20)
  void testGetInt() {
    int seed = new Random().nextInt();
    var rndm = new Random(seed);
    int exampleInt1 = rndm.nextInt(100000);
    int exampleInt2;
    do {
      exampleInt2 = rndm.nextInt(100000);
    } while (exampleInt1 == exampleInt2);

    ScrabbleInt a = ScrabbleFactory.getInt(exampleInt1);
    ScrabbleInt b = ScrabbleFactory.getInt(exampleInt1);
    ScrabbleInt c = new ScrabbleInt(exampleInt1);
    ScrabbleInt d = ScrabbleFactory.getInt(exampleInt2);

    assertEquals(a, b);
    assertEquals(a, c);
    assertTrue(a == b);
    assertFalse(a == c);
    assertNotEquals(a, d);

  }

  @RepeatedTest(20)
  void testGetFloat() {
    int seed = new Random().nextInt();
    var rndm = new Random(seed);
    double exampleFloat1 = rndm.nextDouble();
    double exampleFloat2;
    do {
      exampleFloat2 = rndm.nextDouble();
    } while (exampleFloat1 == exampleFloat2);

    ScrabbleFloat a = ScrabbleFactory.getFloat(exampleFloat1);
    ScrabbleFloat b = ScrabbleFactory.getFloat(exampleFloat1);
    ScrabbleFloat c = new ScrabbleFloat(exampleFloat1);
    ScrabbleFloat d = ScrabbleFactory.getFloat(exampleFloat2);

    assertEquals(a, b);
    assertEquals(a, c);
    assertTrue(a == b);
    assertFalse(a == c);
    assertNotEquals(a, d);
  }

  @RepeatedTest(20)
  void testGetBinary() {
    int seed = new Random().nextInt();
    var rndm = new Random(seed);
    String exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    String exampleBinary2;
    do {
      exampleBinary2 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");

    } while (exampleBinary1.equals(exampleBinary2));

    ScrabbleBinary a = ScrabbleFactory.getBinary(exampleBinary1);
    ScrabbleBinary b = ScrabbleFactory.getBinary(exampleBinary1);
    ScrabbleBinary c = new ScrabbleBinary(exampleBinary1);
    ScrabbleBinary d = ScrabbleFactory.getBinary(exampleBinary2);

    assertEquals(a, b);
    assertEquals(a, c);
    assertTrue(a == b);
    assertFalse(a == c);
    assertNotEquals(a, d);
  }

  @RepeatedTest(20)
  void testGetBoolean() {
    int seed = new Random().nextInt();
    var rndm = new Random(seed);
    boolean exampleBoolean1 = rndm.nextBoolean();
    boolean exampleBoolean2;
    do {
      exampleBoolean2 = rndm.nextBoolean();
    } while (exampleBoolean1 == exampleBoolean2);

    ScrabbleBoolean a = ScrabbleFactory.getBoolean(exampleBoolean1);
    ScrabbleBoolean b = ScrabbleFactory.getBoolean(exampleBoolean1);
    ScrabbleBoolean c = new ScrabbleBoolean(exampleBoolean1);
    ScrabbleBoolean d = ScrabbleFactory.getBoolean(exampleBoolean2);

    assertEquals(a, b);
    assertEquals(a, c);
    assertTrue(a == b);
    assertFalse(a == c);
    assertNotEquals(a, d);
  }

  @RepeatedTest(20)
  void getFromKey() {
    int seed = new Random().nextInt();
    var rndm = new Random(seed);
    String exampleString1 = RandomStringUtils
        .random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
            true, null, rndm);
    String exampleString2;

    do {
      exampleString2 = RandomStringUtils
          .random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
              true, null, rndm);
    } while (exampleString1.equals(exampleString2));

    ScrabbleString a = ScrabbleFactory.getString(exampleString1);
    int aKey = a.hashCode();
    ScrabbleString b = ScrabbleFactory.getString(exampleString2);
    int bKey = b.hashCode();

    var aFromKey = ScrabbleFactory.getFromKey(aKey);
    var bFromKey = ScrabbleFactory.getFromKey(bKey);

    assertEquals(a, aFromKey);
    assertEquals(b, bFromKey);
    assertTrue(a == aFromKey);
    assertFalse(a == b);
    assertNotEquals(a, b);
    assertNotEquals(aFromKey, bFromKey);

  }

  @RepeatedTest(20)
  void saveScrabbleType() {
    int seed = new Random().nextInt();
    var rndm = new Random(seed);
    String exampleString1 = RandomStringUtils
        .random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
            true, null, rndm);

    ScrabbleString a = new ScrabbleString(exampleString1);
    ScrabbleFactory.saveScrabbleType(a);
    int aKey = a.hashCode();

    var aFromKey = ScrabbleFactory.getFromKey(aKey);

    assertEquals(a, aFromKey);


  }
}