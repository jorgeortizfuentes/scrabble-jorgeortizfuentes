package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleNumber;
import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Objects;

public class Mult implements Operation {
  Operation left;
  Operation right;


  public Mult(Operation left, Operation right) {
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
    return Objects.hash(Mult.class, left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Mult) {
      var o = (Mult) obj;
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
    ScrabbleNumber multiplicant = (ScrabbleNumber) left.evaluate();
    ScrabbleNumber multiplicator = (ScrabbleNumber) right.evaluate();
    return (ScrabbleType) multiplicant.multiplyWith(multiplicator);
  }
}
