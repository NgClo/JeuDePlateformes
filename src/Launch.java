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

import java.util.ArrayList;

import static javafx.scene.input.KeyCode.D;

public class Launch extends Application {

    public void start(Stage primaryStage){

        // Creation de la scene du menu
        ArrayList<Button> listButton = new ArrayList<>();
        Scenes scenesMenu = new Scenes(listButton);
        Scene scene;
        scene = scenesMenu.constructionMenu();

        // Affichage de la scène du menu
        primaryStage.setTitle("Jeu de plateformes");
        primaryStage.setScene(scene);
        primaryStage.show();


        // Association d'évènements aux boutons du menu
        // Le bouton Start affecte à la fenêtre la scene contenant le premier niveau
        scenesMenu.buttonList.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StackPane rootNiveau = new StackPane(); // Creation du panneau pour les niveaux
                Canvas canvasNiveau = new Canvas(1000, 650); // Creation du canvas
                GraphicsContext gcNiveau = canvasNiveau.getGraphicsContext2D(); // Creation du GraphicsContext
                rootNiveau.getChildren().add(canvasNiveau); // Association du canvas au niveau
                Scene sceneNiveau = new Scene(rootNiveau,1000,650); // Creation d'une scène pour les niveaux avec un panneau associé
                primaryStage.setScene(sceneNiveau); // On place la scene du niveau dans la fenêtre

                Personnage perso = new Personnage(); // Construction du personnage
                // Chargement des frames du personnage
                perso.setListeImageIdleDino();
                perso.setListImageRunDino();

                Niveau premierNiveau = new Niveau(perso); // Creation du premier niveau avec association du personnage au niveau
                premierNiveau.constructionPremierNiveau(); // Construction du premier niveau

                premierNiveau.drawNiveau(canvasNiveau, perso.getPositionX(), perso.getPositionY()); // Dessine le premier niveau

                // Debut de la boucle
                final long startNanoTime = System.nanoTime();
                new AnimationTimer() {
                    @Override
                    public void handle(long l) {
                        double t = (l - startNanoTime) / 1000000000.0;

                        // Récupère les touches clickées : permet le mouvement, retour au menu et quitter le jeu
                        primaryStage.getScene().setOnKeyPressed(e->{
                            if (e.getCode() == KeyCode.ESCAPE){ // Fermeture du programme
                                primaryStage.close();
                            }
                            if (e.getCode() == KeyCode.Z){
                                System.out.println("Lettre Z clické");
                            }

                            if (e.getCode() == KeyCode.M){
                                primaryStage.setScene(scene);
                                this.stop();
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

                        if (perso.ecartPlateforme(premierNiveau) > 10 && perso.ecartPlateforme(premierNiveau) < 26)
                            perso.setPositionY(perso.surQuelBloc(premierNiveau).getMinY()-50);
                            //perso.setPositionY(630);


                        premierNiveau.drawNiveau(canvasNiveau, perso.getPositionX(), perso.getPositionY());


                        if (perso.getPositionY() > 1000){ // Le personnage tombe
                            System.out.println("Perdu !");
                            perso.resetVitesse();
                            this.stop();
                            gcNiveau.setFill(Color.BLACK);
                            gcNiveau.fillRect(95,195,810,210);
                            gcNiveau.setFill(Color.LIGHTGREEN);
                            gcNiveau.fillRect(100,200,800,200);
                            gcNiveau.setFill(Color.BLACK);
                            gcNiveau.setFont(Font.font(40));
                            gcNiveau.fillText("GAME OVER - Pour rejouer, tapez 'R'.",200,300);
                            primaryStage.getScene().setOnKeyPressed(e->{ // Possibilité de rejouer
                                if (e.getCode() == KeyCode.R){
                                    perso.deplacePerso(e.getCode(), premierNiveau);
                                    this.start();
                                }
                            });
                        }

                        if (perso.remporteNiveau(premierNiveau)){
                            System.out.println("Gagné !");
                            this.stop();
                            gcNiveau.setFill(Color.BLACK);
                            gcNiveau.fillRect(95,195,810,210);
                            gcNiveau.setFill(Color.LIGHTGREEN);
                            gcNiveau.fillRect(100,200,800,200);
                            gcNiveau.setFill(Color.BLACK);
                            gcNiveau.setFont(Font.font(40));
                            gcNiveau.fillText("Félicitations ! Pour rejouer, tapez 'R'.",200,300);
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

        scenesMenu.buttonList.get(1).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("TestBoutonHighScore");
            }
        });

        scenesMenu.buttonList.get(2).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.close();
            }
        });

    }

}
