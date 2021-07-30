package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.controller.Operation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Class that implements the result and allows to get the result box.
 *
 * @author Jorge Luis Ortiz Fuentes
 */
public class Result {

  /**
   * Label with the result of the operation in memory
   */
  public static Label resultLabel = new Label("");

  /**
   * Horizontal Box with the result
   */
  public static HBox resultBox = new HBox(10);

  /**
   * Set the result in resultBox
   *
   * @param r a Scrabble Operation
   */
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

  /**
   * Clean the result box
   */
  public static void cleanResult() {
    resultBox.getChildren().clear();
    resultLabel.setText("");
    resultBox.getChildren().add(resultLabel);
  }

  /**
   * Get the result box
   *
   * @return horizontal box
   */
  public static HBox getResultBox() {
    resultBox.setPadding(new Insets(15)); // 15 pixels border
    resultBox.setAlignment(Pos.TOP_CENTER);
    resultBox.getChildren().add(getResultLabel());

    return resultBox;
  }

  /**
   * Get the result label
   *
   * @return a label with the result
   */
  public static Label getResultLabel() {
    resultLabel = new Label("");
    resultLabel.setStyle("-fx-font-size: 32px;"
        + "-fx-font-weight: bold");
    return resultLabel;

  }

  /**
   * Set error in the result label
   */
  public static void setErrorResult() {
    resultLabel.setText("= ERROR");

  }

}
