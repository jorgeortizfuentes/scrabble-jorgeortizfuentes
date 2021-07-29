package cl.uchile.dcc.scrabble.view;

import java.util.Stack;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Notifications {

  private static final Stack messagesStack = new Stack();
  private static final Label messageLabel = DesignFactory.getNotificationLabel();
  private static HBox notificationBox;

  // Notification Box

  public static HBox getNotificationBox() {
    notificationBox = new HBox(10);// 10 pixels separation
    notificationBox.setPadding(new Insets(15)); // 15 pixels border
    notificationBox.setAlignment(Pos.TOP_CENTER);
    notificationBox.getChildren().add(getMessageLabel());
    return notificationBox;
  }

  public static Label getMessageLabel() {
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

  public static String getCurrentMessage() {
    return messageLabel.getText();
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
