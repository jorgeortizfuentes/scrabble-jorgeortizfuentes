package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class MultTest {

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
  Mult intMult;
  Mult floatMult;
  Mult binaryMult;
  Mult treeMult;

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

    intMult = new Mult(sInt1,sInt2);
    floatMult = new Mult(sFloat1,sFloat2);
    binaryMult = new Mult(sBinary1,sBinary2);
    treeMult = new Mult(floatMult, new Mult(intMult, binaryMult));
  }

  @RepeatedTest(20)
  void testConstructor() {
    // Int constructor
    var intExpected = new Mult(sInt1,sInt2);
    var noIntExpected = new Mult(sInt2,sInt2);

    assertEquals(intExpected, intMult);
    assertEquals(intExpected.hashCode(), intMult.hashCode());

    assertNotEquals(noIntExpected, intMult);
    assertNotEquals(noIntExpected.hashCode(), intMult.hashCode());

    // Float constructor
    var floatExpected = new Mult(sFloat1,sFloat2);
    var noFloatExpected = new Mult(sFloat2,sFloat2);

    assertEquals(floatExpected, floatMult);
    assertEquals(floatExpected.hashCode(), floatMult.hashCode());

    assertNotEquals(noFloatExpected, floatMult);
    assertNotEquals(noFloatExpected.hashCode(), floatMult.hashCode());

    // Binary constructor
    var binaryExpected = new Mult(sBinary1,sBinary2);
    var noBinaryExpected = new Mult(sBinary2,sBinary2);

    assertEquals(binaryExpected, binaryMult);
    assertEquals(binaryExpected.hashCode(), binaryMult.hashCode());

    assertNotEquals(noBinaryExpected, binaryMult);
    assertNotEquals(noBinaryExpected.hashCode(), binaryMult.hashCode());

    // Complex tree constructor
    var complexExpected = new Mult(floatMult, new Mult(intMult, binaryMult));
    var NoComplexExpected = new Mult(intMult, new Mult(floatMult, intMult));

    assertEquals(complexExpected, treeMult);
    assertEquals(complexExpected.hashCode(), treeMult.hashCode());

    assertNotEquals(NoComplexExpected, treeMult);
    assertNotEquals(NoComplexExpected.hashCode(), treeMult.hashCode());
  }

  @RepeatedTest(20)
  void testGetLeft() {
    assertEquals(sInt1, intMult.getLeft());
    assertNotEquals(sInt2, intMult.getLeft());

    assertEquals(sFloat1, floatMult.getLeft());
    assertNotEquals(sFloat2, floatMult.getLeft());

    assertEquals(sBinary1, binaryMult.getLeft());
    assertNotEquals(sBinary2, binaryMult.getLeft());

  }

  @RepeatedTest(20)
  void testGetRight() {
    assertEquals(sInt2, intMult.getRight());
    assertNotEquals(sInt1, intMult.getRight());

    assertEquals(sFloat2, floatMult.getRight());
    assertNotEquals(sFloat1, floatMult.getRight());

    assertEquals(sBinary2, binaryMult.getRight());
    assertNotEquals(sBinary1, binaryMult.getRight());
  }

  @RepeatedTest(20)
  void evaluate() {

    // Test two ints
    int exIntMult = exampleInt1*exampleInt2;
    assertEquals(intMult.evaluate(), new ScrabbleInt(exIntMult));

    // Test two floats
    double exDoubleMult = exampleFloat1*exampleFloat2;
    assertEquals(floatMult.evaluate(), new ScrabbleFloat(exDoubleMult));

    // Test two binaries
    int exBinAsInt1 = BinUtilities.binaryToInt(exampleBinary1);
    int exBinAsInt2 = BinUtilities.binaryToInt(exampleBinary2);
    int exBinMult = exBinAsInt1*exBinAsInt2;
    String productBin = BinUtilities.intToBinary(exBinMult);
    assertEquals(binaryMult.evaluate(), new ScrabbleBinary(productBin));

    // Test complex tree
    int firstMult = exIntMult*exBinMult;
    double secondMult = firstMult * exDoubleMult;
    assertEquals(treeMult.evaluate(), new ScrabbleFloat(secondMult));
  }
}