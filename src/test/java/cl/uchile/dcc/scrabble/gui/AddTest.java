package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class AddTest {

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
  Add intAdd;
  Add floatAdd;
  Add binaryAdd;
  Add treeAdd;

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

    intAdd = new Add(sInt1,sInt2);
    floatAdd = new Add(sFloat1,sFloat2);
    binaryAdd = new Add(sBinary1,sBinary2);
    treeAdd = new Add(floatAdd, new Add(intAdd, binaryAdd));
  }

  @RepeatedTest(20)
  void testConstructor() {
    // Int constructor
    var intExpected = new Add(sInt1,sInt2);
    var noIntExpected = new Add(sInt2,sInt2);

    assertEquals(intExpected, intAdd);
    assertEquals(intExpected.hashCode(), intAdd.hashCode());

    assertNotEquals(noIntExpected, intAdd);
    assertNotEquals(noIntExpected.hashCode(), intAdd.hashCode());

    // Float constructor
    var floatExpected = new Add(sFloat1,sFloat2);
    var noFloatExpected = new Add(sFloat2,sFloat2);

    assertEquals(floatExpected, floatAdd);
    assertEquals(floatExpected.hashCode(), floatAdd.hashCode());

    assertNotEquals(noFloatExpected, floatAdd);
    assertNotEquals(noFloatExpected.hashCode(), floatAdd.hashCode());

    // Binary constructor
    var binaryExpected = new Add(sBinary1,sBinary2);
    var noBinaryExpected = new Add(sBinary2,sBinary2);

    assertEquals(binaryExpected, binaryAdd);
    assertEquals(binaryExpected.hashCode(), binaryAdd.hashCode());

    assertNotEquals(noBinaryExpected, binaryAdd);
    assertNotEquals(noBinaryExpected.hashCode(), binaryAdd.hashCode());

    // Complex tree constructor
    var complexExpected = new Add(floatAdd, new Add(intAdd, binaryAdd));
    var NoComplexExpected = new Add(intAdd, new Add(floatAdd, intAdd));

    assertEquals(complexExpected, treeAdd);
    assertEquals(complexExpected.hashCode(), treeAdd.hashCode());

    assertNotEquals(NoComplexExpected, treeAdd);
    assertNotEquals(NoComplexExpected.hashCode(), treeAdd.hashCode());
  }

  @RepeatedTest(20)
  void testGetLeft() {
    assertEquals(sInt1, intAdd.getLeft());
    assertNotEquals(sInt2, intAdd.getLeft());

    assertEquals(sFloat1, floatAdd.getLeft());
    assertNotEquals(sFloat2, floatAdd.getLeft());

    assertEquals(sBinary1, binaryAdd.getLeft());
    assertNotEquals(sBinary2, binaryAdd.getLeft());

  }

  @RepeatedTest(20)
  void testGetRight() {
    assertEquals(sInt2, intAdd.getRight());
    assertNotEquals(sInt1, intAdd.getRight());

    assertEquals(sFloat2, floatAdd.getRight());
    assertNotEquals(sFloat1, floatAdd.getRight());

    assertEquals(sBinary2, binaryAdd.getRight());
    assertNotEquals(sBinary1, binaryAdd.getRight());
  }

  @RepeatedTest(20)
  void evaluate() {

    // Test two ints
    int exIntAdd = exampleInt1+ exampleInt2;
    assertEquals(intAdd.evaluate(), new ScrabbleInt(exIntAdd));

    // Test two floats
    double exDoubleAdd = exampleFloat1 + exampleFloat2;
    assertEquals(floatAdd.evaluate(), new ScrabbleFloat(exDoubleAdd));

    // Test two binaries
    int exBinAsInt1 = BinUtilities.binaryToInt(exampleBinary1);
    int exBinAsInt2 = BinUtilities.binaryToInt(exampleBinary2);
    int exBinAdd = exBinAsInt1 + exBinAsInt2;
    String binAdd = BinUtilities.intToBinary(exBinAdd);
    assertEquals(binaryAdd.evaluate(), new ScrabbleBinary(binAdd));

    // Test complex tree
    int firstAdd = exIntAdd + exBinAdd;
    double secondAdd = exDoubleAdd + firstAdd;
    assertEquals(treeAdd.evaluate(), new ScrabbleFloat(secondAdd));

    // Test with Strings
  }
}