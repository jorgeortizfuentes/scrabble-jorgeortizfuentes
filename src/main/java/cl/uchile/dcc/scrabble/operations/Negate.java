package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Objects;

/**
 * Implementation of <i>Negate operation</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class Negate extends AbstractOperation implements Operation {

  /**
   * Unique value of the tree
   */
  Operation value;

  /**
   * Constructor of Negation Tree
   *
   * @param value tree leaf
   */
  public Negate(Operation value) {
    this.value = value;
  }

  /**
   * Returns the value of the tree object
   *
   * @return leaf object
   */
  public Operation getValue() {
    return value;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(Negate.class, value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Negate) {
      var o = (Negate) obj;
      return o.getValue().equals(this.value);
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
    if (value == null) {
      return null;
    } else {
      ScrabbleType prop = value.evaluate();
      return prop.negation();
    }

  }
}
