package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

/**
 * Implementation of the <i>ScrabbleFloat</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleFloat implements ScrabbleType, ScrabbleNumber, Operation {

  /**
   * Object content with a java double
   */
  protected double content;

  /**
   * ScrabbleFloat Constructor Constructs a Float object of Scrabble type.
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
  public ScrabbleFloat asFloat() {
    return new ScrabbleFloat(this.content);
  }

  /**
   * Attempts to convert object to binary but fails because the transformation is wrong.
   *
   * @return null
   */
  @Override
  public ScrabbleBinary asBinary() {
    return null;
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
   * Another object tries to added this object, but it is not possible to
   *
   * @param c any ScrabbleBinary object
   * @return null because it is not possible to
   */
  @Override
  public ScrabbleType addedByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber subtractWith(ScrabbleNumber c) {
    return c.subtractedByFloat(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber subtractedByInt(ScrabbleInt c) {
    return c.asFloat().subtractWith(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber subtractedByFloat(ScrabbleFloat c) {
    double result = c.getContent() - this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * Another object tries to subtracted this object, but it is not possible to
   *
   * @param c any ScrabbleBinary object
   * @return null because it is not possible to
   */
  @Override
  public ScrabbleNumber subtractedByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber multiplyWith(ScrabbleNumber c) {
    return c.multipliedByFloat(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber multipliedByInt(ScrabbleInt c) {
    double result = c.getContent() * this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber multipliedByFloat(ScrabbleFloat c) {
    double result = c.getContent() * this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * Another object tries to multiply this object, but it is not possible to
   *
   * @param c any ScrabbleBinary object
   * @return null because it is not possible to
   */
  @Override
  public ScrabbleNumber multipliedByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber divideWith(ScrabbleNumber c) {
    return c.dividedByFloat(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber dividedByInt(ScrabbleInt c) {
    double result = c.getContent() / this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber dividedByFloat(ScrabbleFloat c) {
    double result = c.getContent() / this.content;
    return new ScrabbleFloat(result);
  }

  /**
   * Another object tries to divide this object, but it is not possible to
   *
   * @param c any ScrabbleBinary object
   * @return null because it is not possible to
   */
  @Override
  public ScrabbleNumber dividedByBinary(ScrabbleBinary c) {
    return null;
  }



  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */

  @Override
  public ScrabbleType evaluate() {
    return new ScrabbleFloat(content);
  }

}
