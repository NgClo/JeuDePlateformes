import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.Objects;

/** La construction de l'objet de la classe Graphique nécessite des boutons
 * Les boutons sont ajoutés dans une ArrayList */
public class Graphique {
    ArrayList<Button> buttonList;

    /**
     * Création de boutons
     * String buttonName : text affiché dans le bouton
     * int translation : position horizontale du bouton
     * StackPane root : panneau auquel est rattaché le bouton
     */
    private Button createButton(String buttonName, int translation, StackPane root) {
        Button button = new Button();
        button.setText(buttonName);
        button.setTranslateY(translation);
        button.setBackground(Background.fill(Color.LIGHTGREEN));
        root.getChildren().add(button);
        return button;
    }

    public Graphique(ArrayList<Button> buttonList) {
        this.buttonList = buttonList;
    }

    public Graphique() {
    }

    /**
     * Construction du menu de démarrage
     * 3 boutons sont créés
     * Une image de fond est mise en place
     */
    public Scene constructionMenu() {
        StackPane rootMenu = new StackPane();
        Scene sceneMenu = new Scene(rootMenu, 1000, 650);

        Button Start = createButton("Start", -150, rootMenu);
        Button HighScore = createButton("Highscore", 0, rootMenu);
        Button Exit = createButton("Exit", 150, rootMenu);
        this.buttonList.add(Start);
        this.buttonList.add(HighScore);
        this.buttonList.add(Exit);

        Image imageMenu = new Image("beach.png");
        BackgroundImage fondEcranMenuImage = new BackgroundImage(imageMenu, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondEcranMenu = new Background(fondEcranMenuImage);

        rootMenu.setBackground(fondEcranMenu);

        return sceneMenu;
    }

    /**
     * Dessine un rectangle vert affichant un texte
     * String situation : cas d'une défaite ou d'une victoire ?
     * GraphicsContext gcNiveau : quel gc à utiliser pour dessiner
     */
    public void dessinerRectangleInfo(String situation, Canvas canvasNiveau) {
        GraphicsContext gcNiveau = canvasNiveau.getGraphicsContext2D();
        gcNiveau.setFill(Color.BLACK);
        gcNiveau.fillRect(95, 195, 810, 210);
        gcNiveau.setFill(Color.LIGHTGREEN);
        gcNiveau.fillRect(100, 200, 800, 200);
        gcNiveau.setFill(Color.BLACK);
        gcNiveau.setFont(Font.font(40));
        if (Objects.equals(situation, "GAME OVER")) {
            gcNiveau.fillText("GAME OVER - Pour rejouer, tapez 'R'.", 200, 280);
        }
        if (Objects.equals(situation, "VICTOIRE")) {
            gcNiveau.fillText("Félicitations ! Pour rejouer, tapez 'R'.", 200, 280);
        }

        gcNiveau.fillText("Pour revenir au menu, tapez 'M'.", 200, 350);
    }

    /** Permet de dessiner le numéro du niveau en haut à gauche de l'écran */
    public static void nomNiveau(int numeroNiveau, Canvas canvasNiveau) {
        GraphicsContext gcDraw = canvasNiveau.getGraphicsContext2D();
        gcDraw.setFill(Color.BLACK);
        gcDraw.setFont(Font.font(25));
        gcDraw.fillText("Niveau " + numeroNiveau, 1, 20);

    }
}
