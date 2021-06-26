package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperatorTest {

  int exampleInt1;
  int exampleInt2;
  double exampleFloat1;
  double exampleFloat2;
  String exampleBinary1;
  String exampleBinary2;
  boolean exampleBoolean1;
  boolean exampleBoolean2;
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

    exampleBoolean1 = rndm.nextBoolean();
    do{
      exampleBoolean2 = rndm.nextBoolean();
    } while (exampleBoolean1 == exampleBoolean2);

    sInt1 = new ScrabbleInt(exampleInt1);
    sInt2 = new ScrabbleInt(exampleInt2);
    sFloat1 = new ScrabbleFloat(exampleFloat1);
    sFloat2 = new ScrabbleFloat(exampleFloat2);
    sBinary1 = new ScrabbleBinary(exampleBinary1);
    sBinary2 = new ScrabbleBinary(exampleBinary2);
    sBool1 = new ScrabbleBoolean(exampleBoolean1);
    sBool2 = new ScrabbleBoolean(exampleBoolean2);

  }

  @Test
  void evaluate() {
    // Pendiente, no alcancé
    var tree = new Add(
        sFloat1,
        new Or(
            sBinary1,
            new Subt(
                sInt1,
                sBinary2
            ).asBinary())
    );

    var tree1 = new Subt(
            sInt1,
            sBinary2
        ).asBinary();
    tree1.evaluate();





  }

}