import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;


public class Animation extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a clock and a label
        Clock1 clock = new Clock1();
        
        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
         GridPane pane2 = new GridPane();
         Button Stop =new Button("Stop");
         Button Start = new Button("Start");
         GridPane.setRowIndex(Start, 0);
         GridPane.setColumnIndex(Start, 1);
         GridPane.setRowIndex(Stop, 0);
         GridPane.setColumnIndex(Stop, 2);
         pane2.getChildren().addAll(Start, Stop);
         pane.setCenter(clock);
         pane.setBottom(pane2);
         pane2.setAlignment(Pos.CENTER);
        EventHandler<ActionEvent> eventHandler = e->{clock.setCurrentTime();};
        Timeline animation=new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        
        
        Start.setOnAction((ActionEvent event) -> {
          animation.play(); });
        
        Stop.setOnAction((ActionEvent event) -> {
         animation.stop();
        }); 
        
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); }
 
 
    public static void main(String[] args) {
        Application.launch(args);
    } 
} 

