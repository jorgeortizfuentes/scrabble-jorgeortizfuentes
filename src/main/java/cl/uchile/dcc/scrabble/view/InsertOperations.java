package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.controller.Add;
import cl.uchile.dcc.scrabble.controller.And;
import cl.uchile.dcc.scrabble.controller.Div;
import cl.uchile.dcc.scrabble.controller.Mult;
import cl.uchile.dcc.scrabble.controller.Negate;
import cl.uchile.dcc.scrabble.controller.Or;
import cl.uchile.dcc.scrabble.controller.Subt;
import cl.uchile.dcc.scrabble.controller.ScrabbleFactory;
import javafx.event.ActionEvent;

public class InsertOperations {

  public static void addOperation(ActionEvent event) {
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


  public static void subtOperation(ActionEvent event) {
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

  public static void multOperation(ActionEvent event) {
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
    Operations.leaveSignInQueue("×");
  }

  public static void divOperation(ActionEvent event) {
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
    Operations.leaveSignInQueue("÷");
  }

  public static void andOperation(ActionEvent actionEvent) {
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
    Operations.leaveSignInQueue("∧");

  }

  public static void orOperation(ActionEvent actionEvent) {
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
    Operations.leaveSignInQueue("∨");

  }

  public static void negateOperation(ActionEvent actionEvent) {
    if (Operations.isNull() || Operations.isComplete()) {
      Operations.setOperation(new Negate());
      Notifications.addMessage("Press \"Calculate\" to obtain the result");
    } else {
      Operations.setValues(new Negate());
    }
    Notifications.addMessage("Insert the first logic element or an operation");
    Notifications.showLastMessage();
    Operations.addOperationSign("( ¬");
    Operations.leaveSignInQueue(")");

  }

  public static void asStringOperation(ActionEvent actionEvent) {
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

      //Operations.setValues(new Negate());
    } else if (Operations.isComplete()) {
      Operations.asString();
      Result.cleanResult();
      Calculate.calculate();
    }
  }

  public static void asIntOperation(ActionEvent actionEvent) {
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

  public static void asFloatOperation(ActionEvent actionEvent) {
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

  public static void asBinaryOperation(ActionEvent actionEvent) {
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

  public static void asBooleanOperation(ActionEvent actionEvent) {
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


