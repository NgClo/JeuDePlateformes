import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Launch extends Application {

    public void start(Stage primaryStage){

        // Creation de la scene du menu
        ArrayList<Button> listButton = new ArrayList<>();
        Graphique scenesMenu = new Graphique(listButton);
        Scene sceneMenu;
        sceneMenu = scenesMenu.constructionMenu();

        // Affichage de la scène du menu
        primaryStage.setTitle("Jeu de plateformes");
        primaryStage.setScene(sceneMenu);
        primaryStage.show();


        // Association d'évènements aux boutons du menu
        // Le bouton Start affecte à la fenêtre la scene contenant le premier niveau
        scenesMenu.buttonList.get(0).setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StackPane rootNiveau = new StackPane(); // Creation du panneau pour les niveaux
                Canvas canvasNiveau = new Canvas(1000, 650); // Creation du canvas
                GraphicsContext gcNiveau = canvasNiveau.getGraphicsContext2D(); // Creation du GraphicsContext
                rootNiveau.getChildren().add(canvasNiveau); // Association du canvas au niveau
                Scene sceneNiveau = new Scene(rootNiveau, 1000, 650); // Creation d'une scène pour les niveaux avec un panneau associé
                primaryStage.setScene(sceneNiveau); // On place la scene du niveau dans la fenêtre

                Personnage perso = new Personnage(); // Construction du personnage
                // Chargement des frames du personnage
                perso.setListeImageIdleDino();
                perso.setListImageRunDino();
                perso.setListImageRunDinoR();


                Niveau premierNiveau = new Niveau(perso); // Creation du premier niveau avec association du personnage au niveau
                premierNiveau.constructionPremierNiveau(); // Construction du premier niveau

                premierNiveau.drawNiveau(canvasNiveau, perso.getPositionX(), perso.getPositionY()); // Dessine le premier niveau

                // Debut de la boucle
                new AnimationTimer() {
                    @Override
                    public void handle(long l) {

                        // Récupère les touches appuyées : permet le mouvement, retour au menu et quitter le jeu
                        primaryStage.getScene().setOnKeyPressed(e -> {
                            if (e.getCode() == KeyCode.ESCAPE) { // Fermeture du programme
                                primaryStage.close();
                            }
                            if (e.getCode() == KeyCode.M) { // Retour au menu
                                primaryStage.setScene(sceneMenu);
                                this.stop();
                            }
                            perso.deplacePerso(e.getCode(), premierNiveau);
                        });

                        // Récupère les touches quand elles sont relachées et permet l'arrêt
                        primaryStage.getScene().setOnKeyReleased(e -> perso.ralentissement(e.getCode()));

                        /* Permet de remettre la vitesse à 0 une fois que le personnage a atteri
                        Si le personnage n'est pas en train de tomber mais qu'il tombait à la boucle précédent
                        Alors la vitesse est remise à O*/
                        perso.setTombe(perso.gravite(premierNiveau));
                        if (!perso.getTombe()) {
                            if (perso.getTombeMoinsUn()) {
                                perso.resetVitesse();
                            }
                        }
                        perso.setTombeMoinsUn(perso.gravite(premierNiveau));

                        // Reajuste la position du personnage si le personnage atteri DANS la plateforme
                        if (perso.ecartPlateforme(premierNiveau) > 10 && perso.ecartPlateforme(premierNiveau) < 26)
                            perso.setPositionY(perso.surQuelBloc(premierNiveau).getMinY() - 50);

                        premierNiveau.bordNiveau();

                        // Redessine le niveau et le personnage
                        premierNiveau.drawNiveau(canvasNiveau, perso.getPositionX(), perso.getPositionY());

                        /* Cas où le personnage tombe = GAME OVER
                           Avec possibilité de rejouer ou de revenir au menu*/
                        if (perso.getPositionY() > 1000) { // Le personnage tombe
                            perso.resetVitesse();
                            this.stop();
                            Graphique rectangleVictoire = new Graphique();
                            rectangleVictoire.dessinerRectangleInfo("GAME OVER", gcNiveau);
                            primaryStage.getScene().setOnKeyPressed(e -> {
                                if (e.getCode() == KeyCode.R) {
                                    perso.deplacePerso(e.getCode(), premierNiveau);
                                    this.start();
                                }
                                if (e.getCode() == KeyCode.M) {
                                    primaryStage.setScene(sceneMenu);
                                }
                            });
                        }

                        /* Cas où le personnage remporte le niveau
                         * Avec possibilité de rejouer ou de revenir au menu*/
                        if (perso.remporteNiveau(premierNiveau)) {
                            System.out.println("Gagné !");
                            this.stop();
                            Graphique rectangleDefaite = new Graphique();
                            rectangleDefaite.dessinerRectangleInfo("VICTOIRE", gcNiveau);
                            primaryStage.getScene().setOnKeyPressed(e -> {
                                if (e.getCode() == KeyCode.R) {
                                    perso.deplacePerso(e.getCode(), premierNiveau);
                                    this.start();
                                }
                                if (e.getCode() == KeyCode.M) {
                                    primaryStage.setScene(sceneMenu);
                                }
                            });
                        }

                    }
                }.start();
            }
        });

        scenesMenu.buttonList.get(1).setOnAction(actionEvent -> System.out.println("TestBoutonHighScore"));

        scenesMenu.buttonList.get(2).setOnAction(actionEvent -> primaryStage.close());
    }
}
