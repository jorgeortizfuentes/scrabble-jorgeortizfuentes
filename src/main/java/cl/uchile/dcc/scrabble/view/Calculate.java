package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.controller.Operation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Class to calculate operations and get the Calculate Box
 *
 * @author Jorge Luis Ortiz Fuentes
 */
public class Calculate {

  /**
   * HorizontalBox to insert the buttons for calculating
   */
  private static HBox calculateBox;


  /**
   * Get Calculate Box with buttons for calculating
   *
   * @return an horizontal box with buttons
   */
  public static HBox getCalculateBox() {
    calculateBox = new HBox(10);// 10 pixels separation
    calculateBox.setPadding(new Insets(15)); // 15 pixels border
    calculateBox.setAlignment(Pos.TOP_CENTER);
    calculateBox.getChildren().add(getCalculateButton());
    calculateBox.getChildren().add(getCleanButton());
    return calculateBox;

  }

  /**
   * Get a button to calculate. Executes as an action the method calculate
   *
   * @return calculate button
   */
  public static Button getCalculateButton() {
    var button = DesignFactory.getHighlightButton();
    button.setText("CALCULATE");
    button.setOnAction(Calculate::calculate);
    return button;

  }

  /**
   * Get a button to clean. Executes as an action the method clean
   *
   * @return clean button
   */
  public static Button getCleanButton() {
    var button = DesignFactory.getButton2();
    button.setText("CLEAN");
    button.setOnAction(Calculate::clean);
    return button;

  }

  /**
   * Execute the calculate method
   *
   * @param event Event that initializes this operation
   */
  public static void calculate(ActionEvent event) {
    Calculate.calculate();
  }

  /**
   * Calculate operation
   * <p>
   * If the operation has all the arguments, then evaluate and display the result. If the evaluation
   * is a Null, it indicates that the operation is invalid. If the operation is missing arguments,
   * it indicates an error.
   */
  public static void calculate() {
    if (!Operations.isNull() && Operations.isComplete()) {
      var result = (Operation) Operations.evaluate();
      Result.setResult(result);

      Notifications.addMessage("Operation completed");
      Notifications.showLastMessage();

    } else if (Operations.isNull()) {
      Notifications.addMessage("Invalid operation");
      Notifications.showLastMessage();
      Result.setErrorResult();

    } else {
      String current = Notifications.getCurrentMessage();
      if (!current.contains("Error")) {
        Notifications.addMessage("Error. " + current);
        Notifications.showLastMessage();
      }

    }
  }

  /**
   * Clean operation
   * <p>
   * Clears the notification tray, the result and the operation
   *
   * @param event Event that initializes this operation
   */
  public static void clean(ActionEvent event) {
    Notifications.cleanMessage();
    Operations.cleanOperation();
    Result.cleanResult();
    Operations.cleanOperationBox();

  }

}
