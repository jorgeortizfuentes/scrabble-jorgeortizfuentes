package cl.uchile.dcc.scrabble.gui;

import java.util.HashMap;


public class StringFactory {

  private static HashMap<Integer, ScrabbleString> element = new HashMap<>();

  public static ScrabbleString getString(int id, String content) {
    if (element.containsKey(id)) {
      return element.get(id);
    } else {
      ScrabbleString c = new ScrabbleString(content);
      element.put(id, c);
      return c;
    }
  }
}