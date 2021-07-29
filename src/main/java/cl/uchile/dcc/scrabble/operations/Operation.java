package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleBinary;
import cl.uchile.dcc.scrabble.types.ScrabbleBoolean;
import cl.uchile.dcc.scrabble.types.ScrabbleFloat;
import cl.uchile.dcc.scrabble.types.ScrabbleInt;
import cl.uchile.dcc.scrabble.types.ScrabbleString;
import cl.uchile.dcc.scrabble.types.ScrabbleType;

/**
 * Interface modeling the operation trees between Scrabbles objects.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public interface Operation {

  /**
   * Determines if two objects are the same
   *
   * @param obj Object of cl.uchile.dcc.scrabble.type ScrabbleType
   * @return true or false depending on whether the two objects are the same
   */
  boolean equals(Object obj);

  /**
   * Returns the hashcode of the tree based on its leaves.
   *
   * @return the hashcode of the object
   */
  int hashCode();

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  ScrabbleType evaluate();


  /**
   * Evaluate the operation and return the result in ScrabbleInt format.
   *
   * @return content the result in ScrabbleInt format
   */
  ScrabbleInt asInt();

  /**
   * Evaluate the operation and return the result in ScrabbleBoolean format.
   *
   * @return content the result in ScrabbleBoolean format
   */
  ScrabbleBoolean asBoolean();

  /**
   * Evaluate the operation and return the result in ScrabbleString format.
   *
   * @return content the result in ScrabbleString format
   */
  ScrabbleString asString();

  /**
   * Evaluate the operation and return the result in ScrabbleFloat format.
   *
   * @return content the result in ScrabbleFloat format
   */
  ScrabbleFloat asFloat();

  /**
   * Evaluate the operation and return the result in ScrabbleBinary format.
   *
   * @return content the result in ScrabbleBinary format
   */
  ScrabbleBinary asBinary();

  /**
   * Adds a value or an operation to the first empty node on the left
   *
   * @param v value
   */
  void setValues(Operation v);

  /**
   * Indicates whether the tree and its leaves are complete.
   *
   * @return true or false
   */
  boolean isComplete();

  /**
   * Indicates its color
   *
   * @return CSS color
   */
  String getColor();

  /**
   * Indicates a label with its abbreviation
   *
   * @return CSS color
   */
  String getLabel();
}