package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class Div implements Operation {
  Operation left;
  Operation right;


  public Div(Operation left, Operation right) {
    this.left = left;
    this.right = right;
  }

  /**
   * Returns the left value of the tree object
   *
   * @return left tree object
   */
  public Operation getLeft() {
    return left;
  }

  /**
   * Returns the right value of the tree object
   *
   * @return right tree object
   */
  public Operation getRight() {
    return right;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(Div.class, left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Div) {
      var o = (Div) obj;
      return o.getLeft().equals(this.left) && o.getRight().equals(this.right);
    }
    return false;
  }

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  @Override
  public ScrabbleType evaluate() {
    ScrabbleNumber dividend = (ScrabbleNumber) left.evaluate();
    ScrabbleNumber divisor = (ScrabbleNumber) right.evaluate();
    return (ScrabbleType) dividend.divideWith(divisor);
  }
}
