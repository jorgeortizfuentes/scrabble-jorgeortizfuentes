package cl.uchile.dcc.scrabble.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Result {

  public static Label resultLabel = new Label("");

  public static void setResult(String r) {
    resultLabel.setText(r);
  }

  public static void cleanResult() {
    resultLabel.setText("");
  }

  public static VBox getResultBox() {
    var resultBox = new VBox(10);// 10 pixels separation
    resultBox.setPadding(new Insets(15)); // 15 pixels border
    resultBox.setAlignment(Pos.TOP_CENTER);
    var titleResult = new Label("Result");

    resultBox.getChildren().add(titleResult);
    resultBox.getChildren().add(resultLabel());

    resultBox.getChildren().add(Calculate.getCalculateBox());
    return resultBox;
  }

  public static Label resultLabel() {
    resultLabel = new Label("");
    resultLabel.setLayoutX(600);
    resultLabel.setLayoutY(350);
    resultLabel.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    return resultLabel;

  }

}
