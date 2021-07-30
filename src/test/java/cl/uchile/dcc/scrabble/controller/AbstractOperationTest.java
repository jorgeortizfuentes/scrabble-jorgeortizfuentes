package cl.uchile.dcc.scrabble.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cl.uchile.dcc.scrabble.model.ScrabbleBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleBoolean;
import cl.uchile.dcc.scrabble.model.ScrabbleFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleInt;
import cl.uchile.dcc.scrabble.model.ScrabbleString;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class AbstractOperationTest {

  String exampleString1;
  String exampleString2;
  int exampleInt1;
  int exampleInt2;
  double exampleFloat1;
  double exampleFloat2;
  String exampleBinary1;
  String exampleBinary2;
  boolean exampleBoolean1;
  boolean exampleBoolean2;
  ScrabbleString sString1;
  ScrabbleString sString2;
  ScrabbleInt sInt1;
  ScrabbleInt sInt2;
  ScrabbleFloat sFloat1;
  ScrabbleFloat sFloat2;
  ScrabbleBinary sBinary1;
  ScrabbleBinary sBinary2;
  ScrabbleBoolean sBool1;
  ScrabbleBoolean sBool2;


  Add strAdd;
  Add intAdd;
  Add floatAdd;
  Add binaryAdd;
  Add treeAdd;

  @BeforeEach
  void setUp() {
    int seed = new Random().nextInt();
    Random rndm = new Random(seed);

    exampleString1 = RandomStringUtils
        .random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
            true, null, rndm);

    do {
      exampleString2 = RandomStringUtils
          .random(Math.abs(rndm.nextInt(20)), 0, Character.MAX_CODE_POINT, true,
              true, null, rndm);
    } while (exampleString1.equals(exampleString2));

    exampleInt1 = rndm.nextInt();
    do {
      exampleInt2 = rndm.nextInt();
    } while (exampleInt1 == exampleInt2);
    exampleFloat1 = rndm.nextDouble();
    do {
      exampleFloat2 = rndm.nextDouble();
    } while (exampleFloat1 == exampleFloat2);

    exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    do {
      exampleBinary2 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");

    } while (exampleBinary1.equals(exampleBinary2));
    exampleBoolean1 = rndm.nextBoolean();
    do {
      exampleBoolean2 = rndm.nextBoolean();
    } while (exampleBoolean1 == exampleBoolean2);

    sString1 = new ScrabbleString(exampleString1);
    sString2 = new ScrabbleString(exampleString2);
    sInt1 = new ScrabbleInt(exampleInt1);
    sInt2 = new ScrabbleInt(exampleInt2);
    sFloat1 = new ScrabbleFloat(exampleFloat1);
    sFloat2 = new ScrabbleFloat(exampleFloat2);
    sBinary1 = new ScrabbleBinary(exampleBinary1);
    sBinary2 = new ScrabbleBinary(exampleBinary2);
    sBool1 = new ScrabbleBoolean(exampleBoolean1);
    sBool2 = new ScrabbleBoolean(exampleBoolean2);

    strAdd = new Add(sString1, sString2);
    intAdd = new Add(sInt1, sInt2);
    floatAdd = new Add(sFloat1, sFloat2);
    binaryAdd = new Add(sBinary1, sBinary2);
    treeAdd = new Add(floatAdd, new Add(intAdd, binaryAdd));

  }

  @RepeatedTest(20)
  void asBinary() {
    var addIS = new Add(sInt1, sString1);
    assertNull(addIS.asBinary());

    var addII = new Add(sInt1, sInt2).asBinary();
    var expected = new ScrabbleInt(exampleInt1 + exampleInt2).asBinary();
    assertEquals(expected, addII);

  }

  @RepeatedTest(20)
  void asFloat() {
    var addIS = new Add(sInt1, sString1);
    assertNull(addIS.asFloat());

    var addII = new Add(sInt1, sInt2).asFloat();
    var expected = new ScrabbleInt(exampleInt1 + exampleInt2).asFloat();
    assertEquals(expected, addII);
  }

  @RepeatedTest(20)
  void asString() {
    var addBS = new Add(sBinary1, sString1);
    assertNull(addBS.asString());

    var addII = new Add(sInt1, sInt2).asString();
    var expected = new ScrabbleInt(exampleInt1 + exampleInt2).asString();
    assertEquals(expected, addII);
  }

  @RepeatedTest(20)
  void asBoolean() {
    var addIS = new Add(sInt1, sString1);
    assertNull(addIS.asBoolean());

    var orII = new Or(sBool1, sBool2).evaluate();
    var expected = new ScrabbleBoolean(true);
    assertEquals(expected, orII);
  }

  @RepeatedTest(20)
  void asInt() {
    var addIS = new Add(sInt1, sString1);
    assertNull(addIS.asInt());

    var addII = new Add(sInt1, sInt2).asInt();
    var expected = new ScrabbleInt(exampleInt1 + exampleInt2).asInt();
    assertEquals(expected, addII);
  }

  @RepeatedTest(20)
  void getColor() {
    assertNull(treeAdd.getColor());
  }

  @RepeatedTest(20)
  void getLabel() {
    assertNull(treeAdd.getLabel());

  }
}