package cl.uchile.dcc.scrabble.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Box on the left with buttons for operations and transformations.
 *
 * @author Jorge Luis Ortiz Fuentes
 */
public class LeftBox {

  /**
   * Get the vertical box with all buttons and padding.
   *
   * @return vertical box
   */
  public static VBox getLeftBox() {
    var leftBox = new VBox(10);// 10 pixels separation
    leftBox.setPadding(new Insets(0, 0, 0, 30)); // 15 pixels border
    leftBox.setAlignment(Pos.BASELINE_CENTER);
    leftBox.getChildren().add(DesignFactory.getTitleLabel("Operations"));
    leftBox.getChildren().add(addButton());
    leftBox.getChildren().add(subtButton());
    leftBox.getChildren().add(multButton());
    leftBox.getChildren().add(divButton());
    leftBox.getChildren().add(andButton());
    leftBox.getChildren().add(orButton());
    leftBox.getChildren().add(negateButton());
    leftBox.getChildren().add(DesignFactory.getTitleLabel("Transformations"));
    leftBox.getChildren().add(asStringButton());
    leftBox.getChildren().add(asIntButton());
    leftBox.getChildren().add(asFloatButton());
    leftBox.getChildren().add(asBinaryButton());
    leftBox.getChildren().add(asBooleanButton());

    return leftBox;
  }

  /**
   * Button to add. If pressed, it executes the InsertOperations::addOperation method.
   *
   * @return Add button
   */
  private static Button addButton() {
    var button = DesignFactory.getButton1();
    button.setText("ADD ( □ + □ )");
    button.setOnAction(event -> InsertOperations.addOperation());
    return button;

  }

  /**
   * Button to subtract. If pressed, it executes the InsertOperations::subtOperation method.
   *
   * @return Subtract button
   */
  private static Button subtButton() {
    var button = DesignFactory.getButton1();
    button.setText("SUBTRACT ( □ - □ )");
    button.setOnAction(event -> InsertOperations.subtOperation());
    return button;
  }

  /**
   * Button to multiply. If pressed, it executes the InsertOperations::multOperation method.
   *
   * @return Multiply button
   */
  private static Button multButton() {
    var button = DesignFactory.getButton1();
    button.setText("MULTIPLY ( □ × □ )");
    button.setOnAction(event -> InsertOperations.multOperation());
    return button;
  }

  /**
   * Button to divide. If pressed, it executes the InsertOperations::divOperation method.
   *
   * @return Divide button
   */
  private static Button divButton() {
    var button = DesignFactory.getButton1();
    button.setText("DIVIDE ( □ ÷ □ )");
    button.setOnAction(event -> InsertOperations.divOperation());
    return button;
  }

  /**
   * Button to implement the conjunction operation. If pressed, it executes the
   * InsertOperations::andOperation method.
   *
   * @return And button
   */
  private static Button andButton() {
    var button = DesignFactory.getButton1();
    button.setText("AND ( □ ∧ □ )");
    button.setOnAction(event -> InsertOperations.andOperation());
    return button;
  }

  /**
   * Button to implement the disjunction operation. If pressed, it executes the
   * InsertOperations::orOperation method.
   *
   * @return Or button
   */
  private static Button orButton() {
    var button = DesignFactory.getButton1();
    button.setText("OR ( □ ∨ □ )");
    button.setOnAction(event -> InsertOperations.orOperation());
    return button;
  }

  /**
   * Button to negate. If pressed, it executes the InsertOperations::negateOperation method.
   *
   * @return Or button
   */
  private static Button negateButton() {
    var button = DesignFactory.getButton1();
    button.setText("NEGATE ( ¬ □ )");
    button.setOnAction(event -> InsertOperations.negateOperation());
    return button;
  }

  /**
   * Button to convert to Scrabble String. If pressed, it executes the
   * InsertOperations::asStringOperation method.
   *
   * @return As String button
   */
  private static Button asStringButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO STRING ( □ )");
    button.setOnAction(event -> InsertOperations.asStringOperation());
    return button;
  }

  /**
   * Button to convert to Scrabble Int. If pressed, it executes the InsertOperations::asIntOperation
   * method.
   *
   * @return As Int button
   */
  private static Button asIntButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO INT ( □ )");
    button.setOnAction(event -> InsertOperations.asIntOperation());
    return button;
  }

  /**
   * Button to convert to Scrabble Float. If pressed, it executes the
   * InsertOperations::asFloatOperation method.
   *
   * @return As Float button
   */
  private static Button asFloatButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO FLOAT ( □ )");
    button.setOnAction(event -> InsertOperations.asFloatOperation());
    return button;
  }

  /**
   * Button to convert to Scrabble Binary. If pressed, it executes the
   * InsertOperations::asBinaryOperation method.
   *
   * @return As Binary button
   */
  private static Button asBinaryButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO BINARY ( □ )");
    button.setOnAction(event -> InsertOperations.asBinaryOperation());
    return button;
  }

  /**
   * Button to convert to Scrabble Boolean. If pressed, it executes the
   * InsertOperations::asBooleanOperation method.
   *
   * @return As Boolean button
   */
  private static Button asBooleanButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO BOOLEAN ( □ )");
    button.setOnAction(event -> InsertOperations.asBooleanOperation());
    return button;
  }
}
