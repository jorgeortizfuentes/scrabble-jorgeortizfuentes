package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Objects;

/**
 * Implementation of <i>Subtraction operation</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class Subt extends AbstractOperation implements Operation {

  /**
   * Left leaf of the tree
   */
  Operation left;

  /**
   * Right leaf of the tree
   */
  Operation right;

  /**
   * Constructor of an Subtraction Tree
   *
   * @param left  left tree object
   * @param right left tree object
   */
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
    if (left == null || right == null) {
      return null;
    } else {
      return left.evaluate().subtractWith(right.evaluate());
    }

  }

  /**
   * Indicates whether the tree and its leaves are complete.
   *
   * @return true or false
   */
  @Override
  public boolean isComplete() {
    if (this.left == null || this.right == null) {
      return false;
    } else {
      return this.left.isComplete() && this.right.isComplete();
    }
  }

  /**
   * Adds a value or an operation to the first empty node on the left
   *
   * @param v value
   */
  //@Override
  public void setValues(Operation v) {
    if (this.left == null) {
      this.left = v;
    } else if (!this.left.isComplete()) {
      this.left.setValues(v);

    } else if (this.right == null) {
      this.right = v;

    } else if (!this.right.isComplete()) {
      this.right.setValues(v);
    }
  }
}
