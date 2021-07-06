package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.operations.Operation;
import cl.uchile.dcc.scrabble.operations.Or;
import cl.uchile.dcc.scrabble.types.ScrabbleLogic;
import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Objects;

public class Negate implements Operation {
  Operation value;

  public Negate(Operation value) {
    this.value = value;
  }

  /**
   * Returns the value of the tree object
   *
   * @return tree object
   */
  public Operation getValue() {
    return value;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(Or.class, value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Or) {
      var o = (Or) obj;
      return o.getLeft().equals(this.value);
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
    ScrabbleLogic prop = (ScrabbleLogic) value.evaluate();
    return (ScrabbleType) prop.negation();
  }
}
