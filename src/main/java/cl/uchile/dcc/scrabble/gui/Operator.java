package cl.uchile.dcc.scrabble.gui;

public class Operator implements Operation {
  Operation info;

  public Operator(Operation info) {
    this.info = info;
  }

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  @Override
  public ScrabbleType evaluate() {
    return null;
  }
}
