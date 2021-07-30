package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.controller.Operation;
import cl.uchile.dcc.scrabble.controller.ScrabbleFactory;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of the <i>ScrabbleBinary</i>.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleBinary extends ScrabbleAbstract implements Operation {

  /**
   * Object content with a java string
   */
  protected String content;

  /**
   * ScrabbleBinary Constructor Constructs a Binary object of Scrabble cl.uchile.dcc.scrabble.type.
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
  public ScrabbleType conjunctionWith(ScrabbleType c) {
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
  public ScrabbleType conjunctionByBoolean(ScrabbleBoolean c) {
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
   * @return the binary operated value by value
   */
  @Override
  public ScrabbleType conjunctionByBinary(ScrabbleBinary c) {
    String v1;
    String v2;
    int lengthDifference = Math.abs(c.getContent().length() - this.content.length());

    if (c.getContent().length() >= this.content.length()) {
      v1 = c.getContent();
      v2 = this.content;
    } else {
      v1 = this.content;
      v2 = c.getContent();
    }

    v2 = "0".repeat(lengthDifference) + v2;

    StringBuilder newBinary = new StringBuilder();
    for (int i = 0; i < v1.length(); i++) {
      if (v1.charAt(i) == '1' && v2.charAt(i) == '1') {
        newBinary.append("1");
      } else {
        newBinary.append("0");
      }
    }
    return new ScrabbleBinary(newBinary.toString());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ScrabbleType disjunctionWith(ScrabbleType c) {
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
  public ScrabbleType disjunctionByBoolean(ScrabbleBoolean c) {
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
  public ScrabbleType disjunctionByBinary(ScrabbleBinary c) {
    String v1;
    String v2;

    int lengthDifference = Math.abs(c.getContent().length() - this.content.length());

    if (c.getContent().length() >= this.content.length()) {
      v1 = c.getContent();
      v2 = this.content;
    } else {
      v1 = this.content;
      v2 = c.getContent();
    }

    v2 = "0".repeat(lengthDifference) + v2;

    StringBuilder newBinary = new StringBuilder();
    for (int i = 0; i < v1.length(); i++) {
      if (v1.charAt(i) == '0' && v2.charAt(i) == '0') {
        newBinary.append("0");
      } else {
        newBinary.append("1");
      }
    }
    return new ScrabbleBinary(newBinary.toString());

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
  public ScrabbleType subtractWith(ScrabbleType c) {
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
  public ScrabbleType subtractedByInt(ScrabbleInt c) {
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
  public ScrabbleType subtractedByFloat(ScrabbleFloat c) {
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
  public ScrabbleType subtractedByBinary(ScrabbleBinary c) {
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
  public ScrabbleType multiplyWith(ScrabbleType c) {
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
  public ScrabbleType multipliedByInt(ScrabbleInt c) {
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
  public ScrabbleType multipliedByFloat(ScrabbleFloat c) {
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
  public ScrabbleType multipliedByBinary(ScrabbleBinary c) {
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
  public ScrabbleType divideWith(ScrabbleType c) {
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
  public ScrabbleType dividedByInt(ScrabbleInt c) {
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
  public ScrabbleType dividedByFloat(ScrabbleFloat c) {
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
  public ScrabbleType dividedByBinary(ScrabbleBinary c) {
    ScrabbleInt binarySInt1 = this.asInt();
    int binaryInt1 = binarySInt1.getContent();
    ScrabbleInt binarySInt2 = c.asInt();
    int binaryInt2 = binarySInt2.getContent();
    int result = binaryInt2 / binaryInt1;
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
    return ScrabbleFactory.getBinary(content);
  }

  /**
   * Indicates its color
   *
   * @return CSS color
   */
  @Override
  public String getColor() {
    return "DARKSLATEGRAY";
  }

  /**
   * Indicates a label with its abbreviation
   *
   * @return CSS color
   */
  @Override
  public String getLabel() {
    return "BIN";
  }
}


