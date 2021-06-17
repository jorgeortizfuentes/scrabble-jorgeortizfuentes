package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class Subt implements Operation {
  Operation left;
  Operation right;


  public Subt(Operation left, Operation right) {
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
    return Objects.hash(Subt.class, left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Subt) {
      var o = (Subt) obj;
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
    ScrabbleNumber minuend = (ScrabbleNumber) left.evaluate();
    ScrabbleNumber subtrahend = (ScrabbleNumber) right.evaluate();
    return (ScrabbleType) minuend.subtractWith(subtrahend);
  }

  public ScrabbleBinary asBinary() {
    ScrabbleNumber evaluation = (ScrabbleNumber) this.evaluate();
    return evaluation.asBinary();
  }
}
