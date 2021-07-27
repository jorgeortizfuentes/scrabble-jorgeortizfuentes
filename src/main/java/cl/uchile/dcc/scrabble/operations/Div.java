package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Objects;

/**
 * Implementation of <i>Division Operation</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class Div extends AbstractDualOperation implements Operation {


  /**
   * Constructor of an Division tree
   *
   * @param left  left tree object
   * @param right left tree object
   */
  public Div(Operation left, Operation right) {
    this.left = left;
    this.right = right;
  }

  /**
   * Constructor of an empty tree
   */
  public Div() {
    this.left = null;
    this.right = null;
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
    if (left == null || right == null) {
      return null;
    } else {
      return left.evaluate().divideWith(right.evaluate());
    }

  }

}
