package cl.uchile.dcc.scrabble.view;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 * Box on the right with the notifications section, with the results section, with the operations
 * section and the insert values section..
 *
 * @author Jorge Luis Ortiz Fuentes
 */

public class RightBox {

  /**
   * Get the vertical box with sections and padding.
   *
   * @return vertical box
   */
  public static VBox getRightBox() {
    var rightBox = new VBox(10);// 10 pixels separation
    rightBox.setPadding(new Insets(30, 30, 0, 0)); // 15 pixels border

    rightBox.getChildren().add(Notifications.getNotificationBox());
    rightBox.getChildren().add(Result.getResultBox());
    rightBox.getChildren().add(Operations.getOperationsBoxScroll());
    VBox.setMargin(Operations.getOperationsBoxScroll(), new Insets(5, 120, 5, 120));

    rightBox.getChildren().add(Calculate.getCalculateBox());
    rightBox.getChildren().add(InsertValues.getValuesBox());

    return rightBox;
  }


}
