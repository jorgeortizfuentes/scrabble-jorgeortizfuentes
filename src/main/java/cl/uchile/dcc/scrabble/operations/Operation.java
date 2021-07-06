package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleType;

public interface Operation {

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  ScrabbleType evaluate();
}
