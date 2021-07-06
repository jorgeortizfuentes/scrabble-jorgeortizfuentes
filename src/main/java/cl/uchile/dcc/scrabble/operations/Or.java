package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleLogic;
import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Objects;

public class Or implements Operation {
  Operation left;
  Operation right;


  public Or(Operation left, Operation right) {
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
    return Objects.hash(Or.class, left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Or) {
      var o = (Or) obj;
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
    ScrabbleLogic prop1 = (ScrabbleLogic) left.evaluate();
    ScrabbleLogic prop2 = (ScrabbleLogic) right.evaluate();
    return (ScrabbleType) prop1.disjunctionWith(prop2);
  }
}
