package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.controller.Operation;
import java.util.Stack;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;

/**
 * Class that implements the operations and allows to get the operation box.
 *
 * @author Jorge Luis Ortiz Fuentes
 */
public class Operations {

  /**
   * TilePane with Operations
   */
  private static final TilePane operationsBox = new TilePane();

  /**
   * ScrollPane with Operations Box
   */
  private static final ScrollPane operationsBoxScroll = new ScrollPane(getOperationBox());
  /**
   * Stack with operations
   */
  private static final Stack<Object> operationsStack = new Stack<>();
  /**
   * Operation in the memory
   */
  private static Operation operation = null;

  /**
   * Get if the operation in memory is null
   *
   * @return true or false
   */
  public static boolean isNull() {
    return operation == null;

  }

  /**
   * Get if the operation in memory is complete
   *
   * @return true or false
   */
  public static boolean isComplete() {
    if (Operations.isNull()) {
      return false;
    } else {
      return operation.isComplete();
    }

  }

  /**
   * Set the operation in memory
   *
   * @param op a Scrabble operation
   */
  public static void setOperation(Operation op) {
    operation = op;
  }

  /**
   * Insert values or operations in the available spaces of the operation in memory
   *
   * @param op a Scrabble operation
   */
  public static void setValues(Operation op) {
    operation.setValues(op);
  }

  /**
   * Clean the operation in memory
   */
  public static void cleanOperation() {
    Operations.operation = null;
  }

  /**
   * Convert the operation in memory to String
   */
  public static void asString() {
    operation = operation.asString();
  }

  /**
   * Convert the operation in memory to Int
   */
  public static void asInt() {
    operation = operation.asInt();
  }

  /**
   * Convert the operation in memory to Float
   */
  public static void asFloat() {
    operation = operation.asFloat();
  }

  /**
   * Convert the operation in memory to Binary
   */
  public static void asBinary() {
    operation = operation.asBinary();
  }

  /**
   * Convert the operation in memory to Boolean
   */
  public static void asBoolean() {
    operation = operation.asBoolean();
  }

  /**
   * Evaluate the operation in memory
   */
  public static Operation evaluate() {
    return (Operation) operation.evaluate();
  }

  /**
   * If the operation is neither complete nor null, add values or operations. If not, it displays
   * errors.
   *
   * @param v a Scrabble Operation
   */
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

  /**
   * Get Box Scroll with Operation Box
   *
   * @return a ScrollPane
   */
  public static ScrollPane getOperationsBoxScroll() {
    operationsBoxScroll.setPrefSize(200, 250);
    operationsBoxScroll.setFitToHeight(true);
    operationsBoxScroll.setFitToWidth(true);
    return operationsBoxScroll;
  }

  /**
   * Get a designed Operation Box
   *
   * @return a TilePane
   */
  public static TilePane getOperationBox() {

    operationsBox.setVgap(15);
    operationsBox.setMinHeight(250);

    operationsBox.setPrefColumns(12);
    operationsBox.setPrefRows(8);
    operationsBox.setPadding(new Insets(20, 20, 20, 20)); // 15 pixels border
    operationsBox.setAlignment(Pos.TOP_CENTER);
    return operationsBox;
  }

  /**
   * Clean the Operation Box
   */
  public static void cleanOperationBox() {
    operationsStack.clear();
    operationsBox.getChildren().clear();
  }

  /**
   * Leave in queue a sign of an operation
   *
   * @param s a sign
   */
  public static void leaveSignInQueue(String s) {
    var op = new Label(s);
    op.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    operationsStack.add(op);

  }

  /**
   * Adds a sign to the operation display
   *
   * @param s a sign
   */
  public static void addOperationSign(String s) {
    var op = new Label(s);
    op.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    operationsBox.getChildren().add(op);

  }

  /**
   * Add a object with its label to operation display
   *
   * @param s a Scrabble operation
   */
  public static void addObjectWithLabel(Operation s) {
    var op = DesignFactory.getValueOperationLabel(s.toString());
    var opType = DesignFactory.getTypeObjectLabel(s.getLabel(), s.getColor());
    operationsStack.add(opType);
    operationsStack.add(op);
    Operations.showLastOperation(3);

  }


  /**
   * Shows the last operation once
   */
  public static void showLastOperation() {
    var last = (Label) operationsStack.pop();
    operationsBox.getChildren().add(last);
    if (last.getText().equals(")") && !operationsStack.isEmpty()) {
      var secondLast = (Label) operationsStack.pop();
      operationsBox.getChildren().add(secondLast);
    }
  }

  /**
   * Shows the last n operations
   */
  public static void showLastOperation(int n) {
    for (int i = 0; i < n; i++) {
      showLastOperation();

    }

  }


}
