package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleBoolean;
import cl.uchile.dcc.scrabble.types.ScrabbleFactory;
import cl.uchile.dcc.scrabble.types.ScrabbleLogic;
import cl.uchile.dcc.scrabble.types.ScrabbleString;
import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.HashMap;

public class Var implements Operation{
  private static HashMap<String, String> dictVariables = new HashMap<>();
  private String variable;
  private ScrabbleType content;
  private String key;
  private ScrabbleFactory f = new ScrabbleFactory();

  public Var(String variable) {
    this.variable = variable;
    if (!dictVariables.containsKey(variable)) {
      dictVariables.put(variable, "");

    }
  }

  //meter objetos del tipo scrabble
  public Var(String variable, String content) {
    this.variable = variable;
    var sObject = f.getString(content);
    key = Integer.toString(content.hashCode());
    dictVariables.put(variable, key);
    }

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  @Override
  public ScrabbleType evaluate() {
    key = dictVariables.get(this.variable);
    return f.getFromKey(key);

  }
}
