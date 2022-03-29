import javafx.animation.AnimationTimer;
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

    /** Création des boutons dans le menu principal.*/
    private Button createButton(String buttonName, int translation, StackPane root){
        Button button = new Button();
        button.setText(buttonName);
        button.setTranslateY(translation);
        button.setBackground(Background.fill(Color.LIGHTGREEN));
        root.getChildren().add(button);
        return button;
    }

    public void start(Stage primaryStage){

        long startNanoTime = System.nanoTime();


        // Création du panneau
        StackPane rootMenu = new StackPane();

        // Création des 3 boutons du menu et association au panneau
        Button Start = createButton("Start",-150,rootMenu);
        Button HighScore = createButton("Highscore",0,rootMenu);
        Button Exit = createButton("Exit",150,rootMenu);

        // Création de l'image de fond et association de cette image au fond d'écran
        Image imageMenu = new Image("beach.png");
        BackgroundImage fondEcranMenuImage = new BackgroundImage(imageMenu, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondEcranMenu = new Background(fondEcranMenuImage);

        // Association du fond d'écran au panneau
        rootMenu.setBackground(fondEcranMenu);

        // Creation de la scene et association du panneau à cette scene
        Scene scene = new Scene(rootMenu, 1000,650);

        // Nom de la fenêtre
        primaryStage.setTitle("Jeu de plateformes");

        // La scene qui contient le menu est mis dans la fenêtre et la fenêtre est affichée
        primaryStage.setScene(scene);
        primaryStage.show();


        // Association d'évènements aux boutons
        // Le bouton Start affecte à la fenêtre la scene contenant le premier niveau
        Start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Niveau premierNiveau = new Niveau(); // Construction du premier niveau
                premierNiveau.setSceneNiveau(); // La scene du premier niveau est construite et associée au niveau créé
                primaryStage.setScene(premierNiveau.getSceneNiveau()); // La scene du premier niveau est récupérée et affichée dans la fenêtre
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




/*        AnimationTimer gameLoopTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                double t = (l - startNanoTime) / 1000000000.0;
                primaryStage.setScene(Niveau.premierNiveau());
                Entite.gravite(Niveau.perso,groupNiveau);


            }
        };*/

    }

}
