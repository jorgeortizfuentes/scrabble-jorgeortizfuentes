package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.types.ScrabbleBinary;
import cl.uchile.dcc.scrabble.types.ScrabbleBoolean;
import cl.uchile.dcc.scrabble.types.ScrabbleFloat;
import cl.uchile.dcc.scrabble.types.ScrabbleInt;
import cl.uchile.dcc.scrabble.types.ScrabbleString;
import cl.uchile.dcc.scrabble.types.ScrabbleType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Result {

  public static Label resultLabel = new Label("");
  public static HBox resultBox = new HBox(10);

  public static void setResult(ScrabbleType r) {
    resultBox.getChildren().clear();
    resultBox.getChildren().add(resultLabel);
    if (r == null) {
      Notifications.addMessage("Invalid operation");
      Notifications.showLastMessage();
      Result.setErrorResult();

    } else {
      Label typeLabel = null;
      String content = String.valueOf(r);

      if (r instanceof ScrabbleString) {
        typeLabel = TypeLabelsFactory.getStringLabel();

      } else if (r instanceof ScrabbleInt) {
        typeLabel = TypeLabelsFactory.getIntLabel();

      } else if (r instanceof ScrabbleFloat) {
        typeLabel = TypeLabelsFactory.getFloatLabel();

      } else if (r instanceof ScrabbleBinary) {
        typeLabel = TypeLabelsFactory.getBinaryLabel();

      } else if (r instanceof ScrabbleBoolean) {
        typeLabel = TypeLabelsFactory.getBooleanLabel();

      }
      resultLabel.setText("= " + content);
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

    //resultBox.getChildren().add(Calculate.getCalculateBox());
    return resultBox;
  }

  public static Label resultLabel() {
    resultLabel = new Label("");
    resultLabel.setStyle("-fx-font-size: 32px;"
        + "-fx-font-weight: bold");
    return resultLabel;

  }
  public static void setErrorResult() {
    //var error = resultLabel();
    //error.setText("= ERROR");
    resultLabel.setText("= ERROR");

  }

}
