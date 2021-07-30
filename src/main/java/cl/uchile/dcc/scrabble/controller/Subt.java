package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.model.ScrabbleType;
import java.util.Objects;

/**
 * Implementation of <i>Subtraction operation</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class Subt extends AbstractDualOperation implements Operation {


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
   * Constructor of an empty tree
   */
  public Subt() {
    this.left = null;
    this.right = null;
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

}
