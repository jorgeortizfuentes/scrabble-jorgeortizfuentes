package cl.uchile.dcc.scrabble.gui;

/**
 * Interface that models objects of the Scrabble Number type.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public interface ScrabbleNumber {

  /**
   * To this object is added another object ScrabbleType c
   *
   * @param c any ScrabbleType object that can be added to
   * @return a new object with the sum of both
   */
  ScrabbleType addWith(ScrabbleType c);

  /**
   * Another object is added to this object
   *
   * @param c any ScrabbleString object that can be added to
   * @return a new object with the sum of both
   */
  ScrabbleType addedByString(ScrabbleString c);

  /**
   * This object is added to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be added to
   * @return a new object with the sum of both
   */
  ScrabbleType addedByInt(ScrabbleInt c);

  /**
   * This object is added to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be added to
   * @return a new object with the sum of both
   */
  ScrabbleType addedByFloat(ScrabbleFloat c);

  /**
   * This object is added to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the sum of both
   */
  ScrabbleType addedByBinary(ScrabbleBinary c);

  /**
   * Another object is subtracted to this object
   *
   * @param c any ScrabbleString object that can be subtracted to
   * @return a new object with the subtract of both
   */
  ScrabbleNumber subtractWith(ScrabbleNumber c);

  /**
   * This object is subtracted to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be subtracted to
   * @return a new object with the subtract of both
   */
  ScrabbleNumber subtractedByInt(ScrabbleInt c);

  /**
   * This object is subtracted to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be subtracted to
   * @return a new object with the subtract of both
   */
  ScrabbleNumber subtractedByFloat(ScrabbleFloat c);

  /**
   * This object is subtracted to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be subtracted to
   * @return a new object with the subtract of both
   */
  ScrabbleNumber subtractedByBinary(ScrabbleBinary c);

  /**
   * Another object is multiplied to this object
   *
   * @param c any ScrabbleString object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  ScrabbleNumber multiplyWith(ScrabbleNumber c);

  /**
   * This object is multiplied to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  ScrabbleNumber multipliedByInt(ScrabbleInt c);

  /**
   * This object is multiplied to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  ScrabbleNumber multipliedByFloat(ScrabbleFloat c);

  /**
   * This object is multiplied to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be multiplied to
   * @return a new object with multiplication of both
   */
  ScrabbleNumber multipliedByBinary(ScrabbleBinary c);

  /**
   * Another object is divided to this object
   *
   * @param c any ScrabbleString object that can be divided to
   * @return a new object with the quotient of both
   */
  ScrabbleNumber divideWith(ScrabbleNumber c);

  /**
   * This object is divided to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be divided to
   * @return a new object with the quotient of both
   */
  ScrabbleNumber dividedByInt(ScrabbleInt c);

  /**
   * This object is divided to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be divided to
   * @return a new object with the quotient of both
   */
  ScrabbleNumber dividedByFloat(ScrabbleFloat c);

  /**
   * This object is divided to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be divided to
   * @return a new object with quotient of both
   */
  ScrabbleNumber dividedByBinary(ScrabbleBinary c);

  /**
   * Returns the object in ScrabbleBinary format.
   *
   * @return content of the object in ScrabbleBinary format
   */
  ScrabbleBinary asBinary();
}
