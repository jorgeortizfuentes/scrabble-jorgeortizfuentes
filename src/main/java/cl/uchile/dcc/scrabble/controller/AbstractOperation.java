package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.model.ScrabbleBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleBoolean;
import cl.uchile.dcc.scrabble.model.ScrabbleFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleInt;
import cl.uchile.dcc.scrabble.model.ScrabbleString;
import cl.uchile.dcc.scrabble.model.ScrabbleType;

/**
 * Implementation of <i>Abstract Operation</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public abstract class AbstractOperation implements Operation {

  /**
   * Evaluate the operation and return the result in ScrabbleBinary format.
   *
   * @return content the result in ScrabbleBinary format
   */
  @Override
  public ScrabbleBinary asBinary() {
    ScrabbleType evaluation = this.evaluate();
    if (evaluation == null) {
      return null;
    } else {
      return evaluation.asBinary();
    }

  }

  /**
   * Evaluate the operation and return the result in ScrabbleFloat format.
   *
   * @return content the result in ScrabbleFloat format
   */
  @Override
  public ScrabbleFloat asFloat() {
    ScrabbleType evaluation = this.evaluate();
    if (evaluation == null) {
      return null;
    } else {
      return evaluation.asFloat();
    }

  }

  /**
   * Evaluate the operation and return the result in ScrabbleString format.
   *
   * @return content the result in ScrabbleString format
   */
  @Override
  public ScrabbleString asString() {
    ScrabbleType evaluation = this.evaluate();
    if (evaluation == null) {
      return null;
    } else {
      return evaluation.asString();
    }

  }

  /**
   * Evaluate the operation and return the result in ScrabbleBoolean format.
   *
   * @return content the result in ScrabbleBoolean format
   */
  @Override
  public ScrabbleBoolean asBoolean() {
    ScrabbleType evaluation = this.evaluate();
    if (evaluation == null) {
      return null;
    } else {
      return evaluation.asBoolean();
    }

  }

  /**
   * Evaluate the operation and return the result in ScrabbleInt format.
   *
   * @return content the result in ScrabbleInt format
   */
  @Override
  public ScrabbleInt asInt() {
    ScrabbleType evaluation = this.evaluate();
    if (evaluation == null) {
      return null;
    } else {
      return evaluation.asInt();
    }
  }


  /**
   * Indicates its color
   *
   * @return CSS color
   */
  @Override
  public String getColor() {
    return null;
  }

  /**
   * Indicates a label with its abbreviation
   *
   * @return CSS color
   */
  @Override
  public String getLabel() {
    return null;
  }
}
