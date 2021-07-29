package cl.uchile.dcc.scrabble.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class DesignFactory {

  public static final String mainColor = "#97CAEF"; // #AFBBF2
  public static final String highlightColor = "#55BCC9";

  public static Button getButton1() {
    var button = new Button();
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: " + mainColor + ";"
        + "-fx-pref-width: 170px;"
        + "-fx-padding: 13 10 13 10;"
        //+ "-fx-background-radius: 10;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    return button;
  }

  public static Button getButton2() {
    var button = DesignFactory.getButton1();
    String style = button.getStyle();
    style = style.replace("-fx-pref-width: 170px", "");
    button.setStyle(style);
    return button;

  }

  public static Button getHighlightButton() {
    var button = new Button();
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: " + highlightColor + ";"
        + "-fx-padding: 13 13 13 13;"
        //+ "-fx-background-radius: 10;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    return button;

  }

  public static TextField getTextField() {
    var tf = new TextField();
    tf.setStyle("-fx-background-color: transparent; "
        + "-fx-border-color: " + mainColor + ";"
        + "-fx-border-width: 1;"
        + "-fx-border-style: solid;"
        + "-fx-pref-width: 200px;"
        + "-fx-padding: 15 15 15 15;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: normal");
    return tf;

  }

  public static ChoiceBox getChoiceBox() {
    var cb = new ChoiceBox();
    cb.setStyle("-fx-background-color: transparent; "
        + "-fx-border-color: " + mainColor + ";"
        + "-fx-border-width: 1;"
        + "-fx-border-style: solid;"
        + "-fx-pref-width: 150px;"
        + "-fx-padding: 10 15 10 15;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    return cb;
  }

  public static Label getTitleLabel(String s) {
    var title = new Label(s);
    title.setAlignment(Pos.CENTER);

    title.setStyle("-fx-font-size: 18px; "
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-weight: bold");
    return title;

  }

  public static Label getNotificationLabel() {
    var l = new Label("Select an operation");
    l.setAlignment(Pos.CENTER);
    l.setStyle("-fx-font-size: 18px;"
        + "-fx-padding: 15 0 15 0;"
        + "-fx-font-weight: bold");
    return l;

  }

  public static Label getValueOperationLabel(String s) {
    var l = new Label(s);
    l.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    return l;

  }

  public static Label getTypeObjectLabel(String tag, String color) {
    var opType = new Label(tag);
    opType.setTextFill(Color.WHITE);
    opType.setStyle("-fx-font-size: 10px;"
        + "-fx-font-weight: bold;"
        + "-fx-background-color: " + color + ";"
        + "-fx-padding: 3,4,3,4");
    opType.setTranslateY(opType.getFont().getSize() * 0.80);
    return opType;
  }

}
