package cl.uchile.dcc.scrabble.gui;

import java.util.HashMap;


public class BinaryFactory {

  private static HashMap<Integer, ScrabbleBinary> element = new HashMap<>();

  public static ScrabbleBinary getFloat(int id, String content) {
    if (element.containsKey(id)) {
      return element.get(id);
    } else {
      ScrabbleBinary c = new ScrabbleBinary(content);
      element.put(id, c);
      return c;
    }
  }
}