import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*****************************************
 * Author : Brian Montierth & Tyson Vance
 * Date : 12/05/2015
 * Assignment: A6 - Group Project
 ******************************************/



public class BattleApp extends Application {

    Label label1;
    Button button;
    TextField textField;


    public static void main(String[] args)  {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("A6 Adventure!");

        label1 = new Label("Hero, what is your name?");

        textField = new TextField();
        textField.setMaxWidth(300);
        textField.setAlignment(Pos.CENTER);

        button = new Button();
        button.setText("Submit");
        button.setOnAction(e -> {
            primaryStage.close();
            try {
                makeCharacter(textField.getText());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });


        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label1,textField,button);




        StackPane layout = new StackPane();
        layout.getChildren().addAll(vBox);
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);

        boolean readyToStart = ConfirmBox.display("Greetings, Champion!","Are you ready to embark on a perilous journey?");

        if (readyToStart)
            primaryStage.show();
        else
            System.out.print("You say you need more training?  We look forward to your return!");





    }

    private void makeCharacter(String heroName) throws InterruptedException {
        Character hero = new Character(heroName);

        Battle.fight(hero);

    }
}