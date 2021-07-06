package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.operations.Subt;
import cl.uchile.dcc.scrabble.types.BinUtilities;
import cl.uchile.dcc.scrabble.types.ScrabbleBinary;
import cl.uchile.dcc.scrabble.types.ScrabbleFloat;
import cl.uchile.dcc.scrabble.types.ScrabbleInt;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class SubtTest {

  int exampleInt1;
  int exampleInt2;
  double exampleFloat1;
  double exampleFloat2;
  String exampleBinary1;
  String exampleBinary2;
  ScrabbleInt sInt1;
  ScrabbleInt sInt2;
  ScrabbleFloat sFloat1;
  ScrabbleFloat sFloat2;
  ScrabbleBinary sBinary1;
  ScrabbleBinary sBinary2;
  Subt intSubt;
  Subt floatSubt;
  Subt binarySubt;
  Subt treeSubt;

  @BeforeEach
  void setUp() {
    int seed = new Random().nextInt();
    Random rndm = new Random(seed);

    exampleInt1 = rndm.nextInt();
    do{
      exampleInt2 = rndm.nextInt();
    } while (exampleInt1 == exampleInt2);
    exampleFloat1 = rndm.nextDouble();
    do{
      exampleFloat2 = rndm.nextDouble();
    } while (exampleFloat1 == exampleFloat2);

    exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1))+1, "01");
    do{
      exampleBinary2 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1))+1, "01");

    } while (exampleBinary1.equals(exampleBinary2));

    sInt1 = new ScrabbleInt(exampleInt1);
    sInt2 = new ScrabbleInt(exampleInt2);
    sFloat1 = new ScrabbleFloat(exampleFloat1);
    sFloat2 = new ScrabbleFloat(exampleFloat2);
    sBinary1 = new ScrabbleBinary(exampleBinary1);
    sBinary2 = new ScrabbleBinary(exampleBinary2);

    intSubt = new Subt(sInt1,sInt2);
    floatSubt = new Subt(sFloat1,sFloat2);
    binarySubt = new Subt(sBinary1,sBinary2);
    treeSubt = new Subt(floatSubt, new Subt(intSubt, binarySubt));
  }

  @RepeatedTest(20)
  void testConstructor() {
    // Int constructor
    var intExpected = new Subt(sInt1,sInt2);
    var noIntExpected = new Subt(sInt2,sInt2);

    assertEquals(intExpected, intSubt);
    assertEquals(intExpected.hashCode(), intSubt.hashCode());

    assertNotEquals(noIntExpected, intSubt);
    assertNotEquals(noIntExpected.hashCode(), intSubt.hashCode());

    // Float constructor
    var floatExpected = new Subt(sFloat1,sFloat2);
    var noFloatExpected = new Subt(sFloat2,sFloat2);

    assertEquals(floatExpected, floatSubt);
    assertEquals(floatExpected.hashCode(), floatSubt.hashCode());

    assertNotEquals(noFloatExpected, floatSubt);
    assertNotEquals(noFloatExpected.hashCode(), floatSubt.hashCode());

    // Binary constructor
    var binaryExpected = new Subt(sBinary1,sBinary2);
    var noBinaryExpected = new Subt(sBinary2,sBinary2);

    assertEquals(binaryExpected, binarySubt);
    assertEquals(binaryExpected.hashCode(), binarySubt.hashCode());

    assertNotEquals(noBinaryExpected, binarySubt);
    assertNotEquals(noBinaryExpected.hashCode(), binarySubt.hashCode());

    // Complex tree constructor
    var complexExpected = new Subt(floatSubt, new Subt(intSubt, binarySubt));
    var NoComplexExpected = new Subt(intSubt, new Subt(floatSubt, intSubt));

    assertEquals(complexExpected, treeSubt);
    assertEquals(complexExpected.hashCode(), treeSubt.hashCode());

    assertNotEquals(NoComplexExpected, treeSubt);
    assertNotEquals(NoComplexExpected.hashCode(), treeSubt.hashCode());
  }

  @RepeatedTest(20)
  void testGetLeft() {
    assertEquals(sInt1, intSubt.getLeft());
    assertNotEquals(sInt2, intSubt.getLeft());

    assertEquals(sFloat1, floatSubt.getLeft());
    assertNotEquals(sFloat2, floatSubt.getLeft());

    assertEquals(sBinary1, binarySubt.getLeft());
    assertNotEquals(sBinary2, binarySubt.getLeft());

  }

  @RepeatedTest(20)
  void testGetRight() {
    assertEquals(sInt2, intSubt.getRight());
    assertNotEquals(sInt1, intSubt.getRight());

    assertEquals(sFloat2, floatSubt.getRight());
    assertNotEquals(sFloat1, floatSubt.getRight());

    assertEquals(sBinary2, binarySubt.getRight());
    assertNotEquals(sBinary1, binarySubt.getRight());
  }

  @RepeatedTest(20)
  void evaluate() {

    // Test two ints
    int exIntSubt = exampleInt1-exampleInt2;
    assertEquals(intSubt.evaluate(), new ScrabbleInt(exIntSubt));

    // Test two floats
    double exDoubleSubt = exampleFloat1-exampleFloat2;
    assertEquals(floatSubt.evaluate(), new ScrabbleFloat(exDoubleSubt));

    // Test two binaries
    int exBinAsInt1 = BinUtilities.binaryToInt(exampleBinary1);
    int exBinAsInt2 = BinUtilities.binaryToInt(exampleBinary2);
    int exBinSubt = exBinAsInt1-exBinAsInt2;
    String binSubt = BinUtilities.intToBinary(exBinSubt);
    assertEquals(binarySubt.evaluate(), new ScrabbleBinary(binSubt));

    // Test complex tree
    int firstSubt = exIntSubt-exBinSubt;
    double secondSubt = exDoubleSubt - firstSubt;
    assertEquals(treeSubt.evaluate(), new ScrabbleFloat(secondSubt));
  }
}