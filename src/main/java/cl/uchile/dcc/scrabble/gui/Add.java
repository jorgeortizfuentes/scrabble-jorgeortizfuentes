package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class Add implements Operation {
  Operation left;
  Operation right;


  public Add(Operation left, Operation right) {
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
    return Objects.hash(Add.class, left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Add) {
      var o = (Add) obj;
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
    return left.evaluate().addWith(right.evaluate());
  }
}
