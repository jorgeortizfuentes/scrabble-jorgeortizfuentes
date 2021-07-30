package cl.uchile.dcc.scrabble.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComplexOperationsTest {

  @Test
  void evaluate() {
    var tree1 = new Add(
        ScrabbleFactory.getFloat(6.9),
        new Or(
            ScrabbleFactory.getBinary("1000"),
            new Subt(
                ScrabbleFactory.getInt(25),
                ScrabbleFactory.getBinary("0101")
            ).asBinary())
    );

    var expected1 = ScrabbleFactory.getFloat(34.9);
    assertEquals(expected1, tree1.evaluate());

    var tree2 = new Add(ScrabbleFactory.getInt(2), new Var("x"));
    Var.assign("x", ScrabbleFactory.getInt(1));
    var expected2 = ScrabbleFactory.getInt(3);

    assertEquals(expected2, tree2.evaluate());


  }

  @Test
  void isComplete() {
    var tree1 = new Add();
    assertFalse(tree1.isComplete());

    var tree2 = new Add(ScrabbleFactory.getInt(1), ScrabbleFactory.getInt(2));
    assertTrue(tree2.isComplete());

  }

  @Test
  void setValues() {
    var tree1 = new Add();

    var int1 = ScrabbleFactory.getInt(1);
    var int2 = ScrabbleFactory.getInt(2);

    tree1.setValues(int1);
    tree1.setValues(int2);

    var tree2 = new Add(int1, int2);


    Assertions.assertThrows(AssertionError.class, () -> {
      ScrabbleFactory.getInt(1).setValues(ScrabbleFactory.getInt(2));
    });


  }
}