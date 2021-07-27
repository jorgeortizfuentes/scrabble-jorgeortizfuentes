package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.operations.Add;
import cl.uchile.dcc.scrabble.operations.Operation;
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

  private static Operation operation = null;
  private static Label messageLabel;
  private static Label resultLabel;
  private static ChoiceBox valueTypeBox;
  private static TextField valueText;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {


    primaryStage.setTitle("Scrabble Operations");
    // Root
    var root = new Group();

    // vertical box
    var cajaVertical = new VBox(10);//Asignamos 10 pixeles de separacion entre los nodos
    cajaVertical.setPadding(new Insets(15)); //Agregamos un relleno de 15 pixeles para separarlo del borde de la ventana

    cajaVertical.getChildren().add(addButton());
    cajaVertical.getChildren().add(subtractButton());


    // Root
    root.getChildren().add(cajaVertical);
    root.getChildren().add(calculateButton());

    //root.getChildren().add(addButton());
    //root.getChildren().add(subtractButton());
    root.getChildren().add(messageLabel());
    root.getChildren().add(resultLabel());
    root.getChildren().add(valuesBar());



    // This sets the size of the Scene to be 400px wide, 200px high
    Scene scene = new Scene(root, 1280, 720);
    primaryStage.setScene(scene);

    primaryStage.show();


    var L = new ArrayList<ArrayList>();
    L.add(new ArrayList<ArrayList>());
    L.add(new ArrayList<ArrayList>(new ArrayList<ArrayList>()));

    L.get(0).add(L.get(1));
    L.remove(1);
    System.out.println(L);


  }

  // Labels

  private static @NotNull Label messageLabel() {
    messageLabel = new Label("Select an operation");
    messageLabel.setLayoutX(600);
    messageLabel.setLayoutY(30);
    messageLabel.setStyle("-fx-font-size: 18px;"
        + "-fx-font-weight: bold");
    return messageLabel;
  }

  private static @NotNull Label resultLabel() {
    resultLabel = new Label("");
    resultLabel.setLayoutX(600);
    resultLabel.setLayoutY(350);
    resultLabel.setStyle("-fx-font-size: 22px;"
        + "-fx-font-weight: bold");
    return resultLabel;

  }


    private static @NotNull ButtonBar valuesBar() {

    // Create the ButtonBar instance
    var buttonBar = new ButtonBar();

    // Create the buttons to go into the ButtonBar
    valueTypeBox = new ChoiceBox(FXCollections.observableArrayList(
        "String", "Int", "Float", "Binary", "Boolean"));
    valueTypeBox.setValue("Select a type");

    valueText = new TextField();

    var insertButton = new Button("Insert");
    insertButton.setOnAction(Scrabble::sendValue);

    // Add buttons to the ButtonBar
    buttonBar.getButtons().addAll(valueTypeBox, valueText, insertButton);
    buttonBar.setLayoutX(400);
    buttonBar.setLayoutY(600);

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

  private @NotNull Button calculateButton() {
    var button = new Button("Calcular");
    button.setLayoutX(400);
    button.setLayoutY(500);
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: #AFBBF2; "
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    button.setOnAction(Scrabble::calculate);
    return button;

  }
  private @NotNull Button addButton() {
    var button = new Button("ADD ( □ + □ )");
    button.setLayoutX(100);
    button.setLayoutY(100);
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: #AFBBF2; "
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    //button.setOnAction(Scrabble::playSound);
    button.setOnAction(event -> {
      messageLabel.setText("Insert the first addend");
      operation = new Add();
    });

    return button;

  }

  private @NotNull Button subtractButton() {
    var button = new Button("SUBTRACT ( □ - □ )");
    button.setLayoutX(100);
    button.setLayoutY(200);
    button.setFocusTraversable(false);
    button.setStyle("-fx-background-color: #AFBBF2; "
        + "-fx-padding: 15 30 15 30;"
        + "-fx-font-size: 14px;"
        + "-fx-font-weight: bold");
    //button.setOnAction(App::playSound);
    button.setOnAction(event -> messageLabel.setText("Insert the minuend."));
    return button;
  }

  private static void calculate(ActionEvent event) {

    if (operation != null || operation.isComplete()){
      var result = operation.evaluate();
      messageLabel.setText(String.valueOf(result));
      result = null;

    } else{
      System.out.println("Error, no esta terminado");
    }
  }




  private static void sendValue(ActionEvent event) {
    var inputType = valueTypeBox.getValue().toString();
    var inputValue = valueText.getCharacters().toString();


    switch(inputType)
    {
      case "String":
        addValueToOperation(ScrabbleFactory.getString(inputValue));
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
    } else {
      System.out.println("Lleno");
    }
    
  }


  
  /**
   * Agregar a cada clase operation los métodos setValues(val) y isComplete()
   *
   * Una lista con un puntero. Agrego la operacion.
   *
   * Caso 1: agrego dos numeros.
   *
   * pointer = -1
   * lista = []
   * lista.append(new Add())
   * pointer ++
   *
   * // En addOperation
   * if (!lista[pointer].isComplete()) {
   *   lista[0].setValues(input)
   * }
   *
   * lista[0].evaluate() WIN!
   *
   * Caso 2: agrego un numero y una operacion
   * pointer = -1
   * lista = []
   * lista.append(new Add())
   * lista.append(new Subt())
   *
   * lista[0].setValues(lista[1])
   *
   * pointer ++
   * if (!lista[pointer].isComplete()) {
   *   lista[0].setValues(input)
   * }
   *
   */

}