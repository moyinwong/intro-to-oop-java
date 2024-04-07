
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {

  final static double EXCHANGE_RATE = 0.81;

  @Override
  public void start(Stage stage) {
    stage.setTitle("Hello World Program");

    Button btn = new Button();
    btn.setText("Print Hello World");
    btn.setOnAction(new CustomEventHandler());

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 300, 300);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<Integer>();
  }

  private class CustomEventHandler implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
      System.out.println("Hello Wolrd");
    }
  }

}
