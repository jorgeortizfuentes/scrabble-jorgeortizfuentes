package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

/**
 * Implementation of the <i>ScrabbleBoolean</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleBoolean implements ScrabbleType, ScrabbleLogic, Operation {

  /**
   * Object content with a java boolean
   */
  protected boolean content;

  /**
   * ScrabbleBoolean Constructor Constructs a Boolean object of Scrabble type.
   *
   * @param javaBoolean receives a java boolean for the content of the object
   */
  public ScrabbleBoolean(boolean javaBoolean) {
    this.content = javaBoolean;
  }

  /**
   * Returns the value of the object content
   *
   * @return object content
   */
  public boolean getContent() {
    return this.content;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return Boolean.toString(this.content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleString asString() {
    String str = this.toString();
    return new ScrabbleString(str);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(ScrabbleBoolean.class, content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ScrabbleBoolean) {
      var o = (ScrabbleBoolean) obj;
      return o.getContent() == this.content;

    }
    return false;
  }

  /**
   * Returns the object in ScrabbleBoolean format.
   *
   * @return content of the object in ScrabbleBoolean format
   */
  public ScrabbleBoolean asBoolean() {
    return new ScrabbleBoolean(this.content);
  }

  /**
   * Transforms the truth value of the boolean to its opposite
   *
   * @return the opposite value of the boolean
   */
  @Override
  public ScrabbleBoolean negation() {
    return new ScrabbleBoolean(!this.content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleLogic conjunctionWith(ScrabbleLogic c) {
    return c.conjunctionByBoolean(this);
  }

  /**
   * This boolean is related according to the logical conjunction operation by another object of
   * type ScrabbleBoolean
   *
   * @param c a ScrabbleBoolean object
   * @return a new object with the conjunction between the two
   */
  @Override
  public ScrabbleLogic conjunctionByBoolean(ScrabbleBoolean c) {
    return new ScrabbleBoolean(c.getContent() && this.content);
  }

  /**
   * This boolean is related according to the logical conjunction operation by a ScrabbleBinary
   * object. The operation is applied for each value in the binary
   *
   * @param c a ScrabbleBinary object
   * @return a new object with the conjunction between the two
   */
  @Override
  public ScrabbleLogic conjunctionByBinary(ScrabbleBinary c) {
    StringBuilder newBinary = new StringBuilder();
    for (int i = 0; i < c.getContent().length(); i++) {
      if (c.getContent().charAt(i) == '0') {
        newBinary.append("0");
      } else {
        if (!this.content) {
          newBinary.append("0");
        } else {
          newBinary.append("1");
        }
      }
    }
    return new ScrabbleBinary(newBinary.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleLogic disjunctionWith(ScrabbleLogic c) {
    return c.disjunctionByBoolean(this);
  }

  /**
   * This boolean is related according to the logical disjunction operation by another object of
   * type ScrabbleBoolean
   *
   * @param c a ScrabbleBoolean object
   * @return a new object with the disjunction between the two
   */
  @Override
  public ScrabbleLogic disjunctionByBoolean(ScrabbleBoolean c) {
    return new ScrabbleBoolean(c.getContent() || this.content);
  }

  /**
   * This boolean is related according to the logical disjunction operation by a ScrabbleBinary
   * object. The operation is applied for each value in the binary
   *
   * @param c a ScrabbleBinary object
   * @return a new object with the disjunction between the two
   */
  @Override
  public ScrabbleLogic disjunctionByBinary(ScrabbleBinary c) {
    StringBuilder newBinary = new StringBuilder();
    for (int i = 0; i < c.getContent().length(); i++) {
      if (c.getContent().charAt(i) == '1') {
        newBinary.append("1");
      } else {
        if (this.content) {
          newBinary.append("1");
        } else {
          newBinary.append("0");
        }
      }
    }
    return new ScrabbleBinary(newBinary.toString());
  }

  /**
   * To this object is tried to add another object, but it is not possible
   *
   * @param c any ScrabbleType object
   * @return null
   */
  @Override
  public ScrabbleType addWith(ScrabbleType c) {
    return null;
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
   * This object is tried to add to another object ScrabbleInt, but it is not possible
   *
   * @param c any ScrabbleInt object that can be added to
   * @return null because this operation is invalid
   */
  @Override
  public ScrabbleType addedByInt(ScrabbleInt c) {
    // Invalid operation
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
    // Invalid operation
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
    // Invalid operation
    return null;
  }

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  @Override
  public ScrabbleType evaluate() {
    return new ScrabbleBoolean(content);
  }

}