package cl.uchile.dcc.scrabble.model;

import cl.uchile.dcc.scrabble.controller.Operation;

public abstract class ScrabbleAbstract implements ScrabbleType {

  /**
   * Transforms this object to its logical negation
   *
   * @return a new object with the logical negation
   */
  @Override
  public ScrabbleType negation() {
    return null;
  }

  /**
   * Relates this object according to the logical conjunction to another object c
   *
   * @param c a ScrabbleType object
   * @return a new object with the conjunction between the two
   */
  @Override
  public ScrabbleType conjunctionWith(ScrabbleType c) {
    return null;
  }

  /**
   * This object is related by the logical operation conjunction by another object c of
   * cl.uchile.dcc.scrabble.type ScrabbleBoolean
   *
   * @param c an object that can be operated by the conjunction
   * @return a new object with the conjunction between the two
   */
  @Override
  public ScrabbleType conjunctionByBoolean(ScrabbleBoolean c) {
    return null;
  }

  /**
   * This object is related by the logical operation conjunction by another object c of
   * cl.uchile.dcc.scrabble.type ScrabbleBinary
   *
   * @param c an object that can be operated by the conjunction
   * @return a new object with the conjunction between the two
   */
  @Override
  public ScrabbleType conjunctionByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * Relates this object according to the logical disjunction to another object c
   *
   * @param c a ScrabbleType object
   * @return a new object with the disjunction between the two
   */
  @Override
  public ScrabbleType disjunctionWith(ScrabbleType c) {
    return null;
  }

  /**
   * This object is related by the logical operation disjunction by another object c of
   * cl.uchile.dcc.scrabble.type ScrabbleBoolean
   *
   * @param c an object that can be operated by the disjunction
   * @return a new object with the disjunction between the two
   */
  @Override
  public ScrabbleType disjunctionByBoolean(ScrabbleBoolean c) {
    return null;
  }

  /**
   * This object is related by the logical operation disjunction by another object c of
   * cl.uchile.dcc.scrabble.type ScrabbleBinary
   *
   * @param c an object that can be operated by the disjunction
   * @return a new object with the disjunction between the two
   */
  @Override
  public ScrabbleType disjunctionByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * Another object is subtracted to this object
   *
   * @param c any ScrabbleString object that can be subtracted to
   * @return a new object with the subtract of both
   */
  @Override
  public ScrabbleType subtractWith(ScrabbleType c) {
    return null;
  }

  /**
   * This object is subtracted to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be subtracted to
   * @return a new object with the subtract of both
   */
  @Override
  public ScrabbleType subtractedByInt(ScrabbleInt c) {
    return null;
  }

  /**
   * This object is subtracted to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be subtracted to
   * @return a new object with the subtract of both
   */
  @Override
  public ScrabbleType subtractedByFloat(ScrabbleFloat c) {
    return null;
  }

  /**
   * This object is subtracted to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be subtracted to
   * @return a new object with the subtract of both
   */
  @Override
  public ScrabbleType subtractedByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * Another object is multiplied to this object
   *
   * @param c any ScrabbleString object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  @Override
  public ScrabbleType multiplyWith(ScrabbleType c) {
    return null;
  }

  /**
   * This object is multiplied to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  @Override
  public ScrabbleType multipliedByInt(ScrabbleInt c) {
    return null;
  }

  /**
   * This object is multiplied to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be multiplied to
   * @return a new object with the multiplication of both
   */
  @Override
  public ScrabbleType multipliedByFloat(ScrabbleFloat c) {
    return null;
  }

  /**
   * This object is multiplied to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be multiplied to
   * @return a new object with multiplication of both
   */
  @Override
  public ScrabbleType multipliedByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * Another object is divided to this object
   *
   * @param c any ScrabbleString object that can be divided to
   * @return a new object with the quotient of both
   */
  @Override
  public ScrabbleType divideWith(ScrabbleType c) {
    return null;
  }

  /**
   * This object is divided to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be divided to
   * @return a new object with the quotient of both
   */
  @Override
  public ScrabbleType dividedByInt(ScrabbleInt c) {
    return null;
  }

  /**
   * This object is divided to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be divided to
   * @return a new object with the quotient of both
   */
  @Override
  public ScrabbleType dividedByFloat(ScrabbleFloat c) {
    return null;
  }

  /**
   * This object is divided to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be divided to
   * @return a new object with quotient of both
   */
  @Override
  public ScrabbleType dividedByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * Returns the object in ScrabbleBinary format.
   *
   * @return content of the object in ScrabbleBinary format
   */
  @Override
  public ScrabbleBinary asBinary() {
    return null;
  }

  /**
   * Returns the object in ScrabbleFloat format.
   *
   * @return content of the object in ScrabbleFloat format
   */
  @Override
  public ScrabbleFloat asFloat() {
    return null;
  }

  /**
   * Returns the object in ScrabbleInt format.
   *
   * @return content of the object in ScrabbleInt format
   */
  @Override
  public ScrabbleInt asInt() {
    return null;
  }

  /**
   * Returns the object in ScrabbleBoolean format.
   *
   * @return content of the object in ScrabbleBoolean format
   */
  @Override
  public ScrabbleBoolean asBoolean() {
    return null;
  }

  /**
   * To this object is added another object ScrabbleType c
   *
   * @param c any ScrabbleType object that can be added to
   * @return a new object with the sum of both
   */
  @Override
  public ScrabbleType addWith(ScrabbleType c) {
    return null;
  }

  /**
   * This object is added to another object ScrabbleInt.
   *
   * @param c any ScrabbleInt object that can be added to
   * @return a new object with the sum of both
   */
  @Override
  public ScrabbleType addedByInt(ScrabbleInt c) {
    return null;
  }

  /**
   * This object is added to another object ScrabbleFloat.
   *
   * @param c any ScrabbleFloat object that can be added to
   * @return a new object with the sum of both
   */
  @Override
  public ScrabbleType addedByFloat(ScrabbleFloat c) {
    return null;
  }

  /**
   * This object is added to another object ScrabbleBinary
   *
   * @param c any ScrabbleBinary object that can be added to
   * @return a new object with the sum of both
   */
  @Override
  public ScrabbleType addedByBinary(ScrabbleBinary c) {
    return null;
  }

  /**
   * Indicates whether the tree and its leaves are complete.
   *
   * @return true or false
   */
  public boolean isComplete() {
    return true;
  }

  /**
   * Adds a value or an operation to the first empty node on the left
   *
   * @param v value
   */
  //@Override
  public void setValues(Operation v) {
    throw new AssertionError("The value of a Scrabble object cannot be reallocated.");
  }
}
