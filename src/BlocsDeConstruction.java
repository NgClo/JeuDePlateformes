import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class BlocsDeConstruction {
    private static final Image lesBlocs = new Image("Plataformas.png");
    private static int xImage = 384;
    private static int yImage = 512;
    private Rectangle2D bloc;
    private Image skin;

    public Rectangle2D getBloc() {
        return bloc;
    }

    public Image getSkin() {
        return skin;
    }

    public void setBloc(Rectangle2D bloc) {
        this.bloc = bloc;
    }

    public void setSkin(Image skin) {
        this.skin = skin;
    }

    /** Constructeur des blocs
     * avec leur skin et leur rectangle
     * */
    public BlocsDeConstruction(String nomBloc, double positionX, double positionY){
        if (nomBloc == "Bloc1") {
                this.skin = new Image("PlateformesBloc1.png");
                this.bloc = new Rectangle2D(positionX,positionY, 34, 26);}
        if (nomBloc == "Bloc2") {
                this.skin = new Image("PlateformesBloc2.png");
                this.bloc = new Rectangle2D(positionX,positionY, 34, 26);}
        if (nomBloc == "Bloc3") {
                this.skin = new Image("PlateformesBloc3.png");
                this.bloc = new Rectangle2D(positionX,positionY, 34, 26);}
    }


    /** Permet de placer des blocs à partir de leur quantité, leur emplacement, leur nom et le groupe auquel ils sont rattachés
     * La liste de ces blocs est renvoyée*/
 /*  public static ArrayList<BlocsDeConstruction> placerBloc(int quantiteBloc,int placementBloc,String typeBloc, Group groupNiveau){
        ArrayList<BlocsDeConstruction> list = new ArrayList<>();
        if (quantiteBloc == 1){
            BlocsDeConstruction bloc = new BlocsDeConstruction(BlocsDeConstruction.recupBlocs(typeBloc));
            bloc.skin.setX((bloc.bloc.getMaxX()-bloc.bloc.getMinX())*(placementBloc));
            bloc.skin.setY(630);
            groupNiveau.getChildren().add(bloc.skin);
            list.add(bloc);
            return list;
        }

        else {
            ArrayList <BlocsDeConstruction> lesBlocs = new ArrayList<>();
            for (int i = 0; i < quantiteBloc;i++){
                lesBlocs.add(i,new BlocsDeConstruction(BlocsDeConstruction.recupBlocs(typeBloc)));
                lesBlocs.get(i).skin.setX((lesBlocs.get(i).bloc.getMaxX()-lesBlocs.get(i).bloc.getMinX())*(i+placementBloc));
                lesBlocs.get(i).skin.setY(630);
                groupNiveau.getChildren().add(lesBlocs.get(i).skin);
                list.add(lesBlocs.get(i));
            }
            return list;
        }
    }*/


}

