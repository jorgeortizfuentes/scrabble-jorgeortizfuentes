package cl.uchile.dcc.scrabble.types;

/**
 * Interface that models objects of the Scrabble Logic type.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public interface ScrabbleLogic {

  /**
   * Transforms this object to its logical negation
   *
   * @return a new object with the logical negation
   */
  ScrabbleLogic negation();

  /**
   * Relates this object according to the logical conjunction to another object c
   *
   * @param c a ScrabbleLogic object
   * @return a new object with the conjunction between the two
   */
  ScrabbleLogic conjunctionWith(ScrabbleLogic c);

  /**
   * This object is related by the logical operation conjunction by another object c of type
   * ScrabbleBoolean
   *
   * @param c an object that can be operated by the conjunction
   * @return a new object with the conjunction between the two
   */
  ScrabbleLogic conjunctionByBoolean(ScrabbleBoolean c);

  /**
   * This object is related by the logical operation conjunction by another object c of type
   * ScrabbleBinary
   *
   * @param c an object that can be operated by the conjunction
   * @return a new object with the conjunction between the two
   */
  ScrabbleLogic conjunctionByBinary(ScrabbleBinary c);

  /**
   * Relates this object according to the logical disjunction to another object c
   *
   * @param c a ScrabbleLogic object
   * @return a new object with the disjunction between the two
   */
  ScrabbleLogic disjunctionWith(ScrabbleLogic c);

  /**
   * This object is related by the logical operation disjunction by another object c of type
   * ScrabbleBoolean
   *
   * @param c an object that can be operated by the disjunction
   * @return a new object with the disjunction between the two
   */
  ScrabbleLogic disjunctionByBoolean(ScrabbleBoolean c);

  /**
   * This object is related by the logical operation disjunction by another object c of type
   * ScrabbleBinary
   *
   * @param c an object that can be operated by the disjunction
   * @return a new object with the disjunction between the two
   */
  ScrabbleLogic disjunctionByBinary(ScrabbleBinary c);
}
