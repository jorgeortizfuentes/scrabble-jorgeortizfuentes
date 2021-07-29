package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.model.ScrabbleBinary;
import cl.uchile.dcc.scrabble.model.ScrabbleBoolean;
import cl.uchile.dcc.scrabble.model.ScrabbleFloat;
import cl.uchile.dcc.scrabble.model.ScrabbleInt;
import cl.uchile.dcc.scrabble.model.ScrabbleString;
import cl.uchile.dcc.scrabble.model.ScrabbleType;
import java.util.HashMap;

/**
 * Implementation of <i>Scrabble Factory</i>.
 * <p>
 * Allows you to create Scrabble objects by saving them in memory.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class ScrabbleFactory {

  /**
   * HashMap that stores ScrabbleTypes using its Hash as key
   */
  private static final HashMap<Integer, ScrabbleType> dict = new HashMap<>();

  /**
   * Creates an object of cl.uchile.dcc.scrabble.type ScrabbleString by optimizing the memory
   *
   * @param content receives a java string for the content of the object
   * @return a ScrabbleString object.
   */
  public static ScrabbleString getString(String content) {
    ScrabbleString c = new ScrabbleString(content);
    int keyVariable = c.hashCode();
    if (dict.containsKey(keyVariable)) {
      return (ScrabbleString) dict.get(keyVariable);
    } else {
      dict.put(keyVariable, c);
      return c;
    }
  }

  /**
   * Creates or returns an object of cl.uchile.dcc.scrabble.type ScrabbleInt by optimizing the
   * memory
   *
   * @param content receives a java int for the content of the object
   * @return a ScrabbleInt object.
   */
  public static ScrabbleInt getInt(int content) {
    ScrabbleInt c = new ScrabbleInt(content);
    int keyVariable = c.hashCode();
    if (dict.containsKey(keyVariable)) {
      return (ScrabbleInt) dict.get(keyVariable);
    } else {
      dict.put(keyVariable, c);
      return c;
    }
  }

  /**
   * Creates or returns an object of cl.uchile.dcc.scrabble.type ScrabbleFloat by optimizing the
   * memory
   *
   * @param content receives a java double for the content of the object
   * @return a ScrabbleFloat object.
   */
  public static ScrabbleFloat getFloat(double content) {
    ScrabbleFloat c = new ScrabbleFloat(content);
    int keyVariable = c.hashCode();
    if (dict.containsKey(keyVariable)) {
      return (ScrabbleFloat) dict.get(keyVariable);
    } else {
      dict.put(keyVariable, c);
      return c;
    }
  }

  /**
   * Creates or returns  an object of cl.uchile.dcc.scrabble.type ScrabbleBinary by optimizing the
   * memory
   *
   * @param content receives a java String with 1 and 0 for the content of the object
   * @return a ScrabbleBinary object.
   */
  public static ScrabbleBinary getBinary(String content) {
    ScrabbleBinary c = new ScrabbleBinary(content);
    int keyVariable = c.hashCode();
    if (dict.containsKey(keyVariable)) {
      return (ScrabbleBinary) dict.get(keyVariable);
    } else {
      dict.put(keyVariable, c);
      return c;
    }
  }

  /**
   * Creates or returns an object of cl.uchile.dcc.scrabble.type ScrabbleBoolean by optimizing the
   * memory
   *
   * @param content receives a java boolean for the content of the object
   * @return a ScrabbleBoolean object.
   */
  public static ScrabbleBoolean getBoolean(boolean content) {
    ScrabbleBoolean c = new ScrabbleBoolean(content);
    int keyVariable = c.hashCode();
    if (dict.containsKey(keyVariable)) {
      return (ScrabbleBoolean) dict.get(keyVariable);
    } else {
      dict.put(keyVariable, c);
      return c;
    }
  }

  /**
   * Returns an object in memory according to its key in the HashMap
   *
   * @param key with the hash of the object
   * @return a ScrabbleType if the object exists or a null
   */
  public static ScrabbleType getFromKey(int key) {
    return dict.get(key);

  }

  public static void saveScrabbleType(ScrabbleType c) {
    int keyVariable = c.hashCode();
    if (!dict.containsKey(keyVariable)) {
      dict.put(keyVariable, c);
    }
  }


}

