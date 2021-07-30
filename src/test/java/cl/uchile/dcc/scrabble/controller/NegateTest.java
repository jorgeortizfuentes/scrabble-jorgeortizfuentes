package cl.uchile.dcc.scrabble.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cl.uchile.dcc.scrabble.model.ScrabbleBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleBoolean;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class NegateTest {

  String exampleBinary1;
  String exampleBinary2;
  boolean exampleBoolean1;
  boolean exampleBoolean2;
  ScrabbleBinary sBinary1;
  ScrabbleBinary sBinary2;
  ScrabbleBoolean sBool1;
  ScrabbleBoolean sBool2;
  Negate boolNeg;
  Negate binNeg;
  Negate complexNeg;

  @BeforeEach
  void setUp() {
    int seed = new Random().nextInt();
    Random rndm = new Random(seed);

    exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16 - 1)) + 1, "01");
    exampleBoolean1 = rndm.nextBoolean();

    sBinary1 = new ScrabbleBinary(exampleBinary1);
    sBool1 = new ScrabbleBoolean(exampleBoolean1);

    boolNeg = new Negate(sBool1);
    binNeg = new Negate(sBinary1);
    complexNeg = new Negate(new Negate(sBool1));
  }

  @RepeatedTest(20)
  void testConstructor() {
    // Bool constructor
    var boolExpected = new Negate(sBool1);
    var noBoolExpected = new Negate(sBool2);

    assertEquals(boolExpected, boolNeg);
    assertEquals(boolExpected.hashCode(), boolNeg.hashCode());

    assertNotEquals(noBoolExpected, boolNeg);
    assertNotEquals(noBoolExpected.hashCode(), boolNeg.hashCode());

    // Binary constructor
    var binExpected = new Negate(sBinary1);
    var noBinExpected = new Negate(sBinary2);

    assertEquals(binExpected, binNeg);
    assertEquals(binExpected.hashCode(), binNeg.hashCode());

    assertNotEquals(noBinExpected, binNeg);
    assertNotEquals(noBinExpected.hashCode(), binNeg.hashCode());

    // Complex negation constructor
    var negExpected = new Negate(new Negate(sBool1));
    var noNegExpected = new Negate(new Negate(sBool2));

    assertEquals(negExpected, complexNeg);
    assertEquals(negExpected.hashCode(), complexNeg.hashCode());

    assertNotEquals(boolNeg, sBool1);

  }

  @RepeatedTest(20)
  void testGetValue() {
    assertEquals(sBool1, boolNeg.getValue());
    assertNotEquals(sBool2, boolNeg.getValue());

    assertEquals(sBinary1, binNeg.getValue());
    assertNotEquals(sBinary2, binNeg.getValue());

  }

  @RepeatedTest(20)
  void testEvaluate() {
    // Test boolean
    assertEquals(boolNeg.evaluate(), new ScrabbleBoolean(!exampleBoolean1));
    assertNotEquals(boolNeg.evaluate(), new ScrabbleBoolean(exampleBoolean1));

    // Test binary
    assertEquals(binNeg.evaluate(), new ScrabbleBinary(exampleBinary1).negation());
    assertNotEquals(binNeg.evaluate(), new ScrabbleBinary(exampleBinary1));

    // Test complex negation
    assertEquals(complexNeg.evaluate(), sBool1);
    assertNotEquals(complexNeg.evaluate(), sBool2);

    // Null
    var nullNegate = new Negate(null);
    assertNull(nullNegate.evaluate());


  }

  @RepeatedTest(20)
  void isComplete() {
    var incompleteTree1 = new Negate();

    assertFalse(incompleteTree1.isComplete());
    assertTrue(boolNeg.isComplete());

  }

  @RepeatedTest(20)
  void setValues() {

    var incompleteTree1 = new Negate();
    incompleteTree1.setValues(sBool1);
    assertEquals(boolNeg, incompleteTree1);

  }
}