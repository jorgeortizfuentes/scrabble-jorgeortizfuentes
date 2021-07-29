package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.operations.Operation;
import java.util.Objects;

/**
 * Implementation of the <i>ScrabbleBoolean</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleBoolean extends ScrabbleAbstract implements Operation {

  /**
   * Object content with a java boolean
   */
  protected boolean content;

  /**
   * ScrabbleBoolean Constructor Constructs a Boolean object of Scrabble
   * cl.uchile.dcc.scrabble.type.
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
  public ScrabbleType conjunctionWith(ScrabbleType c) {
    return c.conjunctionByBoolean(this);
  }

  /**
   * This boolean is related according to the logical conjunction operation by another object of
   * cl.uchile.dcc.scrabble.type ScrabbleBoolean
   *
   * @param c a ScrabbleBoolean object
   * @return a new object with the conjunction between the two
   */
  @Override
  public ScrabbleType conjunctionByBoolean(ScrabbleBoolean c) {
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
  public ScrabbleType conjunctionByBinary(ScrabbleBinary c) {
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
  public ScrabbleType disjunctionWith(ScrabbleType c) {
    return c.disjunctionByBoolean(this);
  }

  /**
   * This boolean is related according to the logical disjunction operation by another object of
   * cl.uchile.dcc.scrabble.type ScrabbleBoolean
   *
   * @param c a ScrabbleBoolean object
   * @return a new object with the disjunction between the two
   */
  @Override
  public ScrabbleType disjunctionByBoolean(ScrabbleBoolean c) {
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
  public ScrabbleType disjunctionByBinary(ScrabbleBinary c) {
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
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  @Override
  public ScrabbleType evaluate() {
    return ScrabbleFactory.getBoolean(content);
  }

  /**
   * Indicates its color
   *
   * @return CSS color
   */
  @Override
  public String getColor() {
    return "MAROON";
  }

  /**
   * Indicates a label with its abbreviation
   *
   * @return CSS color
   */
  @Override
  public String getLabel() {
    return "BOOL";
  }
}