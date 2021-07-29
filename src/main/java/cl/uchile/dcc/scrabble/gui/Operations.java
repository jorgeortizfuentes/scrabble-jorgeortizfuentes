package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.operations.Operation;
import cl.uchile.dcc.scrabble.types.ScrabbleType;
import java.util.Stack;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;

public class Operations {

  private static final TilePane operationsBox = new TilePane();
  private static final ScrollPane operationsBoxScroll = new ScrollPane(getOperationBox());
  private static Operation operation = null;

  private static final Stack operationsStack = new Stack();


  public static boolean isNull() {
    return operation == null;

  }

  public static boolean isComplete() {
    if (Operations.isNull()) {
      return false;
    } else {
      return operation.isComplete();
    }

  }

  public static void setOperation(Operation op) {
    operation = op;
  }

  public static void setValues(Operation op) {
    operation.setValues(op);
  }

  public static void cleanOperation() {
    Operations.operation = null;
  }

  public static void asString() {
    operation = operation.asString();
  }

  public static void asInt() {
    operation = operation.asInt();
  }

  public static void asFloat() {
    operation = operation.asFloat();
  }

  public static void asBinary() {
    operation = operation.asBinary();
  }

  public static void asBoolean() {
    operation = operation.asBoolean();
  }

  public static ScrabbleType evaluate() {
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

  // Operation Box

  public static ScrollPane getOperationsBoxScroll() {
    operationsBoxScroll.setPrefSize(200, 250);
    operationsBoxScroll.setFitToHeight(true);
    operationsBoxScroll.setFitToWidth(true);
    return operationsBoxScroll;
  }

  public static TilePane getOperationBox() {

    operationsBox.setVgap(15);
    operationsBox.setMinHeight(250);

    operationsBox.setPrefColumns(12);
    operationsBox.setPrefRows(8);
    operationsBox.setPadding(new Insets(20, 20, 20, 20)); // 15 pixels border
    operationsBox.setAlignment(Pos.TOP_CENTER);
    return operationsBox;
  }

  public static void cleanOperationBox() {
    operationsStack.clear();
    operationsBox.getChildren().clear();
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
    operationsBox.getChildren().add(op);

  }

  public static void addObjectWithLabel(Operation s) {
    var op = DesignFactory.getValueOperationLabel(s.toString());
    var opType = DesignFactory.getTypeObjectLabel(s.getLabel(), s.getColor());
    operationsStack.add(opType);
    operationsStack.add(op);
    Operations.showLastOperation(3);

  }

  public static void showLastOperation() {
    var last = (Label) operationsStack.pop();
    operationsBox.getChildren().add(last);
    if (last.getText() == ")" && !operationsStack.isEmpty()) {
      var secondLast = (Label) operationsStack.pop();
      operationsBox.getChildren().add(secondLast);
    }
  }

  public static void showLastOperation(int n) {
    for (int i = 0; i < n; i++) {
      showLastOperation();

    }

  }


}
