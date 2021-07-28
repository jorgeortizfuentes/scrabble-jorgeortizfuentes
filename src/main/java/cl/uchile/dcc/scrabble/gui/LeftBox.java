package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.operations.Add;
import cl.uchile.dcc.scrabble.operations.Subt;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftBox {

  private static VBox leftBox;


  public static VBox getLeftBox() {
    leftBox = new VBox(10);// 10 pixels separation
    leftBox.setPadding(new Insets(15)); // 15 pixels border

    leftBox.getChildren().add(addButton());
    leftBox.getChildren().add(subtractButton());
    return leftBox;
  }

  private static Button addButton() {
    var button = new Button("ADD ( □ + □ )");
    button.setLayoutX(100);
    button.setLayoutY(100);
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: #AFBBF2; "
        + "-fx-pref-width: 200px;"
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    button.setOnAction(event -> {

      if (Operations.isNull()){
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



      });
    return button;

  }

  private static Button subtractButton() {
    var button = new Button("SUBTRACT ( □ - □ )");
    button.setLayoutX(100);
    button.setLayoutY(200);
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: #AFBBF2; "
        + "-fx-pref-width: 200px;"
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    //button.setOnAction(App::playSound);
    button.setOnAction(event -> {
      if (Operations.isNull()){
        Operations.setOperation(new Subt());
        Notifications.addMessage("Press \"Calculate\" to obtain the result");
      } else {
        Operations.setValues(new Subt());
      }
      Notifications.addMessage("Insert the subtrahend or an operation");
      Notifications.addMessage("Insert the minuend or an operation");
      Notifications.showLastMessage();
    });
    return button;
  }

}
