import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Launch extends Application {

    public void start(Stage stage){

        // Creation de la scene du menu
        ArrayList<Button> listButton = new ArrayList<>();
        Graphique scenesMenu = new Graphique(listButton);
        Scene sceneMenu;
        sceneMenu = scenesMenu.constructionMenu();

        // Affichage de la scène du menu
        stage.setTitle("Jeu de plateformes");
        stage.setScene(sceneMenu);
        stage.show();

        // Association d'évènements aux boutons du menu
        // Le bouton Start affecte à la fenêtre la scene contenant le premier niveau
        scenesMenu.buttonList.get(0).setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StackPane rootNiveau = new StackPane(); // Creation du panneau pour les niveaux
                Canvas canvasNiveau = new Canvas(1000, 650); // Creation du canvas
                rootNiveau.getChildren().add(canvasNiveau); // Association du canvas au niveau
                Scene sceneNiveau = new Scene(rootNiveau, 1000, 650); // Creation d'une scène pour les niveaux avec un panneau associé
                stage.setScene(sceneNiveau); // On place la scene du niveau dans la fenêtre

                Personnage perso = new Personnage(); // Construction du personnage
                perso.chargementFrame(); // Chargement des frames du personnage

                ArrayList<Niveau> listeNiveau;
                listeNiveau = Niveau.creationNiveau(perso);

                listeNiveau.get(0).lancementNiveau(1,perso,canvasNiveau);

                new AnimationTimer() {       // Debut de la boucle

                    @Override
                    public void handle(long l) {
                        Niveau.ensembleActionsParLoop(stage,sceneMenu,this,perso, listeNiveau, canvasNiveau);
                    }
                }.start();
            }
        });
        scenesMenu.buttonList.get(1).setOnAction(actionEvent -> System.out.println("TestBoutonHighScore"));
        scenesMenu.buttonList.get(2).setOnAction(actionEvent -> stage.close());
    }
}
