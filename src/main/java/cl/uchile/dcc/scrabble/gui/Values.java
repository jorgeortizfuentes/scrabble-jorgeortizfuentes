package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.types.ScrabbleFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Values {

  private static ChoiceBox valueTypeBox;
  private static TextField valueText;

  public static HBox getValuesBox() {
    var buttonBar = new HBox(10);
    buttonBar.setPadding(new Insets(15)); // 15 pixels border
    buttonBar.setAlignment(Pos.TOP_CENTER);

    // Create the buttons to go into the ButtonBar
    valueTypeBox = new ChoiceBox(FXCollections.observableArrayList(
        "String", "Int", "Float", "Binary", "Boolean"));
    valueTypeBox.setValue("Select a type");

    valueText = new TextField();

    var insertButton = new Button("Insert");
    insertButton.setOnAction(Values::sendValue);
    buttonBar.getChildren().addAll(valueTypeBox, valueText, insertButton);

    // add a listener
    //valueTypeBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

      // if the item of the list is changed
      //public void changed(ObservableValue ov, Number value, Number new_value) {

        // set the text for the messageLabel to the selected item
        //l1.setText(st[new_value.intValue()] + " selected");
     // }
    //});
    return buttonBar;
  }

  public static void sendValue(ActionEvent event) {
    var inputType = valueTypeBox.getValue().toString();
    var inputValue = valueText.getCharacters().toString();


    switch(inputType)
    {
      case "String":
        Operations.addValueToOperation(ScrabbleFactory.getString(inputValue));
        Operations.addStringSign(ScrabbleFactory.getString(inputValue));
        Operations.showLastOperation();
        Operations.showLastOperation();
        Operations.showLastOperation();
        break;
      case "Int":
        Operations.addValueToOperation(ScrabbleFactory.getInt(Integer.valueOf(inputValue)));
        break;
      case "Float":
        Operations.addValueToOperation(ScrabbleFactory.getFloat(Float.valueOf(inputValue)));
        break;
      case "Boolean":
        Operations.addValueToOperation(ScrabbleFactory.getBoolean(Boolean.valueOf(inputValue)));
        break;
      case "Binary":
        Operations.addValueToOperation(ScrabbleFactory.getBinary(inputValue));
        break;
      default:
        Notifications.addMessage("Select a type");
        Notifications.showLastMessage();
    }


  }

}
