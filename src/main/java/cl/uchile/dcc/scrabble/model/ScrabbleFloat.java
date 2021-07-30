package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.controller.Operation;
import cl.uchile.dcc.scrabble.controller.ScrabbleFactory;
import java.util.Objects;

/**
 * Implementation of the <i>ScrabbleFloat</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleFloat extends ScrabbleAbstract implements Operation {

  /**
   * Object content with a java double
   */
  protected double content;

  /**
   * ScrabbleFloat Constructor Constructs a Float object of Scrabble cl.uchile.dcc.scrabble.type.
   *
   * @param javaDouble receives a java double for the content of the object
   */
  public ScrabbleFloat(double javaDouble) {
    this.content = javaDouble;
  }

  /**
   * Returns the value of the object content
   *
   * @return object content
   */
  public double getContent() {
    return this.content;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return Double.toString(this.content);
  }

  /**
   * {@inheritDoc}
   */
  public ScrabbleString asString() {
    String str = this.toString();
    return new ScrabbleString(str);

  }

  /**
   * Returns the object in ScrabbleFloat format.
   *
   * @return content of the object in ScrabbleFloat format
   */
  @Override
  public ScrabbleFloat asFloat() {
    return new ScrabbleFloat(this.content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(ScrabbleFloat.class, content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ScrabbleFloat) {
      var o = (ScrabbleFloat) obj;
      return o.getContent() == this.content;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType addWith(ScrabbleType c) {
    return c.addedByFloat(this);
  }

  /**
   * This object is concatenated to another object ScrabbleString.
   *
   * @param c any ScrabbleString object
   * @return a new object concatenation of both
   */
  @Override
  public ScrabbleType addedByString(ScrabbleString c) {
    String addedString = c.getContent() + this.content;
    return new ScrabbleString(addedString);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType addedByInt(ScrabbleInt c) {
    double result = c.getContent() + this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType addedByFloat(ScrabbleFloat c) {
    double result = c.getContent() + this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType subtractWith(ScrabbleType c) {
    return c.subtractedByFloat(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType subtractedByInt(ScrabbleInt c) {
    return c.asFloat().subtractWith(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType subtractedByFloat(ScrabbleFloat c) {
    double result = c.getContent() - this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType multiplyWith(ScrabbleType c) {
    return c.multipliedByFloat(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType multipliedByInt(ScrabbleInt c) {
    double result = c.getContent() * this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType multipliedByFloat(ScrabbleFloat c) {
    double result = c.getContent() * this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType divideWith(ScrabbleType c) {
    return c.dividedByFloat(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType dividedByInt(ScrabbleInt c) {
    double result = c.getContent() / this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType dividedByFloat(ScrabbleFloat c) {
    double result = c.getContent() / this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */

  @Override
  public ScrabbleType evaluate() {
    return ScrabbleFactory.getFloat(content);
  }

  /**
   * Indicates its color
   *
   * @return CSS color
   */
  @Override
  public String getColor() {
    return "MEDIUMVIOLETRED";
  }

  /**
   * Indicates a label with its abbreviation
   *
   * @return CSS color
   */
  @Override
  public String getLabel() {
    return "FLOAT";
  }
}
