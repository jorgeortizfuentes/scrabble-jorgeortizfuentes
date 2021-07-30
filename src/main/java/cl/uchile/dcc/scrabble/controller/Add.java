package cl.uchile.dcc.scrabble.controller;


import cl.uchile.dcc.scrabble.model.ScrabbleType;
import java.util.Objects;

/**
 * Implementation of <i>Add operation</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class Add extends AbstractDualOperation implements Operation {


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
   * Constructor of an empty tree
   */
  public Add() {
    this.left = null;
    this.right = null;
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
    if (this.left == null || this.right == null) {
      return null;
    } else {
      return left.evaluate().addWith(right.evaluate());
    }

  }


}
