package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

/**
 * Implementation of the <i>ScrabbleString</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleString implements ScrabbleType {

  /**
   * Object content with a java string
   */
  protected String content;

  /**
   * ScrabbleString Constructor Constructs a String object of Scrabble type.
   *
   * @param javaStr receives a java string for the content of the object
   */
  public ScrabbleString(String javaStr) {
    this.content = javaStr;
  }

  /**
   * Returns the value of the object content
   *
   * @return object content
   */
  public String getContent() {
    return this.content;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return this.content;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleString asString() {
    return new ScrabbleString(this.content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(ScrabbleString.class, content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ScrabbleString) {
      var o = (ScrabbleString) obj;
      return o.getContent().equals(this.content);
    }
    return false;
  }

  /**
   * To this object is concatenated another object ScrabbleType c
   *
   * @param c any ScrabbleType object that can be concatenated to
   * @return a new object with the concatenation of both
   */
  @Override
  public ScrabbleType addWith(ScrabbleType c) {
    return c.addedByString(this);
  }

  /**
   * This object is concatenated to another object ScrabbleString.
   *
   * @param c any ScrabbleString object that can be concatenated to
   * @return a new object concatenation of both
   */
  @Override
  public ScrabbleType addedByString(ScrabbleString c) {
    String addedString = c.getContent() + this.content;
    return new ScrabbleString(addedString);
  }

  /**
   * This object is tried to add to another object ScrabbleInt, but it is not possible
   *
   * @param c any ScrabbleInt object that can be added to
   * @return null because this operation is invalid
   */
  @Override
  public ScrabbleType addedByInt(ScrabbleInt c) {
    return null;
  }

  /**
   * This object is tried to add to another object ScrabbleFloat, but it is not possible
   *
   * @param c any ScrabbleFloat object that can be added to
   * @return null because this operation is invalid
   */
  @Override
  public ScrabbleType addedByFloat(ScrabbleFloat c) {
    return null;
  }

  /**
   * This object is tried to add to another object ScrabbleBinary, but it is not possible
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return null because this operation is invalid
   */
  @Override
  public ScrabbleType addedByBinary(ScrabbleBinary c) {
    return null;
  }

}
