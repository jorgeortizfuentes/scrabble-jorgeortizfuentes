package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cl.uchile.dcc.scrabble.operations.Div;
import cl.uchile.dcc.scrabble.types.BinUtilities;
import cl.uchile.dcc.scrabble.types.ScrabbleBinary;
import cl.uchile.dcc.scrabble.types.ScrabbleFloat;
import cl.uchile.dcc.scrabble.types.ScrabbleInt;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class DivTest {

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
  Div intDiv;
  Div floatDiv;
  Div binaryDiv;
  Div treeDiv;
  Div treeDiv2;

  @BeforeEach
  void setUp() {
    int seed = new Random().nextInt();
    Random rndm = new Random(seed);

    exampleInt1 = rndm.nextInt(1000000);
    do{
      exampleInt2 = rndm.nextInt(1000000);
    } while (exampleInt1 == exampleInt2 || exampleInt2 == 0);
    exampleFloat1 = rndm.nextDouble();
    do{
      exampleFloat2 = rndm.nextDouble();
    } while (exampleFloat1 == exampleFloat2 || exampleFloat2==0);

    exampleBinary1 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1))+1, "01");
    do{
      exampleBinary2 = RandomStringUtils.random(Math.abs(rndm.nextInt(16-1))+1, "01");

    } while (exampleBinary1.equals(exampleBinary2) || BinUtilities.binaryToInt(exampleBinary2) == 0);

    sInt1 = new ScrabbleInt(exampleInt1);
    sInt2 = new ScrabbleInt(exampleInt2);
    sFloat1 = new ScrabbleFloat(exampleFloat1);
    sFloat2 = new ScrabbleFloat(exampleFloat2);
    sBinary1 = new ScrabbleBinary(exampleBinary1);
    sBinary2 = new ScrabbleBinary(exampleBinary2);

    intDiv = new Div(sInt1,sInt2);
    floatDiv = new Div(sFloat1,sFloat2);
    binaryDiv = new Div(sBinary1,sBinary2);
    treeDiv = new Div(floatDiv, new Div(intDiv, binaryDiv));

    treeDiv2 = new Div(intDiv, new Div(floatDiv, binaryDiv));

  }

  @RepeatedTest(20)
  void testConstructor() {
    // Int constructor
    var intExpected = new Div(sInt1,sInt2);
    var noIntExpected = new Div(sInt2,sInt2);

    assertEquals(intExpected, intDiv);
    assertEquals(intExpected.hashCode(), intDiv.hashCode());

    assertNotEquals(noIntExpected, intDiv);
    assertNotEquals(noIntExpected.hashCode(), intDiv.hashCode());

    // Float constructor
    var floatExpected = new Div(sFloat1,sFloat2);
    var noFloatExpected = new Div(sFloat2,sFloat2);

    assertEquals(floatExpected, floatDiv);
    assertEquals(floatExpected.hashCode(), floatDiv.hashCode());

    assertNotEquals(noFloatExpected, floatDiv);
    assertNotEquals(noFloatExpected.hashCode(), floatDiv.hashCode());

    // Binary constructor
    var binaryExpected = new Div(sBinary1,sBinary2);
    var noBinaryExpected = new Div(sBinary2,sBinary2);

    assertEquals(binaryExpected, binaryDiv);
    assertEquals(binaryExpected.hashCode(), binaryDiv.hashCode());

    assertNotEquals(noBinaryExpected, binaryDiv);
    assertNotEquals(noBinaryExpected.hashCode(), binaryDiv.hashCode());

    // Complex tree constructor
    var complexExpected = new Div(floatDiv, new Div(intDiv, binaryDiv));
    var NoComplexExpected = new Div(intDiv, new Div(floatDiv, intDiv));

    assertEquals(complexExpected, treeDiv);
    assertEquals(complexExpected.hashCode(), treeDiv.hashCode());

    assertNotEquals(NoComplexExpected, treeDiv);
    assertNotEquals(NoComplexExpected.hashCode(), treeDiv.hashCode());
  }

  @RepeatedTest(20)
  void testGetLeft() {
    assertEquals(sInt1, intDiv.getLeft());
    assertNotEquals(sInt2, intDiv.getLeft());

    assertEquals(sFloat1, floatDiv.getLeft());
    assertNotEquals(sFloat2, floatDiv.getLeft());

    assertEquals(sBinary1, binaryDiv.getLeft());
    assertNotEquals(sBinary2, binaryDiv.getLeft());

  }

  @RepeatedTest(20)
  void testGetRight() {
    assertEquals(sInt2, intDiv.getRight());
    assertNotEquals(sInt1, intDiv.getRight());

    assertEquals(sFloat2, floatDiv.getRight());
    assertNotEquals(sFloat1, floatDiv.getRight());

    assertEquals(sBinary2, binaryDiv.getRight());
    assertNotEquals(sBinary1, binaryDiv.getRight());
  }

  @RepeatedTest(100)
  void evaluate() {

    // Test two ints
    int exIntDiv = exampleInt1/exampleInt2;
    assertEquals(intDiv.evaluate(), new ScrabbleInt(exIntDiv));

    // Test two floats
    double exDoubleDiv = exampleFloat1/exampleFloat2;
    assertEquals(floatDiv.evaluate(), new ScrabbleFloat(exDoubleDiv));

    // Test two binaries
    int exBinAsInt1 = BinUtilities.binaryToInt(exampleBinary1);
    int exBinAsInt2 = BinUtilities.binaryToInt(exampleBinary2);
    int exBinDiv = exBinAsInt1/exBinAsInt2;
    String binDiv = BinUtilities.intToBinary(exBinDiv);
    assertEquals(binaryDiv.evaluate(), new ScrabbleBinary(binDiv));

    // Test complex tree
    double firstDiv = exDoubleDiv / exBinDiv;
    System.out.println(exIntDiv);
    System.out.println(exBinDiv);
    System.out.println(firstDiv);
    double secondDiv = exIntDiv / firstDiv;
    System.out.println(exDoubleDiv);
    assertEquals(treeDiv2.evaluate(), new ScrabbleFloat(secondDiv));
  }
}