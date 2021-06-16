package cl.uchile.dcc.scrabble.gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void evaluate() {

    ScrabbleInt sInt1 = new ScrabbleInt(2);
    ScrabbleInt sInt2 = new ScrabbleInt(3);
    ScrabbleInt sInt3 = new ScrabbleInt(4);
    ScrabbleFloat sFloat1 = new ScrabbleFloat(2);
    ScrabbleFloat sFloat2 = new ScrabbleFloat(3);
    ScrabbleFloat sFloat3 = new ScrabbleFloat(4);
    ScrabbleBinary sBinary1 = sInt1.asBinary();
    ScrabbleBinary sBinary2 = sInt2.asBinary();
    ScrabbleBinary sBinary3 = sInt3.asBinary();


    var addTree = new Mult(
        new Mult(sBinary1,sFloat2),
        sInt3);
    System.out.println(addTree.evaluate());
  }
}