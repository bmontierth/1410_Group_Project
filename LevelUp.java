import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*****************************************
 * Author : Brian Montierth & Tyson Vance
 * Date : 12/05/2015
 * Assignment: A6 - Group Project
 ******************************************/

public class LevelUp {

    public static void display(Character hero) {

        Stage primaryStage = new Stage();
        Label label1;
        Button button1;
        Button button2;
        Button button3;

        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Level Up!");
        label1 = new Label("Please choose a stat to increase:");
        button1 = new Button("Health (+10)");
        button1.setOnAction(e -> {
            primaryStage.close();
            levelStat(hero,button1.getText());
        });

        button2 = new Button("Attack (+3)");
        button2.setOnAction(e -> {
            primaryStage.close();
            levelStat(hero,button2.getText());
        });

        button3 = new Button("Defense (+1)");
        button3.setOnAction(e -> {
            primaryStage.close();
            levelStat(hero,button3.getText());
        });

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label1,button1, button2, button3);
        StackPane layout = new StackPane();
        layout.getChildren().addAll(vBox);
        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    }

    private static void levelStat(Character hero,String stat){

        if (stat == "Health (+10)")
            hero.increaseStat('h');
        else if (stat == "Attack (+3)")
            hero.increaseStat('a');
        else if (stat == "Defense (+1)")
            hero.increaseStat('d');
    }

}

