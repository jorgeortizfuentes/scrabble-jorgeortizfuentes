package cl.uchile.dcc.scrabble.gui;

import java.util.HashMap;

public class IntFactory {

  private static HashMap<Integer, ScrabbleInt> element = new HashMap<>();

  public static ScrabbleInt getInt(int id, int content) {
    if (element.containsKey(id)) {
      return element.get(id);
    } else {
      ScrabbleInt c = new ScrabbleInt(content);
      element.put(id, c);
      return c;
    }
  }
}