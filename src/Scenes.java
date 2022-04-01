import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/** La construction de la classe scene nécessite des boutons
 * Les boutons sont ajoutés dans une ArrayList */
public class Scenes {
    ArrayList<Button> buttonList;

    /** Création de boutons
     * String buttonName : text affiché dans le bouton
     * int translation : position horizontale du bouton
     * StackPane root : panneau auquel est rattaché le bouton*/
    private Button createButton(String buttonName, int translation, StackPane root){
        Button button = new Button();
        button.setText(buttonName);
        button.setTranslateY(translation);
        button.setBackground(Background.fill(Color.LIGHTGREEN));
        root.getChildren().add(button);
        return button;
    }

    public Scenes (ArrayList<Button> buttonList){
        this.buttonList = buttonList;
    }

    /** Construction du menu de démarrage
     * 3 boutons sont créés
     * Une image de fond est mise en place*/
    public Scene constructionMenu() {
        StackPane rootMenu = new StackPane();
        Scene sceneMenu = new Scene(rootMenu, 1000,650);

        Button Start = createButton("Start",-150,rootMenu);
        Button HighScore = createButton("Highscore",0,rootMenu);
        Button Exit = createButton("Exit",150,rootMenu);
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

}
