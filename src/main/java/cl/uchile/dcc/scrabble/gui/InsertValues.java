package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.types.ScrabbleFactory;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InsertValues {

  private static ChoiceBox valueTypeBox;
  private static TextField valueText;

  public static VBox getValuesBox() {
    var valuesBox = new VBox();

    var title = FormFactory.getTitleLabel("Insert values");
    valuesBox.getChildren().add(title);
    valuesBox.getChildren().add(buttonsBar());

    valuesBox.setAlignment(Pos.BOTTOM_CENTER);
    valuesBox.setPadding(new Insets(150,0,0,0));
    return valuesBox;
  }

  private static HBox buttonsBar() {
    var buttonBar = new HBox(10);
    buttonBar.setAlignment(Pos.CENTER);

    // Create the buttons to go into the ButtonBar
    valueTypeBox = FormFactory.getChoiceBox();

    valueTypeBox.setValue("Select a type");
    valueTypeBox.getItems().addAll("String", "Int", "Float", "Binary", "Boolean");

    valueText = FormFactory.getTextField();

    buttonBar.getChildren().addAll(valueTypeBox, valueText, getInsertButton());
    return buttonBar;
  }

  public static Button getInsertButton() {
    var button = FormFactory.getButton2();
    button.setText("INSERT");
    button.setOnAction(InsertValues::sendValue);

    return button;

  }

  public static void sendValue(ActionEvent event) {
    var inputType = valueTypeBox.getValue().toString();
    var inputValue = valueText.getCharacters().toString();

    if (Operations.isNull() || Operations.isComplete()){
      Notifications.addMessage("Error. Select a operation first.");
      Notifications.showLastMessage();
    } else {
      valueText.clear();
      switch(inputType)
      {
        case "String":
          var strObj = ScrabbleFactory.getString(inputValue);
          Operations.addValueToOperation(strObj);
          Operations.addObjectWithLabel(strObj);
          break;
        case "Int":
          var intObj = ScrabbleFactory.getInt(Integer.valueOf(inputValue));
          Operations.addValueToOperation(intObj);
          Operations.addObjectWithLabel(intObj);
          break;
        case "Float":
          var floatObj = ScrabbleFactory.getFloat(Float.valueOf(inputValue));
          Operations.addValueToOperation(floatObj);
          Operations.addObjectWithLabel(floatObj);
          break;
        case "Boolean":
          var boolObj = ScrabbleFactory.getBoolean(Boolean.valueOf(inputValue));
          Operations.addValueToOperation(boolObj);
          Operations.addObjectWithLabel(boolObj);
          break;
        case "Binary":
          var binObj = ScrabbleFactory.getBinary(inputValue);
          Operations.addValueToOperation(binObj);
          Operations.addObjectWithLabel(binObj);
          break;
        default:
          Notifications.addMessage("Select a type");
          Notifications.showLastMessage();
      }
    }




  }

}
