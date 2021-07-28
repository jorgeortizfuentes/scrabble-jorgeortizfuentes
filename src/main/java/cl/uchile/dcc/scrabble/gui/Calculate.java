package cl.uchile.dcc.scrabble.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    var button = new Button("CALCULATE");
    button.setLayoutX(400);
    button.setLayoutY(500);
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: #AFBBF2; "
        //+ "-fx-cell-size: 20"
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    button.setOnAction(Calculate::calculate);
    return button;

  }

  public static Button getCleanButton() {
    var button = new Button("CLEAN");
    button.setLayoutX(400);
    button.setLayoutY(500);
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: #AFBBF2; "
        //+ "-fx-cell-size: 20"
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    button.setOnAction(event -> {
      Notifications.cleanMessage();
      Operations.cleanOperation();
      Result.cleanResult();

    });
    return button;

  }

  public static void calculate(ActionEvent event) {

    if (!Operations.isNull() || Operations.isComplete()){
      var result = Operations.evaluate();

      Result.setResult(String.valueOf(result));

      Notifications.cleanMessage();
      Operations.cleanOperation();

    } else{
      String last = Notifications.getLastMessage();
      Notifications.addMessage("Error. "+ last);
      Notifications.showLastMessage();
    }
  }

}
