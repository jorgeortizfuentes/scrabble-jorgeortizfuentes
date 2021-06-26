package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.ScrabbleType;

public interface Operation {

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  ScrabbleType evaluate();
}
