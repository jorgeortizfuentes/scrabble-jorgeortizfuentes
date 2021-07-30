package cl.uchile.dcc.scrabble.model;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class ScrabbleAbstractTest {

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

  }

  @RepeatedTest(20)
  void negation() {
    assertNull(sInt1.negation());
  }

  @RepeatedTest(20)
  void conjunctionWith() {
    assertNull(sInt1.conjunctionWith(sInt2));
  }

  @RepeatedTest(20)
  void conjunctionByBoolean() {
    assertNull(sInt1.conjunctionByBoolean(sBool1));

  }

  @RepeatedTest(20)
  void conjunctionByBinary() {
    assertNull(sInt1.conjunctionByBinary(sBinary1));

  }

  @RepeatedTest(20)
  void disjunctionWith() {
    assertNull(sInt1.disjunctionWith(sInt2));

  }

  @RepeatedTest(20)
  void disjunctionByBoolean() {
    assertNull(sInt1.disjunctionByBoolean(sBool1));

  }

  @RepeatedTest(20)
  void disjunctionByBinary() {
    assertNull(sInt1.disjunctionByBinary(sBinary1));

  }

  @RepeatedTest(20)
  void subtractWith() {
    assertNull(sBool1.subtractWith(sBool2));
  }

  @RepeatedTest(20)
  void subtractedByInt() {
    assertNull(sBool1.subtractedByInt(sInt1));
  }

  @RepeatedTest(20)
  void subtractedByFloat() {
    assertNull(sBool1.subtractedByFloat(sFloat1));

  }

  @RepeatedTest(20)
  void subtractedByBinary() {
    assertNull(sBool1.subtractedByBinary(sBinary1));

  }

  @RepeatedTest(20)
  void multiplyWith() {
    assertNull(sBool1.multiplyWith(sBinary1));

  }

  @RepeatedTest(20)
  void multipliedByInt() {
    assertNull(sBool1.multipliedByInt(sInt1));

  }

  @RepeatedTest(20)
  void multipliedByFloat() {
    assertNull(sBool1.multipliedByFloat(sFloat1));

  }

  @RepeatedTest(20)
  void multipliedByBinary() {
    assertNull(sBool1.multipliedByBinary(sBinary1));

  }

  @RepeatedTest(20)
  void divideWith() {
    assertNull(sBool1.divideWith(sBinary1));

  }

  @RepeatedTest(20)
  void dividedByInt() {
    assertNull(sBool1.dividedByInt(sInt1));

  }

  @RepeatedTest(20)
  void dividedByFloat() {
    assertNull(sBool1.dividedByFloat(sFloat1));

  }

  @RepeatedTest(20)
  void dividedByBinary() {
    assertNull(sBool1.dividedByBinary(sBinary1));

  }

  @RepeatedTest(20)
  void asBinary() {
    assertNull(sString1.asBinary());

  }

  @RepeatedTest(20)
  void asFloat() {
    assertNull(sString1.asFloat());

  }

  @RepeatedTest(20)
  void asInt() {
    assertNull(sString1.asInt());

  }

  @RepeatedTest(20)
  void asBoolean() {
    assertNull(sString1.asBoolean());

  }

  @RepeatedTest(20)
  void addWith() {
    assertNull(sBool1.addWith(sInt1));
  }


  @RepeatedTest(20)
  void addedByInt() {
    assertNull(sString1.addedByInt(sInt1));

  }

  @RepeatedTest(20)
  void addedByFloat() {
    assertNull(sString1.addedByInt(sInt1));

  }

  @RepeatedTest(20)
  void addedByBinary() {
    assertNull(sString1.addedByBinary(sBinary1));

  }


}