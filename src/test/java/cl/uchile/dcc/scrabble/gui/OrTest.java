package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class OrTest {
  String exampleBinary1;
  String exampleBinary2;
  boolean exampleBoolean1;
  boolean exampleBoolean2;
  ScrabbleBinary sBinary1;
  ScrabbleBinary sBinary2;
  ScrabbleBoolean sBool1;
  ScrabbleBoolean sBool2;
  Or boolOr;
  Or binOr;
  Or binBoolOr;
  Or treeOr;

  @BeforeEach
  void setUp() {
    int seed = new Random().nextInt();
    Random rndm = new Random(seed);

    exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1))+1, "01");
    do{
      exampleBinary2 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1))+1, "01");

    } while (exampleBinary1.equals(exampleBinary2));

    exampleBoolean1 = rndm.nextBoolean();
    do{
      exampleBoolean2 = rndm.nextBoolean();
    } while (exampleBoolean1 == exampleBoolean2);

    sBinary1 = new ScrabbleBinary(exampleBinary1);
    sBinary2 = new ScrabbleBinary(exampleBinary2);

    sBool1 = new ScrabbleBoolean(exampleBoolean1);
    sBool2 = new ScrabbleBoolean(exampleBoolean2);

    boolOr = new Or(sBool1,sBool2);
    binOr = new Or(sBinary1,sBinary2);
    binBoolOr = new Or(sBinary1,sBool1);
    treeOr = new Or(sBinary1,new Or(sBool1,sBinary1));
  }

  @RepeatedTest(20)
  void testConstructor() {
    // Bool constructor
    var boolExpected = new Or(sBool1,sBool2);
    var noBoolExpected = new Or(sBool1,sBool1);

    assertEquals(boolExpected, boolOr);
    assertEquals(boolExpected.hashCode(), boolOr.hashCode());

    assertNotEquals(noBoolExpected, boolOr);
    assertNotEquals(noBoolExpected.hashCode(), boolOr.hashCode());

    // Binary constructor
    var binExpected = new Or(sBinary1,sBinary2);
    var noBinExpected = new Or(sBinary1,sBinary1);

    assertEquals(binExpected, binOr);
    assertEquals(binExpected.hashCode(), binOr.hashCode());

    assertNotEquals(noBinExpected, binOr);
    assertNotEquals(noBinExpected.hashCode(), binOr.hashCode());

    // Binary and Boolean constructor
    var binBoolExpected = new Or(sBinary1,sBool1);
    var noBinBoolExpected = new Or(sBinary1,sBool2);

    assertEquals(binBoolExpected, binBoolOr);
    assertEquals(binBoolExpected.hashCode(), binBoolOr.hashCode());

    assertNotEquals(noBinBoolExpected, binBoolOr);
    assertNotEquals(noBinBoolExpected.hashCode(), binBoolOr.hashCode());

    // Complex tree constructor
    var complexExpected = new Or(sBinary1,new Or(sBool1,sBinary1));
    var noComplexExpected = new Or(sBinary1,new Or(sBool2,sBinary1));

    assertEquals(complexExpected, treeOr);
    assertEquals(complexExpected.hashCode(), treeOr.hashCode());

    assertNotEquals(noComplexExpected, treeOr);
    assertNotEquals(noComplexExpected.hashCode(), treeOr.hashCode());
  }

  @RepeatedTest(20)
  void testGetLeft() {
    assertEquals(sBool1, boolOr.getLeft());
    assertNotEquals(sBool2, boolOr.getLeft());

    assertEquals(sBinary1, binOr.getLeft());
    assertNotEquals(sBinary2, binOr.getLeft());

    assertEquals(sBinary1, treeOr.getLeft());
    assertNotEquals(sBinary2, treeOr.getLeft());

  }

  @RepeatedTest(20)
  void testGetRight() {
    assertEquals(sBool2, boolOr.getRight());
    assertNotEquals(sBool1, boolOr.getRight());

    assertEquals(sBinary2, binOr.getRight());
    assertNotEquals(sBinary1, binOr.getRight());

    assertEquals(new Or(sBool1,sBinary1), treeOr.getRight());
    assertNotEquals(sBinary1, treeOr.getRight());

  }

  @RepeatedTest(20)
  void evaluate() {

    // Test two booleans
    boolean exBoolOr = exampleBoolean1 || exampleBoolean2;
    assertEquals(boolOr.evaluate(), new ScrabbleBoolean(exBoolOr));

    // Test two binaries
    var exBinOr = sBinary1.conjunctionWith(sBinary2);
    assertEquals(binOr.evaluate(), exBinOr);


    // Test binary with boolean

    // Test complex tree

  }
}