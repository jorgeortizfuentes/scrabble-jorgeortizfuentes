package cl.uchile.dcc.scrabble.gui;

import java.util.HashMap;


public class BooleanFactory {

  private static HashMap<Integer, ScrabbleBoolean> element = new HashMap<>();

  public static ScrabbleBoolean getFloat(int id, boolean content) {
    if (element.containsKey(id)) {
      return element.get(id);
    } else {
      ScrabbleBoolean c = new ScrabbleBoolean(content);
      element.put(id, c);
      return c;
    }
  }
}