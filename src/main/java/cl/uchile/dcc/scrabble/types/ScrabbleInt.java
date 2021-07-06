package cl.uchile.dcc.scrabble.types;

import cl.uchile.dcc.scrabble.operations.Operation;
import java.util.Objects;

/**
 * Implementation of the <i>ScrabbleInt</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleInt implements ScrabbleType, ScrabbleNumber, Operation {

  /**
   * Object content with a java int
   */
  protected int content;

  /**
   * ScrabbleInt Constructor Constructs a Int object of Scrabble type.
   *
   * @param javaInt receives a java int for the content of the object
   */
  public ScrabbleInt(int javaInt) {
    this.content = javaInt;
  }

  /**
   * Returns the value of the object content
   *
   * @return object content
   */
  public int getContent() {
    return this.content;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return Integer.toString(this.content);
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
    double n_float = this.content;
    return new ScrabbleFloat(n_float);
  }

  /**
   * Returns the object in ScrabbleInt format.
   *
   * @return content of the object in ScrabbleInt format
   */
  public ScrabbleInt asInt() {
    return new ScrabbleInt(this.content);
  }

  /**
   * Returns the object in ScrabbleBinary format.
   *
   * @return content of the object in ScrabbleBinary format
   */
  public ScrabbleBinary asBinary() {
    String b_int = BinUtilities.intToBinary(this.content);
    return new ScrabbleBinary(b_int);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(ScrabbleInt.class, content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ScrabbleInt) {
      var o = (ScrabbleInt) obj;
      return o.getContent() == this.content;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType addWith(ScrabbleType c) {
    return c.addedByInt(this);
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
    int result = c.getContent() + this.content;
    return new ScrabbleInt(result);
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
   * This object is added to another object ScrabbleBinary. For this purpose, the binary object is
   * transformed to an int
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the sum of both
   */
  @Override
  public ScrabbleType addedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt = c.asInt();
    int binaryInt = binarySInt.getContent();
    int result = binaryInt + this.content;
    String stringBinarySum = BinUtilities.intToBinary(result);
    return new ScrabbleBinary(stringBinarySum);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber subtractWith(ScrabbleNumber c) {
    return c.subtractedByInt(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber subtractedByInt(ScrabbleInt c) {
    int result = c.getContent() - this.content;
    return new ScrabbleInt(result);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber subtractedByFloat(ScrabbleFloat c) {

    double subtraction = c.asFloat().getContent() - this.content;
    System.out.println(subtraction);
    return new ScrabbleFloat(subtraction);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber subtractedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt = c.asInt();
    int binaryInt = binarySInt.getContent();
    int result = binaryInt - this.content;
    String stringBinarySum = BinUtilities.intToBinary(result);
    return new ScrabbleBinary(stringBinarySum);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber multiplyWith(ScrabbleNumber c) {
    return c.multipliedByInt(this);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber multipliedByInt(ScrabbleInt c) {
    int result = c.getContent() * this.content;
    return new ScrabbleInt(result);
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
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber multipliedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt = c.asInt();
    int binaryInt = binarySInt.getContent();
    int result = binaryInt * this.content;
    String stringBinarySum = BinUtilities.intToBinary(result);
    return new ScrabbleBinary(stringBinarySum);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber divideWith(ScrabbleNumber c) {
    return c.dividedByInt(this);
  }

  /**
   * This object is divided to another object ScrabbleInt. The result is rounded.
   *
   * @param c any ScrabbleInt object that can be divided to
   * @return a new object with the quotient of both
   */
  @Override
  public ScrabbleNumber dividedByInt(ScrabbleInt c) {
    int result = Math.round(c.getContent() / this.content);
    return new ScrabbleInt(result);
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
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber dividedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt = c.asInt();
    int binaryInt = binarySInt.getContent();
    int result = binaryInt / this.content;
    String stringBinarySum = BinUtilities.intToBinary(result);
    return new ScrabbleBinary(stringBinarySum);
  }

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  @Override
  public ScrabbleType evaluate() {
    return new ScrabbleInt(content);
  }

}
