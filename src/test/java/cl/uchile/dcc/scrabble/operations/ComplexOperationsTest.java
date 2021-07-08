package cl.uchile.dcc.scrabble.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cl.uchile.dcc.scrabble.types.ScrabbleFactory;
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
}