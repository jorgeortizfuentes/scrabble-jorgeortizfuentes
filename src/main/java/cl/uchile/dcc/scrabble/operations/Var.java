package cl.uchile.dcc.scrabble.operations;

import cl.uchile.dcc.scrabble.types.ScrabbleFactory;
import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.HashMap;
import java.util.Objects;

/**
 * Implementation of <i>Var</i>.
 * <p>
 * Allows you to create Scrabble objects with variables by saving them in memory using
 * ScrabbleFactory.
 *
 * @author <a href=mailto:jorge@ortizfuentes.com>Jorge Ortiz Fuentes</a>
 */
public class Var extends AbstractOperation implements Operation {

  /**
   * HashMap with the name of the variables and the Hash of the stored object
   */
  private static final HashMap<String, Integer> dictVariables = new HashMap<>();

  /**
   * Variable name
   */
  private final String variable;

  /**
   * The Var constructor stores in memory a variable
   *
   * @param variable name to store the object
   */
  public Var(String variable) {
    this.variable = variable;
    if (!dictVariables.containsKey(variable)) {
      dictVariables.put(variable, 0);

    }
  }

  /**
   * The Var constructor stores in memory a ScrabbleType object with a variable
   *
   * @param variable name to store the object
   * @param object   object to be stored
   */
  public Var(String variable, ScrabbleType object) {
    this.variable = variable;
    int key = object.hashCode();
    ScrabbleFactory.saveScrabbleType(object);
    dictVariables.put(variable, key);
  }

  public static void assign(String variable, ScrabbleType object) {
    int key = object.hashCode();
    ScrabbleFactory.saveScrabbleType(object);
    dictVariables.put(variable, key);
  }

  /**
   * Returns the variable name
   *
   * @return variable name
   */
  public String getVariable() {
    return variable;
  }

  /**
   * Return the Scrabble Key from a variable
   *
   * @return key from Scrabble Object
   */
  public Integer getScrabbleKey() {
    return dictVariables.get(variable);
  }

  /**
   * Assigns an object of cl.uchile.dcc.scrabble.type Scrabble to a variable in memory
   *
   * @param object object to be stored
   */
  public void assign(ScrabbleType object) {
    int key = object.hashCode();
    ScrabbleFactory.saveScrabbleType(object);
    dictVariables.put(this.variable, key);
  }

  /**
   * Evaluate the operations tree
   *
   * @return a ScrabbleType element
   */
  @Override
  public ScrabbleType evaluate() {
    int key = dictVariables.get(this.variable);
    return ScrabbleFactory.getFromKey(key);

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(Var.class, variable, dictVariables.get(variable));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Var) {
      var o = (Var) obj;
      return o.getVariable().equals(this.variable) && o.getScrabbleKey()
          .equals(this.getScrabbleKey());

    }
    return false;
  }

  /**
   * Indicates whether the tree and its leaves are complete.
   *
   * @return true or false
   */
  @Override
  public boolean isComplete() {
    return this.evaluate().isComplete();
  }

  /**
   * Adds a value or an operation to the first empty node on the left
   *
   * @param v value
   */
  //@Override
  public void setValues(Operation v) {
    this.assign((ScrabbleType) v);

  }
}
