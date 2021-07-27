package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Objects;

/**
 * Implementation of <i>And operation</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class And extends AbstractDualOperation implements Operation {

  /**
   * Constructor of an And tree
   *
   * @param left  left tree object
   * @param right left tree object
   */
  public And(Operation left, Operation right) {
    this.left = left;
    this.right = right;
  }

  /**
   * Constructor of an empty tree
   */
  public And() {
    this.left = null;
    this.right = null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(And.class, left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof And) {
      var o = (And) obj;
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
      return left.evaluate().conjunctionWith(right.evaluate());
    }

  }

}
