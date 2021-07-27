package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.operations.Add;
import cl.uchile.dcc.scrabble.operations.Operation;
import cl.uchile.dcc.scrabble.operations.Subt;
import cl.uchile.dcc.scrabble.types.ScrabbleFactory;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;
import java.util.Stack;



/**
 * Main entry point for the application.
 * <p>
 * <Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author Jorge Luis Ortiz Fuentes
 */
public class Scrabble extends Application {

  private static VBox leftVerticalBox;
  private static HBox notificationBox;
  private static HBox showOperationBox;
  private static Operation operation = null;
  private static Stack messagesStack = new Stack();
  private static Label messageLabel = new Label("Select an operation");
  private static Label resultLabel = new Label("");
  private static ChoiceBox valueTypeBox;
  private static TextField valueText;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {


    primaryStage.setTitle("Scrabble Operations");
    // Root
    var root = new BorderPane();




    // Root
    root.setLeft(leftVerticalBox());
    root.setCenter(centerVerticalBox());


    //
    // root.getChildren().add(cajaVertical);
    //root.getChildren().add(calculateButton());

    //root.getChildren().add(addButton());
    //root.getChildren().add(subtractButton());
    //root.getChildren().add(messageLabel());
    //root.getChildren().add(resultLabel());
    //root.getChildren().add(valuesBar());



    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(root, 1280, 720);
    primaryStage.setScene(scene);

    primaryStage.show();


  }



  // Left Box

  private static VBox leftVerticalBox() {
    leftVerticalBox = new VBox(10);// 10 pixels separation
    leftVerticalBox.setPadding(new Insets(15)); // 15 pixels border

    leftVerticalBox.getChildren().add(addButton());
    leftVerticalBox.getChildren().add(subtractButton());
    return leftVerticalBox;
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
    //button.setOnAction(Scrabble::playSound);
    button.setOnAction(event -> {

      if (operation == null){
        operation = new Add();
        addMessage("Press \"Calculate\" to obtain the result");
      } else {
        operation.setValues(new Add());
      }
      addMessage("Inserts the second addend or an operation");
      addMessage("Inserts the first addend or an operation");
      showLastMessage();

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
      addMessage("Insert the subtrahend or an operation");
      addMessage("Insert the minuend or an operation");
      showLastMessage();
      operation = new Add();
    });
    return button;
  }

  // Center Box
  private static VBox centerVerticalBox() {
    leftVerticalBox = new VBox(10);// 10 pixels separation
    leftVerticalBox.setPadding(new Insets(15)); // 15 pixels border

    leftVerticalBox.getChildren().add(notificationBox());
    leftVerticalBox.getChildren().add(showOperationBox());
    leftVerticalBox.getChildren().add(resultBox());
    leftVerticalBox.getChildren().add(valuesBox());
    return leftVerticalBox;
  }


  // Notification Box

  private static HBox notificationBox() {
    notificationBox = new HBox(10);// 10 pixels separation
    notificationBox.setPadding(new Insets(15)); // 15 pixels border
    notificationBox.setAlignment(Pos.TOP_CENTER);
    notificationBox.getChildren().add(messageLabel());
    return notificationBox;
  }

  private static Label messageLabel() {
    //messageLabel.setLayoutX(600);
    //messageLabel.setLayoutY(30);
    messageLabel.setStyle("-fx-font-size: 18px;"
        + "-fx-font-weight: bold");
    return messageLabel;
  }

  private static void addMessage(String s) {
    messagesStack.add(s);

  }

  private static void showLastMessage() {
    if (!messagesStack.isEmpty()){
      String last = (String) messagesStack.pop();
      messageLabel.setText(last);
    } else if (operation == null) {
      addMessage("Select an operation");
      showLastMessage();
    } else if (operation.isComplete()){
      resetMessage();

    }


  }

  private static void resetMessage(){
    messagesStack.clear();
    messagesStack.add("Select an operation");
    showLastMessage();
  }

  // Values box

  private static HBox valuesBox() {

    // Create the ButtonBar instance
    var buttonBar = new HBox(10);
    buttonBar.setPadding(new Insets(15)); // 15 pixels border
    buttonBar.setAlignment(Pos.TOP_CENTER);

    // Create the buttons to go into the ButtonBar
    valueTypeBox = new ChoiceBox(FXCollections.observableArrayList(
        "String", "Int", "Float", "Binary", "Boolean"));
    valueTypeBox.setValue("Select a type");

    valueText = new TextField();

    var insertButton = new Button("Insert");
    insertButton.setOnAction(Scrabble::sendValue);

    // Add buttons to the ButtonBar
    buttonBar.getChildren().addAll(valueTypeBox, valueText, insertButton);
    //buttonBar.setLayoutX(400);
    //buttonBar.setLayoutY(600);

    // add a listener
    valueTypeBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

      // if the item of the list is changed
      public void changed(ObservableValue ov, Number value, Number new_value) {

        // set the text for the messageLabel to the selected item
        //l1.setText(st[new_value.intValue()] + " selected");
      }
    });
    return buttonBar;
  }

  private static void sendValue(ActionEvent event) {
    var inputType = valueTypeBox.getValue().toString();
    var inputValue = valueText.getCharacters().toString();


    switch(inputType)
    {
      case "String":
        addValueToOperation(ScrabbleFactory.getString(inputValue));
        var op = new Label("String("+inputValue+")");
        op.setStyle("-fx-font-size: 22px;"
            + "-fx-font-weight: bold");
        addOperationToShow(op);
        break;
      case "Int":
        addValueToOperation(ScrabbleFactory.getInt(Integer.valueOf(inputValue)));
        break;
      case "Float":
        addValueToOperation(ScrabbleFactory.getFloat(Float.valueOf(inputValue)));
        break;
      case "Boolean":
        addValueToOperation(ScrabbleFactory.getBoolean(Boolean.valueOf(inputValue)));
        break;
      case "Binary":
        addValueToOperation(ScrabbleFactory.getBinary(inputValue));
        break;
      default:
        System.out.println("Error");
    }


  }

  private static void addValueToOperation(Operation v) {
    if (!operation.isComplete()) {
      operation.setValues(v);
      showLastMessage();
    } else {
      System.out.println("Lleno");
    }
    
  }

  // Result box


  private static VBox resultBox() {
    var resultBox = new VBox(10);// 10 pixels separation
    resultBox.setPadding(new Insets(15)); // 15 pixels border
    resultBox.setAlignment(Pos.TOP_CENTER);
    var titleResult = new Label("Result");

    resultBox.getChildren().add(titleResult);
    resultBox.getChildren().add(resultLabel());

    resultBox.getChildren().add(calculateBox());
    return resultBox;
  }

  private static Label resultLabel() {
    resultLabel = new Label("");
    resultLabel.setLayoutX(600);
    resultLabel.setLayoutY(350);
    resultLabel.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    return resultLabel;

  }

  // Show Operation Box

  private static HBox showOperationBox() {
    showOperationBox = new HBox(5);// 10 pixels separation
    showOperationBox.setPadding(new Insets(15)); // 15 pixels border
    showOperationBox.setAlignment(Pos.TOP_CENTER);

    return showOperationBox;
  }

  private static void addOperationToShow(Label op) {
    showOperationBox.getChildren().add(op);

  }

  // Calculate Box

  private static HBox calculateBox() {
    notificationBox = new HBox(10);// 10 pixels separation
    notificationBox.setPadding(new Insets(15)); // 15 pixels border
    notificationBox.setAlignment(Pos.TOP_CENTER);
    notificationBox.getChildren().add(calculateButton());
    notificationBox.getChildren().add(cleanButton());
    return notificationBox;

  }

  private static Button calculateButton() {
    var button = new Button("CALCULATE");
    button.setLayoutX(400);
    button.setLayoutY(500);
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: #AFBBF2; "
        //+ "-fx-cell-size: 20"
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    button.setOnAction(Scrabble::calculate);
    return button;

  }

  private static Button cleanButton() {
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
      resetMessage();
      operation = null;
      resultLabel = new Label("");

    });

    return button;

  }
  private static void calculate(ActionEvent event) {

    if (operation != null || operation.isComplete()){
      var result = operation.evaluate();
      resultLabel.setText(String.valueOf(result));
      resetMessage();
      result = null;

    } else{
      System.out.println("Error, no esta terminado");
    }
  }



}