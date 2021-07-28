package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.operations.Operation;
import cl.uchile.dcc.scrabble.types.ScrabbleFactory;
import cl.uchile.dcc.scrabble.types.ScrabbleString;
import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Operations {
  private static HBox showOperationBox = new HBox();
  private static Operation operation = null;

  private static Stack operationsStack = new Stack();


  public static boolean isNull() {
    if (operation == null){
      return true;
    } else {
      return false;
    }

  }

  public static boolean isComplete() {
    if (Operations.isNull()) {
      return false;
    } else {
      return operation.isComplete();
    }

  }

  public static void setOperation(Operation op){
    operation = op;
  }

  public static void setValues(Operation op){
    operation.setValues(op);
  }

    public static void cleanOperation(){
    Operations.operation = null;
  }

  public static ScrabbleType evaluate(){
    return operation.evaluate();
  }


  public static void addValueToOperation(Operation v) {
    if (!isComplete() && !isNull()) {
      operation.setValues(v);
    } else if (isNull()) {
      Notifications.addMessage("Error. Insert an operation first");
    } else if (isComplete()) {
      Notifications.addMessage("Error. There is no space to add this element");
    }
    Notifications.showLastMessage();

  }






  // Show Operation Box

  public static HBox getOperationBox() {
    showOperationBox.setSpacing(5);
    showOperationBox.setPadding(new Insets(15)); // 15 pixels border
    showOperationBox.setAlignment(Pos.TOP_CENTER);

    return showOperationBox;
  }

  public static void leaveSignInQueue(String s) {
    var op = new Label(s);
    op.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    operationsStack.add(op);

  }

  public static void addOperationSign(String s) {
    var op = new Label(s);
    op.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    showOperationBox.getChildren().add(op);

  }

  public static void addStringSign(ScrabbleString s) {
    var op = new Label(s.toString());
    op.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    var opType = new Label("Str");
    opType.setTranslateY(op.getFont().getSize() * 0.65);


    operationsStack.add(opType);
    operationsStack.add(op);


  }


  public static void showLastOperation() {
    var last = (Label) operationsStack.pop();
    showOperationBox.getChildren().add(last);
  }
}
