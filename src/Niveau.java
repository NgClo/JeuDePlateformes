import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Niveau {
    static Image fondEcran = new Image("2224.png");


    public static Scene premierNiveau() {
        Group groupNiveau = new Group();
        Scene sceneNiveau = new Scene(groupNiveau, 650, 650);
        Canvas premierNiveau = new Canvas(650, 650);

        GraphicsContext gc = premierNiveau.getGraphicsContext2D();

        gc.drawImage(fondEcran, 0, 0,650,650);
        groupNiveau.getChildren().addAll(premierNiveau);

        BlocsDeConstruction.placerBloc(1,0,"bloc1",groupNiveau);
        BlocsDeConstruction.placerBloc(5,1,"bloc3",groupNiveau);
        BlocsDeConstruction.placerBloc(1,6,"bloc2",groupNiveau);

        BlocsDeConstruction.placerBloc(1,8,"bloc1",groupNiveau);
        BlocsDeConstruction.placerBloc(10,9,"bloc3",groupNiveau);
        BlocsDeConstruction.placerBloc(1,19,"bloc2",groupNiveau);





        return sceneNiveau;
    }


}
