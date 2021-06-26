package cl.uchile.dcc.scrabble.gui;

import java.util.HashMap;


public class FloatFactory {

  private static HashMap<Integer, ScrabbleFloat> element = new HashMap<>();

  public static ScrabbleFloat getFloat(int id, double content) {
    if (element.containsKey(id)) {
      return element.get(id);
    } else {
      ScrabbleFloat c = new ScrabbleFloat(content);
      element.put(id, c);
      return c;
    }
  }
}