package cl.uchile.dcc.scrabble.types;

/**
 * Interface that models objects of the Scrabble cl.uchile.dcc.scrabble.type.
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
   * @param obj Object of cl.uchile.dcc.scrabble.type ScrabbleType
   * @return true or false depending on whether the two objects are the same
   */
  boolean equals(Object obj);

  /**
   * Returns the hashcode of the object based on the object cl.uchile.dcc.scrabble.type and
   * content.
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

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  ScrabbleType evaluate();

  /**
   * Another object is subtracted to this object
   *
   * @param c any ScrabbleString object that can be subtracted to
   * @return a new object with the subtract of both
   */
  ScrabbleType subtractWith(ScrabbleType c);

  /**
   * This object is subtracted to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be subtracted to
   * @return a new object with the subtract of both
   */
  ScrabbleType subtractedByInt(ScrabbleInt c);

  /**
   * This object is subtracted to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be subtracted to
   * @return a new object with the subtract of both
   */
  ScrabbleType subtractedByFloat(ScrabbleFloat c);

  /**
   * This object is subtracted to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be subtracted to
   * @return a new object with the subtract of both
   */
  ScrabbleType subtractedByBinary(ScrabbleBinary c);

  /**
   * Another object is multiplied to this object
   *
   * @param c any ScrabbleString object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  ScrabbleType multiplyWith(ScrabbleType c);

  /**
   * This object is multiplied to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  ScrabbleType multipliedByInt(ScrabbleInt c);

  /**
   * This object is multiplied to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  ScrabbleType multipliedByFloat(ScrabbleFloat c);

  /**
   * This object is multiplied to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be multiplied to
   * @return a new object with multiplication of both
   */
  ScrabbleType multipliedByBinary(ScrabbleBinary c);

  /**
   * Another object is divided to this object
   *
   * @param c any ScrabbleString object that can be divided to
   * @return a new object with the quotient of both
   */
  ScrabbleType divideWith(ScrabbleType c);

  /**
   * This object is divided to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be divided to
   * @return a new object with the quotient of both
   */
  ScrabbleType dividedByInt(ScrabbleInt c);

  /**
   * This object is divided to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be divided to
   * @return a new object with the quotient of both
   */
  ScrabbleType dividedByFloat(ScrabbleFloat c);

  /**
   * This object is divided to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be divided to
   * @return a new object with quotient of both
   */
  ScrabbleType dividedByBinary(ScrabbleBinary c);

  /**
   * Returns the object in ScrabbleBinary format.
   *
   * @return content of the object in ScrabbleBinary format
   */
  ScrabbleBinary asBinary();

  /**
   * Returns the object in ScrabbleFloat format.
   *
   * @return content of the object in ScrabbleFloat format
   */
  ScrabbleFloat asFloat();

  /**
   * Returns the object in ScrabbleInt format.
   *
   * @return content of the object in ScrabbleInt format
   */
  ScrabbleInt asInt();

  /**
   * Returns the object in ScrabbleBoolean format.
   *
   * @return content of the object in ScrabbleBoolean format
   */
  ScrabbleBoolean asBoolean();

  /**
   * Transforms this object to its logical negation
   *
   * @return a new object with the logical negation
   */
  ScrabbleType negation();

  /**
   * Relates this object according to the logical conjunction to another object c
   *
   * @param c a ScrabbleType object
   * @return a new object with the conjunction between the two
   */
  ScrabbleType conjunctionWith(ScrabbleType c);

  /**
   * This object is related by the logical operation conjunction by another object c of
   * cl.uchile.dcc.scrabble.type ScrabbleBoolean
   *
   * @param c an object that can be operated by the conjunction
   * @return a new object with the conjunction between the two
   */
  ScrabbleType conjunctionByBoolean(ScrabbleBoolean c);

  /**
   * This object is related by the logical operation conjunction by another object c of
   * cl.uchile.dcc.scrabble.type ScrabbleBinary
   *
   * @param c an object that can be operated by the conjunction
   * @return a new object with the conjunction between the two
   */
  ScrabbleType conjunctionByBinary(ScrabbleBinary c);

  /**
   * Relates this object according to the logical disjunction to another object c
   *
   * @param c a ScrabbleType object
   * @return a new object with the disjunction between the two
   */
  ScrabbleType disjunctionWith(ScrabbleType c);

  /**
   * This object is related by the logical operation disjunction by another object c of
   * cl.uchile.dcc.scrabble.type ScrabbleBoolean
   *
   * @param c an object that can be operated by the disjunction
   * @return a new object with the disjunction between the two
   */
  ScrabbleType disjunctionByBoolean(ScrabbleBoolean c);

  /**
   * This object is related by the logical operation disjunction by another object c of
   * cl.uchile.dcc.scrabble.type ScrabbleBinary
   *
   * @param c an object that can be operated by the disjunction
   * @return a new object with the disjunction between the two
   */
  ScrabbleType disjunctionByBinary(ScrabbleBinary c);

}






