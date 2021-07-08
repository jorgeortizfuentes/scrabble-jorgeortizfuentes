package cl.uchile.dcc.scrabble.operations;


import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Objects;

/**
 * Implementation of <i>Add operation</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class Add extends AbstractOperation implements Operation {

  /**
   * Left leaf of the tree
   */
  Operation left;

  /**
   * Right leaf of the tree
   */
  Operation right;

  /**
   * Constructor of an Add tree
   *
   * @param left  left tree object
   * @param right left tree object
   */
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
    if (left == null || right == null) {
      return null;
    } else {
      return left.evaluate().addWith(right.evaluate());
    }

  }


}
