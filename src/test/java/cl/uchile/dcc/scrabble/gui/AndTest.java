package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.*;

import cl.uchile.dcc.scrabble.operations.And;
import cl.uchile.dcc.scrabble.types.ScrabbleBinary;
import cl.uchile.dcc.scrabble.types.ScrabbleBoolean;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;


class AndTest {
  String exampleBinary1;
  String exampleBinary2;
  boolean exampleBoolean1;
  boolean exampleBoolean2;
  ScrabbleBinary sBinary1;
  ScrabbleBinary sBinary2;
  ScrabbleBoolean sBool1;
  ScrabbleBoolean sBool2;
  And boolAnd;
  And binAnd;
  And binBoolAnd;
  And treeAnd;

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

    boolAnd = new And(sBool1,sBool2);
    binAnd = new And(sBinary1,sBinary2);
    binBoolAnd = new And(sBinary1,sBool1);
    treeAnd = new And(sBinary1,new And(sBool1,sBinary1));
  }

  @RepeatedTest(20)
  void testConstructAnd() {
    // Bool constructAnd
    var boolExpected = new And(sBool1,sBool2);
    var noBoolExpected = new And(sBool1,sBool1);

    assertEquals(boolExpected, boolAnd);
    assertEquals(boolExpected.hashCode(), boolAnd.hashCode());

    assertNotEquals(noBoolExpected, boolAnd);
    assertNotEquals(noBoolExpected.hashCode(), boolAnd.hashCode());

    // Binary constructAnd
    var binExpected = new And(sBinary1,sBinary2);
    var noBinExpected = new And(sBinary1,sBinary1);

    assertEquals(binExpected, binAnd);
    assertEquals(binExpected.hashCode(), binAnd.hashCode());

    assertNotEquals(noBinExpected, binAnd);
    assertNotEquals(noBinExpected.hashCode(), binAnd.hashCode());

    // Binary and Boolean constructAnd
    var binBoolExpected = new And(sBinary1,sBool1);
    var noBinBoolExpected = new And(sBinary1,sBool2);

    assertEquals(binBoolExpected, binBoolAnd);
    assertEquals(binBoolExpected.hashCode(), binBoolAnd.hashCode());

    assertNotEquals(noBinBoolExpected, binBoolAnd);
    assertNotEquals(noBinBoolExpected.hashCode(), binBoolAnd.hashCode());

    // Complex tree constructAnd
    var complexExpected = new And(sBinary1,new And(sBool1,sBinary1));
    var noComplexExpected = new And(sBinary1,new And(sBool2,sBinary1));

    assertEquals(complexExpected, treeAnd);
    assertEquals(complexExpected.hashCode(), treeAnd.hashCode());

    assertNotEquals(noComplexExpected, treeAnd);
    assertNotEquals(noComplexExpected.hashCode(), treeAnd.hashCode());
  }

  @RepeatedTest(20)
  void testGetLeft() {
    assertEquals(sBool1, boolAnd.getLeft());
    assertNotEquals(sBool2, boolAnd.getLeft());

    assertEquals(sBinary1, binAnd.getLeft());
    assertNotEquals(sBinary2, binAnd.getLeft());

    assertEquals(sBinary1, treeAnd.getLeft());
    assertNotEquals(sBinary2, treeAnd.getLeft());

  }

  @RepeatedTest(20)
  void testGetRight() {
    assertEquals(sBool2, boolAnd.getRight());
    assertNotEquals(sBool1, boolAnd.getRight());

    assertEquals(sBinary2, binAnd.getRight());
    assertNotEquals(sBinary1, binAnd.getRight());

    assertEquals(new And(sBool1,sBinary1), treeAnd.getRight());
    assertNotEquals(sBinary1, treeAnd.getRight());

  }

  @RepeatedTest(20)
  void evaluate() {

    // Test two booleans
    boolean exBoolAnd = exampleBoolean1 && exampleBoolean2;
    assertEquals(boolAnd.evaluate(), new ScrabbleBoolean(exBoolAnd));

    // Test two binaries
    var exBinAnd = sBinary1.conjunctionWith(sBinary2);
    assertEquals(binAnd.evaluate(), exBinAnd);


    // Test binary with boolean

    // Test complex tree

  }
}