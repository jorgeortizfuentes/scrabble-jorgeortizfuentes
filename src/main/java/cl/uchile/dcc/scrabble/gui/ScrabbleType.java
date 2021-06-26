package cl.uchile.dcc.scrabble.gui;

/**
 * Interface that models objects of the Scrabble type.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public interface ScrabbleType {

  /**
   * Returns the content in JavaString format
   *
   * @return content in Java String format
   */
  String toString();

  /**
   * Determines if two objects are the same
   *
   * @param obj Object of type ScrabbleType
   * @return true or false depending on whether the two objects are the same
   */
  boolean equals(Object obj);

  /**
   * Returns the hashcode of the object based on the object type and content.
   *
   * @return the hashcode of the object
   */
  int hashCode();

  /**
   * Returns the content of the object in ScrabbleString format.
   *
   * @return content of the object in ScrabbleString format
   */
  ScrabbleString asString();

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

}


