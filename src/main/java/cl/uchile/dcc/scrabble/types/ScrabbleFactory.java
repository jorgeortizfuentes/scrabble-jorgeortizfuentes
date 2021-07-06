package cl.uchile.dcc.scrabble.types;

import java.util.HashMap;


public class ScrabbleFactory {

  public static HashMap<String, ScrabbleType> dict = new HashMap<>();


  public ScrabbleString getString(String variable, String content) {
    if (dict.containsKey(variable)) {
      return (ScrabbleString) dict.get(variable);
    } else {
      ScrabbleString c = new ScrabbleString(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleString getString(String content) {
    int hash = content.hashCode();
    String variable = Integer.toString(hash);
    if (dict.containsKey(variable)) {
      return (ScrabbleString) dict.get(variable);
    } else {
      ScrabbleString c = new ScrabbleString(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleInt getInt(String variable, int content) {
    if (dict.containsKey(variable)) {
      return (ScrabbleInt) dict.get(variable);
    } else {
      ScrabbleInt c = new ScrabbleInt(content);
      dict.put(variable, c);
      return c;
    }

  }

  public ScrabbleInt getInt(int content) {
    int hash = Integer.valueOf(content).hashCode();
    String variable = Integer.toString(hash);
    if (dict.containsKey(variable)) {
      return (ScrabbleInt) dict.get(variable);
    } else {
      ScrabbleInt c = new ScrabbleInt(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleFloat getFloat(String variable, double content) {
    if (dict.containsKey(variable)) {
      return (ScrabbleFloat) dict.get(variable);
    } else {
      ScrabbleFloat c = new ScrabbleFloat(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleFloat getFloat(double content) {
    int hash = Double.valueOf(content).hashCode();
    String variable = Integer.toString(hash);
    if (dict.containsKey(variable)) {
      return (ScrabbleFloat) dict.get(variable);
    } else {
      ScrabbleFloat c = new ScrabbleFloat(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleBinary getBinary(String variable, String content) {
    if (dict.containsKey(variable)) {
      return (ScrabbleBinary) dict.get(variable);
    } else {
      ScrabbleBinary c = new ScrabbleBinary(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleBinary getBinary(String content) {
    int hash = content.hashCode();
    String variable = Integer.toString(hash);
    if (dict.containsKey(variable)) {
      return (ScrabbleBinary) dict.get(variable);
    } else {
      ScrabbleBinary c = new ScrabbleBinary(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleBoolean getBoolean(String variable, boolean content) {
    if (dict.containsKey(variable)) {
      return (ScrabbleBoolean) dict.get(variable);
    } else {
      ScrabbleBoolean c = new ScrabbleBoolean(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleBoolean getBoolean(boolean content) {
    int hash = Boolean.valueOf(content).hashCode();
    String variable = Integer.toString(hash);
    if (dict.containsKey(variable)) {
      return (ScrabbleBoolean) dict.get(variable);
    } else {
      ScrabbleBoolean c = new ScrabbleBoolean(content);
      dict.put(variable, c);
      return c;
    }
  }

  public ScrabbleType getFromKey(String key) {
    return dict.get(key);

  }
}

