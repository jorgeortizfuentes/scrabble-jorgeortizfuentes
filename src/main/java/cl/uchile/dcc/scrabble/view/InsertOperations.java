package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.controller.Add;
import cl.uchile.dcc.scrabble.controller.And;
import cl.uchile.dcc.scrabble.controller.Div;
import cl.uchile.dcc.scrabble.controller.Mult;
import cl.uchile.dcc.scrabble.controller.Negate;
import cl.uchile.dcc.scrabble.controller.Or;
import cl.uchile.dcc.scrabble.controller.ScrabbleFactory;
import cl.uchile.dcc.scrabble.controller.Subt;

/**
 * Insert operations actions for inserting operations and transformations
 *
 * @author Jorge Luis Ortiz Fuentes
 */
public class InsertOperations {

  /**
   * Performs an addition operation
   * <p>
   * If the operation in memory is empty, construct an empty add operation. If an operation already
   * exists and is not completed, then it adds an empty add operation in the leftmost available
   * space.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void addOperation() {
    if (Operations.isNull() || Operations.isComplete()) {
      Operations.cleanOperationBox();
      Result.cleanResult();
      Operations.setOperation(new Add());
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
    } else {
      Operations.setValues(new Add());
    }
    Notifications.addMessage("Inserts the second addend or an operation");
    Notifications.addMessage("Inserts the first addend or an operation");
    Notifications.showLastMessage();
    Operations.addOperationSign("(");
    Operations.leaveSignInQueue(")");
    Operations.leaveSignInQueue("+");
  }

  /**
   * Performs a subtraction operation
   * <p>
   * If the operation in memory is empty, construct an empty subtraction operation. If an operation
   * already exists and is not completed, then it adds an empty subtraction operation in the
   * leftmost available space.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void subtOperation() {
    if (Operations.isNull() || Operations.isComplete()) {
      Operations.setOperation(new Subt());
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
    } else {
      Operations.setValues(new Subt());
    }
    Notifications.addMessage("Insert the subtrahend or an operation");
    Notifications.addMessage("Insert the minuend or an operation");
    Notifications.showLastMessage();
    Operations.addOperationSign("(");
    Operations.leaveSignInQueue(")");
    Operations.leaveSignInQueue("-");
  }

  /**
   * Performs a multiplication operation
   * <p>
   * If the operation in memory is empty, construct an empty multiplication operation. If an
   * operation already exists and is not completed, then it adds an empty multiplication operation
   * in the leftmost available space.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void multOperation() {
    if (Operations.isNull() || Operations.isComplete()) {
      Operations.setOperation(new Mult());
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
    } else {
      Operations.setValues(new Mult());
    }
    Notifications.addMessage("Insert the multiplicand or an operation");
    Notifications.addMessage("Insert the multiplier or an operation");
    Notifications.showLastMessage();
    Operations.addOperationSign("(");
    Operations.leaveSignInQueue(")");
    Operations.leaveSignInQueue("\u25A1");
  }

  /**
   * Performs a division operation
   * <p>
   * If the operation in memory is empty, construct an empty division operation. If an operation
   * already exists and is not completed, then it adds an empty division operation in the leftmost
   * available space.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void divOperation() {
    if (Operations.isNull() || Operations.isComplete()) {
      Operations.setOperation(new Div());
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
    } else {
      Operations.setValues(new Div());
    }
    Notifications.addMessage("Insert the dividend or an operation");
    Notifications.addMessage("Insert the divisor or an operation");
    Notifications.showLastMessage();
    Operations.addOperationSign("(");
    Operations.leaveSignInQueue(")");
    Operations.leaveSignInQueue("\u25A1");
  }

  /**
   * Performs a conjunction operation
   * <p>
   * If the operation in memory is empty, construct an empty conjunction operation. If an operation
   * already exists and is not completed, then it adds an empty conjunction operation in the
   * leftmost available space.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void andOperation() {
    if (Operations.isNull() || Operations.isComplete()) {
      Operations.setOperation(new And());
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
    } else {
      Operations.setValues(new And());
    }
    Notifications.addMessage("Insert the second logic element or an operation");
    Notifications.addMessage("Insert the first logic element or an operation");
    Notifications.showLastMessage();
    Operations.addOperationSign("(");
    Operations.leaveSignInQueue(")");
    Operations.leaveSignInQueue("\u2227");

  }

  /**
   * Performs a disjunction operation
   * <p>
   * If the operation in memory is empty, construct an empty disjunction operation. If an operation
   * already exists and is not completed, then it adds an empty disjunction operation in the
   * leftmost available space.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void orOperation() {
    if (Operations.isNull() || Operations.isComplete()) {
      Operations.setOperation(new Or());
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
    } else {
      Operations.setValues(new Or());
    }
    Notifications.addMessage("Insert the second logic element or an operation");
    Notifications.addMessage("Insert the first logic element or an operation");
    Notifications.showLastMessage();
    Operations.addOperationSign("(");
    Operations.leaveSignInQueue(")");
    Operations.leaveSignInQueue("\u2228");

  }

  /**
   * Performs a negation operation
   * <p>
   * If the operation in memory is empty, construct an empty negation operation. If an operation
   * already exists and is not completed, then it adds an empty negation operation in the leftmost
   * available space.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void negateOperation() {
    if (Operations.isNull() || Operations.isComplete()) {
      Operations.setOperation(new Negate());
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
    } else {
      Operations.setValues(new Negate());
    }
    Notifications.addMessage("Insert the first logic element or an operation");
    Notifications.showLastMessage();
    Operations.addOperationSign("( \u00AC");
    Operations.leaveSignInQueue(")");

  }

  /**
   * Performs an operation to transform into String
   * <p>
   * If the operation in memory is empty, construct an empty transform operation. If an operation
   * already exists and is not completed, then it adds an empty transform operation in the leftmost
   * available space. If the operation is completed, then transform the result.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void asStringOperation() {
    if (Operations.isNull()) {
      Operations.setOperation(new Add());
      Operations.setValues(ScrabbleFactory.getString(""));
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
      Notifications.addMessage("Insert the object to transform into String");
      Notifications.showLastMessage();
      Operations.addOperationSign("Str  (");
      Operations.leaveSignInQueue(")");

    } else if (!Operations.isComplete()) {
      Operations.setValues(new Add());
      Operations.setValues(ScrabbleFactory.getString(""));
      Notifications.addMessage("Insert the object to transform into String");
      Notifications.showLastMessage();
      Operations.addOperationSign("Str  (");
      Operations.leaveSignInQueue(")");

    } else if (Operations.isComplete()) {
      Operations.asString();
      Result.cleanResult();
      Calculate.calculate();
    }
  }

  /**
   * Performs an operation to transform into Int
   * <p>
   * If the operation in memory is empty, construct an empty transform operation. If an operation
   * already exists and is not completed, then it adds an empty transform operation in the leftmost
   * available space. If the operation is completed, then transform the result.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void asIntOperation() {
    if (Operations.isNull()) {
      Operations.setOperation(new Add());
      Operations.setValues(ScrabbleFactory.getInt(0));
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
      Notifications.addMessage("Insert the object to transform into Int");
      Notifications.showLastMessage();
      Operations.addOperationSign("Int  (");
      Operations.leaveSignInQueue(")");

    } else if (!Operations.isComplete()) {
      Operations.setValues(new Add());
      Operations.setValues(ScrabbleFactory.getInt(0));
      Notifications.addMessage("Insert the object to transform into Int");
      Notifications.showLastMessage();
      Operations.addOperationSign("Int  (");
      Operations.leaveSignInQueue(")");
    } else if (Operations.isComplete()) {
      Operations.asInt();
      Result.cleanResult();
      Calculate.calculate();
    }
  }

  /**
   * Performs an operation to transform into Float
   * <p>
   * If the operation in memory is empty, construct an empty transform operation. If an operation
   * already exists and is not completed, then it adds an empty transform operation in the leftmost
   * available space. If the operation is completed, then transform the result.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void asFloatOperation() {
    if (Operations.isNull()) {
      Operations.setOperation(new Add());
      Operations.setValues(ScrabbleFactory.getFloat(0));
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
      Notifications.addMessage("Insert the object to transform into Float");
      Notifications.showLastMessage();
      Operations.addOperationSign("Float  (");
      Operations.leaveSignInQueue(")");

    } else if (!Operations.isComplete()) {
      Operations.setValues(new Add());
      Operations.setValues(ScrabbleFactory.getFloat(0));
      Notifications.addMessage("Insert the object to transform into Float");
      Notifications.showLastMessage();
      Operations.addOperationSign("Float  (");
      Operations.leaveSignInQueue(")");
    } else if (Operations.isComplete()) {
      Operations.asFloat();
      Result.cleanResult();
      Calculate.calculate();
    }
  }

  /**
   * Performs an operation to transform into Binary
   * <p>
   * If the operation in memory is empty, construct an empty transform operation. If an operation
   * already exists and is not completed, then it adds an empty transform operation in the leftmost
   * available space. If the operation is completed, then transform the result.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void asBinaryOperation() {
    if (Operations.isNull()) {
      Operations.setOperation(new Add());
      Operations.setValues(ScrabbleFactory.getBinary("0"));
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
      Notifications.addMessage("Insert the object to transform into Binary");
      Notifications.showLastMessage();
      Operations.addOperationSign("Bin  (");
      Operations.leaveSignInQueue(")");

    } else if (!Operations.isComplete()) {
      Operations.setValues(new Add());
      Operations.setValues(ScrabbleFactory.getBinary("0"));
      Notifications.addMessage("Insert the object to transform into Binary");
      Notifications.showLastMessage();
      Operations.addOperationSign("Bin  (");
      Operations.leaveSignInQueue(")");

    } else if (Operations.isComplete()) {
      Operations.asBinary();
      Result.cleanResult();
      Calculate.calculate();
    }
  }

  /**
   * Performs an operation to transform into Boolean
   * <p>
   * If the operation in memory is empty, construct an empty transform operation. If an operation
   * already exists and is not completed, then it adds an empty transform operation in the leftmost
   * available space. If the operation is completed, then transform the result.
   * <p>
   * Add the corresponding notifications to guide the use of the operation and insert the signs of
   * the corresponding operation.
   */
  public static void asBooleanOperation() {
    if (Operations.isNull()) {
      Operations.setOperation(new And());
      Operations.setValues(ScrabbleFactory.getBoolean(true));
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
      Notifications.addMessage("Insert the object to transform into Boolean");
      Notifications.showLastMessage();
      Operations.addOperationSign("Bool  (");
      Operations.leaveSignInQueue(")");

    } else if (!Operations.isComplete()) {
      Operations.setValues(new And());
      Operations.setValues(ScrabbleFactory.getBoolean(true));
      Notifications.addMessage("Insert the object to transform into Boolean");
      Notifications.showLastMessage();
      Operations.addOperationSign("Bool  (");
      Operations.leaveSignInQueue(")");
    } else if (Operations.isComplete()) {
      Operations.asBoolean();
      Result.cleanResult();
      Calculate.calculate();
    }
  }
}


