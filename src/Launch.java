import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Launch extends Application {

    public void start(Stage primaryStage){

        // Création des 3 boutons du menu
        Button Start = new Button();
        Button HighScore = new Button();
        Button Exit = new Button();

        Start.setText("START");
        HighScore.setText("HIGH SCORE");
        Exit.setText("EXIT");

        Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(Niveau.premierNiveau());
                System.out.println("TestBoutonStart");
            }
        });

        HighScore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("TestBoutonHighScore");
            }
        });

        Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });

        // Création de la scène et du panneau
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 650,650);

        // Création de l'image de fond et association de cette image au fond d'écran
        Image imageMenu = new Image("beach.png");
        BackgroundImage fondEcranMenuImage = new BackgroundImage(imageMenu, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondEcranMenu = new Background(fondEcranMenuImage);

        root.setBackground(fondEcranMenu);

        // Bouton START
        Start.setTranslateY(-150);
        Start.setBackground(Background.fill(Color.LIGHTGREEN));
        root.getChildren().add(Start);

        // Bouton HIGHSCORE
        HighScore.setBackground(Background.fill(Color.LIGHTGREEN));
        root.getChildren().add(HighScore);

        // Bouton EXIT
        root.getChildren().add(Exit);
        Exit.setBackground(Background.fill(Color.LIGHTGREEN));
        Exit.setTranslateY(150);


        primaryStage.setTitle("Jeu de plateformes");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

}
