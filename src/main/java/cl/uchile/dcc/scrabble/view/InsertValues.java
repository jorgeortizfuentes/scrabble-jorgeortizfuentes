package cl.uchile.dcc.scrabble.view;

import cl.uchile.dcc.scrabble.controller.ScrabbleFactory;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Class with Operation Box and actions to insert values to operations
 */
public class InsertValues {

  /**
   * Choice Box to select an object type
   */
  private static ChoiceBox<String> valueTypeBox;

  /**
   * Text Field to insert an object value
   */
  private static TextField valueText;

  /**
   * Get a Vertical Box with the form to insert values
   *
   * @return a Vertical Box with buttons and a title
   */
  public static VBox getValuesBox() {
    var valuesBox = new VBox();

    var title = DesignFactory.getTitleLabel("Insert values");
    valuesBox.getChildren().add(title);
    valuesBox.getChildren().add(getButtonsBar());

    valuesBox.setAlignment(Pos.BOTTOM_CENTER);
    valuesBox.setPadding(new Insets(75, 0, 0, 0));
    return valuesBox;
  }

  /**
   * Get a Horizontal Box with the buttons
   *
   * @return a horizontal box
   */
  private static HBox getButtonsBar() {
    var buttonBar = new HBox(10);
    buttonBar.setAlignment(Pos.CENTER);

    valueTypeBox = DesignFactory.getChoiceBox();

    valueTypeBox.setValue("Select a type");
    valueTypeBox.getItems().addAll("String", "Int", "Float", "Binary", "Boolean");

    valueText = DesignFactory.getTextField();

    buttonBar.getChildren().addAll(valueTypeBox, valueText, getInsertButton());
    return buttonBar;
  }

  /**
   * Get Insert Button with the method sendValue of action
   *
   * @return an insert button
   */
  public static Button getInsertButton() {
    var button = DesignFactory.getButton2();
    button.setText("INSERT");
    button.setOnAction(InsertValues::sendValue);

    return button;

  }

  /**
   * Sends the inserted value to the operation in memory
   * <p>
   * If there is no operation, returns error. If it is possible to insert a value, then it checks
   * the type of the value, constructs it and adds it to both the operation and the display field.
   *
   * @param event an event
   */
  public static void sendValue(ActionEvent event) {
    var inputType = valueTypeBox.getValue();
    var inputValue = valueText.getCharacters().toString();

    if (Operations.isNull() || Operations.isComplete()) {
      Notifications.addMessage("Error. Select a operation first.");
      Notifications.showLastMessage();
    } else {
      valueText.clear();
      switch (inputType) {
        case "String":

          var strObj = ScrabbleFactory.getString(inputValue);
          Operations.addValueToOperation(strObj);
          Operations.addObjectWithLabel(strObj);

          break;
        case "Int":
          try {
            var intObj = ScrabbleFactory.getInt(Integer.parseInt(inputValue));
            Operations.addValueToOperation(intObj);
            Operations.addObjectWithLabel(intObj);
          } catch (NumberFormatException s) {
            var current = Notifications.getCurrentMessage();
            if (!current.contains("Invalid Int")) {
              String actual = "Invalid Int. " + current;
              Notifications.addMessage(actual);
              Notifications.showLastMessage();
            }
          }
          break;
        case "Float":
          try {
            var floatObj = ScrabbleFactory.getFloat(Float.parseFloat(inputValue));
            Operations.addValueToOperation(floatObj);
            Operations.addObjectWithLabel(floatObj);
          } catch (NumberFormatException s) {
            var current = Notifications.getCurrentMessage();
            if (!current.contains("Invalid Float")) {
              String actual = "Invalid Float. " + current;
              Notifications.addMessage(actual);
              Notifications.showLastMessage();
            }
          }

          break;
        case "Boolean":
          inputValue = inputValue.toLowerCase();
          List<String> validBoolean = Arrays.asList("true", "false");
          if (validBoolean.contains(inputValue)) {
            var boolObj = ScrabbleFactory.getBoolean(Boolean.parseBoolean(inputValue));
            Operations.addValueToOperation(boolObj);
            Operations.addObjectWithLabel(boolObj);
          } else {
            var current = Notifications.getCurrentMessage();
            if (!current.contains("Invalid Boolean")) {
              String actual = "Invalid Boolean. " + current;
              Notifications.addMessage(actual);
              Notifications.showLastMessage();
            }
          }

          break;
        case "Binary":
          try {
            var binObj = ScrabbleFactory.getBinary(inputValue);
            Operations.addValueToOperation(binObj);
            Operations.addObjectWithLabel(binObj);
          } catch (AssertionError s) {
            var current = Notifications.getCurrentMessage();
            if (!current.contains("Invalid Binary")) {
              String actual = "Invalid Binary. " + current;
              Notifications.addMessage(actual);
              Notifications.showLastMessage();
            }
          }

          break;
        default:
          Notifications.addMessage("Select a type");
          Notifications.showLastMessage();
      }
    }


  }

}
