package cl.uchile.dcc.scrabble.gui;

import java.util.Stack;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Notifications {

  private static Stack messagesStack = new Stack();
  private static Label messageLabel = new Label("Select an operation");
  private static HBox notificationBox;

  // Notification Box

  public static HBox getNotificationBox() {
    notificationBox = new HBox(10);// 10 pixels separation
    notificationBox.setPadding(new Insets(15)); // 15 pixels border
    notificationBox.setAlignment(Pos.TOP_CENTER);
    notificationBox.getChildren().add(messageLabel());
    return notificationBox;
  }

  public static Label messageLabel() {
    //messageLabel.setLayoutX(600);
    //messageLabel.setLayoutY(30);
    messageLabel.setStyle("-fx-font-size: 18px;"
        + "-fx-font-weight: bold");
    return messageLabel;
  }

  public static void addMessage(String s) {
    messagesStack.add(s);
  }

  public static void showLastMessage() {
    if (!messagesStack.isEmpty()) {
      String last = (String) messagesStack.pop();
      messageLabel.setText(last);
    } else if (Operations.isNull()) {
      addMessage("Select an operation");
      showLastMessage();
    } else if (Operations.isComplete()) {
      cleanMessage();
    }
  }

  public static String getLastMessage() {
    return (String) messagesStack.pop();
  }

    public static void cleanMessage() {
    messagesStack.clear();
    messagesStack.add("Select an operation");
    showLastMessage();
  }

}
