import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import static javafx.scene.input.KeyCode.D;


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

                Canvas canvasPremierNiveau = new Canvas(1000, 650);
                GraphicsContext gcNiveau = canvasPremierNiveau.getGraphicsContext2D();
                rootMenu.getChildren().add(canvasPremierNiveau);

                Personnage perso = new Personnage(); // Construction du personnage
                Niveau premierNiveau = new Niveau(perso); // Construction d'un niveau
                premierNiveau.constructionPremierNiveau(); // Construction du premier niveau

                premierNiveau.drawNiveau(canvasPremierNiveau, perso.getPositionX(), perso.getPositionY()); // Dessine le premier niveau

                System.out.println("TestBoutonStart");


                final long startNanoTime = System.nanoTime();
                new AnimationTimer() {
                    @Override
                    public void handle(long l) {
                        double t = (l - startNanoTime) / 1000000000.0;

                        // Récupère les touches clickées et permet le mouvement
                        primaryStage.getScene().setOnKeyPressed(e->{
                            if (e.getCode() == D){
                                System.out.println("Lettre D clické");
                            }
                            if (e.getCode() == KeyCode.ESCAPE){
                                primaryStage.close();
                            }
                            if (e.getCode() == KeyCode.Z){
                                System.out.println("Lettre Z clické");
                            }
                            KeyCode input = e.getCode();
                            perso.deplacePerso(input, premierNiveau);

                        });

                        // Récupère les touches quand elles sont relachées et permet l'arrêt
                        primaryStage.getScene().setOnKeyReleased(e->{
                            if (e.getCode() == D){
                                System.out.println("Lettre D relaché");
                            }

                            if (e.getCode() == KeyCode.Z){
                                System.out.println("Lettre Z relaché");
                            }
                            KeyCode input = e.getCode();
                            perso.ralentissement(input, premierNiveau);

                        });


                        perso.setTombe(perso.gravite(premierNiveau));

                        // Permet de remettre la vitesse à 0 une fois que le personnage a atteri
                        // Si le personnage n'est pas en train de tomber mais qu'il tombait à la boucle précédent
                        // Alors la vitesse est remise à O

                        if (perso.getTombe() == false){
                            if (perso.getTombeMoinsUn()==true){
                                perso.resetVitesse();
                            }
                        }
                        perso.setTombeMoinsUn(perso.gravite(premierNiveau));


                        premierNiveau.drawNiveau(canvasPremierNiveau, perso.getPositionX(), perso.getPositionY());


                        if (perso.getPositionY() > 1000){ // Le personnage tombe
                            System.out.println("Perdu !");
                            this.stop();
                            gcNiveau.rect(100,200,400,200);
                            gcNiveau.setFill(Color.LIGHTGREEN);
                            gcNiveau.fillRect(100,200,800,200);
                            gcNiveau.setFill(Color.BLACK);
                            gcNiveau.setFont(Font.font(40));
                            gcNiveau.fillText("Pour rejouer, tapez 'R'.",300,300);
                            primaryStage.getScene().setOnKeyPressed(e->{ // Possibilité de rejouer
                                if (e.getCode() == KeyCode.R){
                                    perso.deplacePerso(e.getCode(), premierNiveau);
                                    this.start();
                                }
                            });


                            }

                    }
                }.start();
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

    }

}
