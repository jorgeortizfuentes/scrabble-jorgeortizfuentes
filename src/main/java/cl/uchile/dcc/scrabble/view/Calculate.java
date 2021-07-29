package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.controller.Operation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Calculate {

  private static HBox calculateBox;


  public static HBox getCalculateBox() {
    calculateBox = new HBox(10);// 10 pixels separation
    calculateBox.setPadding(new Insets(15)); // 15 pixels border
    calculateBox.setAlignment(Pos.TOP_CENTER);
    calculateBox.getChildren().add(getCalculateButton());
    calculateBox.getChildren().add(getCleanButton());
    return calculateBox;

  }

  public static Button getCalculateButton() {
    var button = DesignFactory.getHighlightButton();
    button.setText("CALCULATE");
    button.setOnAction(Calculate::calculate);
    return button;

  }

  public static Button getCleanButton() {
    var button = DesignFactory.getButton2();
    button.setText("CLEAN");
    button.setOnAction(Calculate::clean);
    return button;

  }

  public static void calculate(ActionEvent event) {
    Calculate.calculate();
  }

  public static void calculate() {
    if (!Operations.isNull() && Operations.isComplete()) {
      var result = (Operation) Operations.evaluate();
      Result.setResult(result);

      //Notifications.cleanMessage();
      Notifications.addMessage("Operation completed");
      Notifications.showLastMessage();
      //Operations.cleanOperation();

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

  public static void clean(ActionEvent event) {
    Notifications.cleanMessage();
    Operations.cleanOperation();
    Result.cleanResult();
    Operations.cleanOperationBox();

  }

}
