import java.util.Random;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*****************************************
 * Author : Brian Montierth & Tyson Vance
 * Date : 12/05/2015
 * Assignment: A6 - Group Project
 ******************************************/
public class Battle {
    private static boolean fightAgain = true;

    //Declaring GUI variables
    private static Stage window;
    private static Scene scene;
    private static BorderPane mainLayout;
    private static HBox topPane;
    private static HBox heroHealthBox;
    private static Label heroHealthText;
    private static Label heroHealthValue;
    private static HBox enemyHealthBox;
    private static Label enemyHealthText;
    private static Label enemyHealthValue;
    private static VBox centerPane;
    private static Label centerText;
    private static HBox bottomPane;
    private static Button buttonAttack;
    private static Button buttonRun;
    private static Button buttonQuit;
    private static Label heroStatsText;
    private static Label heroMaxHealth;
    private static Label heroAttack;
    private static Label heroDefense;
    private static VBox leftPane;
    private static Label enemyStatsText;
    private static Label enemyMaxHealth;
    private static Label enemyAttack;
    private static Label enemyDefense;
    private static VBox rightPane;


    //Declaring value variables
    private static IntegerProperty heroHealth;
    private static IntegerProperty enemyHealth;
    private static IntegerProperty heroAttackValue;
    private static IntegerProperty enemyAttackValue;
    private static BooleanProperty hasRun;


    public static void fight(Character hero) {

        //Enemy entrance array
        String[] enemyEntrance = {" jumped out of a bush!", " climbed out of a cave!", " stepped out from around a boulder!", " leaped from a tree branch!"};
        String enemyEntrancePreface;


        //fight until hero wins, hero dies, or user quits.
        do {

            //Initialize value variables
            Enemy enemy = new Enemy();
            heroHealth = new SimpleIntegerProperty(Battle.class, "HeroHealth", hero.getHealth());
            enemyHealth = new SimpleIntegerProperty(Battle.class, "enemyHealth", enemy.getHealth());
            heroAttackValue = new SimpleIntegerProperty(Battle.class, "heroAttackValue", hero.heroAttack() - enemy.getDefense());
            enemyAttackValue = new SimpleIntegerProperty(Battle.class, "enemyAttackValue", enemy.enemyAttack() - hero.getDefense());
            hasRun = new SimpleBooleanProperty(Battle.class, "hasRun", false);


            //Initialize GUI components and set titles

            //Top pane
            heroHealthText = new Label(hero.getNAME() + "'s Health:");
            heroHealthValue = new Label();
            heroHealthValue.textProperty().bind(heroHealth.asString());
            heroHealthBox = new HBox(10);
            heroHealthBox.getChildren().addAll(heroHealthText, heroHealthValue);

            enemyHealthText = new Label(enemy.getName() + "'s Health:");
            enemyHealthValue = new Label();
            enemyHealthValue.textProperty().bind(enemyHealth.asString());
            enemyHealthBox = new HBox(10);
            enemyHealthBox.getChildren().addAll(enemyHealthText, enemyHealthValue);

            topPane = new HBox(40);
            topPane.getChildren().addAll(heroHealthBox, enemyHealthBox);
            topPane.setAlignment(Pos.CENTER);
            topPane.setStyle("-fx-border-color: black;");

            //Center pane
            Random rand = new Random();
            enemyEntrancePreface = (enemy.getName() == "The Ender Dragon") ? "" : "A ";
            centerText = new Label(enemyEntrancePreface + enemy.getName() + enemyEntrance[rand.nextInt(4)]);
            centerText.setAlignment(Pos.CENTER);
            centerPane = new VBox();
            centerPane.setStyle("-fx-border-color: black;");
            centerPane.setAlignment(Pos.CENTER);
            centerPane.getChildren().add(centerText);

            //Bottom pane
            buttonAttack = new Button("Attack");
            buttonRun = new Button("Run Away");
            buttonQuit = new Button("Quit");

            bottomPane = new HBox(20);
            bottomPane.setMinHeight(50);
            bottomPane.setAlignment(Pos.CENTER);
            bottomPane.setStyle("-fx-border-color: black;");
            bottomPane.getChildren().addAll(buttonAttack, buttonRun, buttonQuit);

            //Left pane
            heroStatsText = new Label("Hero Stats:");
            heroMaxHealth = new Label("Max Health: " + hero.getHealth());
            heroAttack = new Label("Attack: " + hero.getAttack());
            heroDefense = new Label("Defense: " + hero.getDefense());

            leftPane = new VBox(10);
            leftPane.setAlignment(Pos.CENTER);
            leftPane.setStyle("-fx-border-color: black;");
            leftPane.setMinWidth(150);
            leftPane.getChildren().addAll(heroStatsText, heroMaxHealth, heroAttack, heroDefense);


            //Right pane
            enemyStatsText = new Label("Enemy Stats:");
            enemyMaxHealth = new Label("Max Health: " + enemy.getHealth());
            enemyAttack = new Label("Attack: " + enemy.getAttack());
            enemyDefense = new Label("Defense: " + enemy.getDefense());

            rightPane = new VBox(10);
            rightPane.setAlignment(Pos.CENTER);
            rightPane.setMinWidth(150);
            rightPane.setStyle("-fx-border-color: black;");
            rightPane.getChildren().addAll(enemyStatsText, enemyMaxHealth, enemyAttack, enemyDefense);


            //Main layout (borderpane)
            mainLayout = new BorderPane();
            mainLayout.setTop(topPane);
            mainLayout.setCenter(centerText);
            mainLayout.setBottom(bottomPane);
            mainLayout.setLeft(leftPane);
            mainLayout.setRight(rightPane);

            //Main window
            scene = new Scene(mainLayout, 1000, 950);
            window = new Stage();
            window.setTitle("Fight!");
            window.setScene(scene);

            //Event handlers

            buttonAttack.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (fightAgain)
                        attack(hero, enemy);
                }
            });

            buttonQuit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    fightAgain = false;
                    window.close();
                }
            });

            buttonRun.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (fightAgain) {
                        hasRun.setValue(true);
                        window.close();
                    }
                }
            });

            window.setOnCloseRequest(e -> {
                e.consume();
                fightAgain = false;
                window.close();
            });

            //Show the GUI
            window.showAndWait();

        } while (fightAgain);

        //Loop has exited
        System.out.print("Farewell!, " + hero.getNAME() + ".");

    }

    //Hero and enemy hit each other
    private static void attack(Character hero, Enemy enemy) {

        //Hero hits enemy
        enemyHealth.setValue(
                (enemyHealth.getValue() - heroAttackValue.getValue() <= 0) ? 0 : enemyHealth.getValue() - heroAttackValue.getValue()
        );

        if (heroAttackValue.getValue() == ((hero.getAttack() * 2) - enemy.getDefense()))
            centerText.setText(centerText.getText() + "\n\n" + hero.getNAME() + " CRITICALLY hit " + enemy.getName() + " for " + heroAttackValue.getValue() + " damage!");
        else
            centerText.setText(centerText.getText() + "\n\n" + hero.getNAME() + " hit " + enemy.getName() + " for " + heroAttackValue.getValue() + " damage!");


        //Enemy hits hero
        if (enemyHealth.getValue() > 0) {
            heroHealth.setValue(
                    (heroHealth.getValue() - enemyAttackValue.getValue() <= 0) ? 0 : heroHealth.getValue() - enemyAttackValue.getValue()
            );

            if (enemyAttackValue.getValue() == ((enemy.getAttack() * 2) - hero.getDefense()))
                centerText.setText(centerText.getText() + "\n" + enemy.getName() + " CRITICALLY hit " + hero.getNAME() + " for " + enemyAttackValue.getValue() + " damage!");
            else
                centerText.setText(centerText.getText() + "\n" + enemy.getName() + " hit " + hero.getNAME() + " for " + enemyAttackValue.getValue() + " damage!");
        }
        //if enemy is dead
        if (enemyHealth.getValue() <= 0) {
            centerText.setText(centerText.getText() + "\n..." + hero.getNAME() + " defeated " + enemy.getName() + "!\n");
            afterBattle(hero);
            return;
        }

        //if hero is dead
        if (heroHealth.getValue() <= 0) {
            System.out.print(hero.getNAME() + " has died!\nGame Over!\n");
            fightAgain = false;
            window.close();
        }
    }

    //after the battle
    private static void afterBattle(Character hero) {
        //increase enemy difficulty
        Enemy.increaseBattleNumber();

        //if you fought the Ender Dragon
        if (Enemy.getBattleNumber() % 11 == 0) {
            if (heroHealth.getValue() > 0)
                System.out.print("Congrats! " + hero.getNAME() + " defeated the Ender Dragon! You have saved the world!!\n");
            else
                System.out.print(hero.getNAME() + " has been defeated by the Ender Dragon!\n");
            fightAgain = false;
            window.close();
            return;
        }

        //if you didn't run away, you get to level up one of your stats
        if (!hasRun.getValue()) {
            LevelUp.display(hero);
            window.close();
        }

    }

}


