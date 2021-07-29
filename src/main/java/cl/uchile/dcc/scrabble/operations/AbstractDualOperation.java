package cl.uchile.dcc.scrabble.operations;

/**
 * Implementation of <i>Abstract Operation</i>.
 * <p>
 * Extends AbstractOperation having two variables: one operation on the left and one on the right
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public abstract class AbstractDualOperation extends AbstractOperation {

  /**
   * Left leaf of the tree
   */
  Operation left;

  /**
   * Right leaf of the tree
   */
  Operation right;

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
}
