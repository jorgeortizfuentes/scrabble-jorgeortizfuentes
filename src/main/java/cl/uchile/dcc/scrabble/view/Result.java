package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.controller.Operation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Result {

  public static Label resultLabel = new Label("");
  public static HBox resultBox = new HBox(10);

  public static void setResult(Operation r) {
    resultBox.getChildren().clear();
    resultBox.getChildren().add(resultLabel);
    if (r == null) {
      Notifications.addMessage("Invalid operation");
      Notifications.showLastMessage();
      Result.setErrorResult();

    } else {
      String content = String.valueOf(r);
      resultLabel.setText("= " + content);
      var typeLabel = DesignFactory.getTypeObjectLabel(r.getLabel(), r.getColor());
      typeLabel.setTranslateY(resultLabel.getFont().getSize() * 0.65);
      resultBox.getChildren().add(typeLabel);
    }

  }


  public static void cleanResult() {
    resultBox.getChildren().clear();
    resultLabel.setText("");
    resultBox.getChildren().add(resultLabel);
  }

  public static HBox getResultBox() {
    resultBox.setPadding(new Insets(15)); // 15 pixels border
    resultBox.setAlignment(Pos.TOP_CENTER);
    resultBox.getChildren().add(resultLabel());

    return resultBox;
  }

  public static Label resultLabel() {
    resultLabel = new Label("");
    resultLabel.setStyle("-fx-font-size: 32px;"
        + "-fx-font-weight: bold");
    return resultLabel;

  }

  public static void setErrorResult() {
    resultLabel.setText("= ERROR");

  }

}
