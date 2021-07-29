package cl.uchile.dcc.scrabble.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftBox {

  private static VBox leftBox;


  public static VBox getLeftBox() {
    leftBox = new VBox(10);// 10 pixels separation
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

  private static Button addButton() {
    var button = DesignFactory.getButton1();
    button.setText("ADD ( □ + □ )");
    button.setOnAction(InsertOperations::addOperation);
    return button;

  }

  private static Button subtButton() {
    var button = DesignFactory.getButton1();
    button.setText("SUBTRACT ( □ - □ )");
    button.setOnAction(InsertOperations::subtOperation);
    return button;
  }

  private static Button multButton() {
    var button = DesignFactory.getButton1();
    button.setText("MULTIPLY ( □ × □ )");
    button.setOnAction(InsertOperations::multOperation);
    return button;
  }

  private static Button divButton() {
    var button = DesignFactory.getButton1();
    button.setText("DIVIDE ( □ ÷ □ )");
    button.setOnAction(InsertOperations::divOperation);
    return button;
  }

  private static Button andButton() {
    var button = DesignFactory.getButton1();
    button.setText("AND ( □ ∧ □ )");
    button.setOnAction(InsertOperations::andOperation);
    return button;
  }

  private static Button orButton() {
    var button = DesignFactory.getButton1();
    button.setText("OR ( □ ∨ □ )");
    button.setOnAction(InsertOperations::orOperation);
    return button;
  }

  private static Button negateButton() {
    var button = DesignFactory.getButton1();
    button.setText("NEGATE ( ¬ □ )");
    button.setOnAction(InsertOperations::negateOperation);
    return button;
  }

  private static Button asStringButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO STRING ( □ )");
    button.setOnAction(InsertOperations::asStringOperation);
    return button;
  }

  private static Button asIntButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO INT ( □ )");
    button.setOnAction(InsertOperations::asIntOperation);
    return button;
  }

  private static Button asFloatButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO FLOAT ( □ )");
    button.setOnAction(InsertOperations::asFloatOperation);
    return button;
  }

  private static Button asBinaryButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO BINARY ( □ )");
    button.setOnAction(InsertOperations::asBinaryOperation);
    return button;
  }

  private static Button asBooleanButton() {
    var button = DesignFactory.getButton1();
    button.setText("TO BOOLEAN ( □ )");
    button.setOnAction(InsertOperations::asBooleanOperation);
    return button;
  }
}
