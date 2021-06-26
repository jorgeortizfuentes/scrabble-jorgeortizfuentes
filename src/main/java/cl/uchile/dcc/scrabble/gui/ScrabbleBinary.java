package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of the <i>ScrabbleBinary</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleBinary implements ScrabbleType, ScrabbleLogic, ScrabbleNumber {

  /**
   * Object content with a java string
   */
  protected String content;

  /**
   * ScrabbleBinary Constructor Constructs a Binary object of Scrabble type.
   *
   * @param javaBinary receives a java binary for the content of the object
   */
  public ScrabbleBinary(String javaBinary) {

    Pattern pattern = Pattern.compile("[^0-1]");
    Matcher matcher = pattern.matcher(javaBinary);
    boolean isBinary = !matcher.find();
    if (!isBinary) {
      throw new AssertionError("The string is not a binary.");
    }
    this.content = javaBinary;
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
    return Objects.hash(ScrabbleBinary.class, content);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ScrabbleBinary) {
      var o = (ScrabbleBinary) obj;
      return o.getContent().equals(this.content);
    }
    return false;
  }

  /**
   * Returns the object in ScrabbleInt format.
   *
   * @return content of the object in ScrabbleInt format
   */
  public ScrabbleInt asInt() {
    int binInt = BinUtilities.binaryToInt(this.content);
    return new ScrabbleInt(binInt);
  }

  /**
   * Returns the object in ScrabbleBinary format.
   *
   * @return content of the object in ScrabbleBinary format
   */
  public ScrabbleBinary asBinary() {
    return new ScrabbleBinary(this.content);
  }

  /**
   * Transforms each number from binary to its opposite
   *
   * @return the negation of the binary (all 1's are 0's and all 0's are 1's)
   */
  @Override
  public ScrabbleBinary negation() {
    StringBuilder newContent = new StringBuilder();
    for (int i = 0; i < this.content.length(); i++) {
      if (this.content.charAt(i) == '0') {
        newContent.append("1");
      } else {
        newContent.append("0");
      }

    }
    return new ScrabbleBinary(newContent.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleLogic conjunctionWith(ScrabbleLogic c) {
    return c.conjunctionByBinary(this);
  }

  /**
   * This binary is related according to the logical conjunction operation by a ScrabbleBoolean
   * object. The operation is applied for each value in the binary
   *
   * @param c a ScrabbleBoolean object
   * @return a new object with the conjunction between the two
   */
  @Override
  public ScrabbleLogic conjunctionByBoolean(ScrabbleBoolean c) {
    StringBuilder newBinary = new StringBuilder();
    for (int i = 0; i < this.content.length(); i++) {
      if (this.content.charAt(i) == '0') {
        newBinary.append("0");
      } else {
        if (!c.getContent()) {
          newBinary.append("0");
        } else {
          newBinary.append("1");
        }
      }
    }
    return new ScrabbleBinary(newBinary.toString());
  }

  /**
   * This binary is tried to operate according to the conjunction operation
   *
   * @param c a ScrabbleBinary object
   * @return null
   */
  @Override
  public ScrabbleLogic conjunctionByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleLogic disjunctionWith(ScrabbleLogic c) {
    return c.disjunctionByBinary(this);
  }

  /**
   * This binary is related according to the logical disjunction operation by a ScrabbleBoolean
   * object. The operation is applied for each value in the binary
   *
   * @param c a ScrabbleBoolean object
   * @return a new object with the disjunction between the two
   */
  @Override
  public ScrabbleLogic disjunctionByBoolean(ScrabbleBoolean c) {
    StringBuilder newBinary = new StringBuilder();
    for (int i = 0; i < this.content.length(); i++) {
      if (this.content.charAt(i) == '1') {
        newBinary.append("1");
      } else {
        if (c.getContent()) {
          newBinary.append("1");
        } else {
          newBinary.append("0");
        }
      }
    }
    return new ScrabbleBinary(newBinary.toString());
  }

  /**
   * This binary is related according to the logical disjunction operation by a ScrabbleBoolean
   * object. The operation is applied for each value in the binary
   *
   * @param c a ScrabbleBoolean object
   * @return a new object with the disjunction between the two
   */
  @Override
  public ScrabbleLogic disjunctionByBinary(ScrabbleBinary c) {
    // Invalid operation
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType addWith(ScrabbleType c) {
    return c.addedByBinary(this);
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
   * This object is added to another object ScrabbleInt. For this purpose, the binary object is
   * transformed to an int
   *
   * @param c any ScrabbleInt object that can be added to
   * @return a new object with the sum of both
   */
  @Override
  public ScrabbleType addedByInt(ScrabbleInt c) {
    ScrabbleInt binarySInt = this.asInt();
    int binaryInt = binarySInt.getContent();
    int result = binaryInt + c.getContent();
    return new ScrabbleInt(result);
  }

  /**
   * This object is added to another object ScrabbleBinary. For this purpose, the binary object is
   * transformed to an int and subsequently to a float
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the sum of both
   */
  @Override
  public ScrabbleType addedByFloat(ScrabbleFloat c) {
    ScrabbleInt binarySInt = this.asInt();
    int binaryInt = binarySInt.getContent();
    double result = binaryInt + c.getContent();
    return new ScrabbleFloat(result);
  }

  /**
   * This object is added to another object ScrabbleBinary. For this purpose, both binary objects
   * are transformed to an int
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the sum of both
   */
  @Override
  public ScrabbleType addedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt1 = this.asInt();
    int binaryInt1 = binarySInt1.getContent();
    ScrabbleInt binarySInt2 = c.asInt();
    int binaryInt2 = binarySInt2.getContent();
    int result = binaryInt1 + binaryInt2;
    String stringBinarySum = BinUtilities.intToBinary(result);
    return new ScrabbleBinary(stringBinarySum);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber subtractWith(ScrabbleNumber c) {
    return c.subtractedByBinary(this);
  }

  /**
   * This object is subtracted to another object ScrabbleInt. For this purpose, the binary object is
   * transformed to an int
   *
   * @param c any ScrabbleInt object that can be added to
   * @return a new object with the subtract of both
   */
  @Override
  public ScrabbleNumber subtractedByInt(ScrabbleInt c) {
    ScrabbleInt binarySInt = this.asInt();
    int binaryInt = binarySInt.getContent();
    int result = c.getContent() - binaryInt;
    return new ScrabbleInt(result);
  }

  /**
   * This object is subtracted to another object ScrabbleBinary. For this purpose, the binary object
   * is transformed to an int and subsequently to a float
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the subtract of both
   */
  @Override
  public ScrabbleNumber subtractedByFloat(ScrabbleFloat c) {
    ScrabbleInt binarySInt = this.asInt();
    int binaryInt = binarySInt.getContent();
    double result = c.getContent() - binaryInt;
    return new ScrabbleFloat(result);
  }

  /**
   * This object is subtracted to another object ScrabbleBinary. For this purpose, both binary
   * objects are transformed to an int
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the subtract of both
   */
  @Override
  public ScrabbleNumber subtractedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt1 = this.asInt();
    int binaryInt1 = binarySInt1.getContent();
    ScrabbleInt binarySInt2 = c.asInt();
    int binaryInt2 = binarySInt2.getContent();
    int result = binaryInt2 - binaryInt1;
    String stringBinarySum = BinUtilities.intToBinary(result);
    return new ScrabbleBinary(stringBinarySum);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber multiplyWith(ScrabbleNumber c) {
    return c.multipliedByBinary(this);
  }

  /**
   * This object is multiplied to another object ScrabbleInt. For this purpose, the binary object is
   * transformed to an int
   *
   * @param c any ScrabbleInt object that can be added to
   * @return a new object with the multiplication of both
   */
  @Override
  public ScrabbleNumber multipliedByInt(ScrabbleInt c) {
    ScrabbleInt binarySInt = this.asInt();
    int binaryInt = binarySInt.getContent();
    int result = c.getContent() * binaryInt;
    return new ScrabbleInt(result);
  }

  /**
   * This object is multiplied to another object ScrabbleBinary. For this purpose, the binary object
   * is transformed to an int and subsequently to a float
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the product of both
   */
  @Override
  public ScrabbleNumber multipliedByFloat(ScrabbleFloat c) {
    ScrabbleInt binarySInt = this.asInt();
    int binaryInt = binarySInt.getContent();
    double result = c.getContent() * binaryInt;
    return new ScrabbleFloat(result);
  }

  /**
   * This object is multiplied to another object ScrabbleBinary. For this purpose, both binary
   * objects are transformed to an int
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the multiplication of both
   */
  @Override
  public ScrabbleNumber multipliedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt1 = this.asInt();
    int binaryInt1 = binarySInt1.getContent();
    ScrabbleInt binarySInt2 = c.asInt();
    int binaryInt2 = binarySInt2.getContent();
    int result = binaryInt2 * binaryInt1;
    String stringBinarySum = BinUtilities.intToBinary(result);
    return new ScrabbleBinary(stringBinarySum);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleNumber divideWith(ScrabbleNumber c) {
    return c.dividedByBinary(this);
  }

  /**
   * This object is divided to another object ScrabbleInt. For this purpose, the binary object is
   * transformed to an int
   *
   * @param c any ScrabbleInt object that can be added to
   * @return a new object with the quotient of both
   */
  @Override
  public ScrabbleNumber dividedByInt(ScrabbleInt c) {
    ScrabbleInt binarySInt = this.asInt();
    int binaryInt = binarySInt.getContent();
    int result = c.getContent() / binaryInt;
    return new ScrabbleInt(result);
  }

  /**
   * This object is divided to another object ScrabbleBinary. For this purpose, the binary object is
   * transformed to an int and subsequently to a float
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the quotient of both
   */
  @Override
  public ScrabbleNumber dividedByFloat(ScrabbleFloat c) {
    ScrabbleInt binarySInt = this.asInt();
    int binaryInt = binarySInt.getContent();
    double result = c.getContent() / binaryInt;
    return new ScrabbleFloat(result);
  }

  /**
   * This object is divided to another object ScrabbleBinary. For this purpose, both binary objects
   * are transformed to an int
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the quotient of both
   */
  @Override
  public ScrabbleNumber dividedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt1 = this.asInt();
    int binaryInt1 = binarySInt1.getContent();
    ScrabbleInt binarySInt2 = c.asInt();
    int binaryInt2 = binarySInt2.getContent();
    int result = binaryInt2 / binaryInt1;
    String stringBinarySum = BinUtilities.intToBinary(result);
    return new ScrabbleBinary(stringBinarySum);
  }

}


