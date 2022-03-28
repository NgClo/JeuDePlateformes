import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;

import java.util.ArrayList;


public class BlocsDeConstruction {
    static Image lesBlocs = new Image("Plataformas.png");
    static int xImage = 384;
    static int yImage = 512;
    Rectangle2D bloc;
    ImageView skin;

    public static boolean pixelTransparent(int x, int y){
        PixelReader unPixel = lesBlocs.getPixelReader();
        int valPix = unPixel.getArgb(x,y);
        if ( valPix == 0){
            return true;
        }
        else {return false;}
    }

    public BlocsDeConstruction(int[] list){
        this.bloc = new Rectangle2D(list[0],list[1], list[2], list[3]);
        this.skin = skinBloc(this.bloc);
    }

    static public int [] recupBlocs(String nomBloc){
        int [] list = new int[4];
        int debutX = xImage;
        int debutY = yImage;
        int finX = 0;
        int finY = 0;
        if (nomBloc == "bloc1"){
                for (int i = 0; i < xImage/3 ; i++) { // Lecture par ligne
                    for (int j = 0; j < yImage / 4; j++) { // Lecture par colonne
                        if (pixelTransparent(i, j) == false) {
                            if (i < debutX) debutX = i;
                            if (j < debutY) debutY = j;
                            if (i > finX) finX = i;
                            if (j > finY) finY = j;
                        }
                    }
                }
        }
        if (nomBloc == "bloc2") {
            for (int i = xImage/3 ; i < 2*xImage/3 ; i++) { // Lecture par ligne
                for (int j = 0; j < yImage / 4; j++) { // Lecture par colonne
                    if (pixelTransparent(i, j) == false) {
                        if (i < debutX) debutX = i;
                        if (j < debutY) debutY = j;
                        if (i > finX) finX = i;
                        if (j > finY) finY = j;
                    }
                }
            }
        }
        if (nomBloc == "bloc3") {
            for (int i = 2 * xImage / 3; i < xImage; i++) { // Lecture par ligne
                for (int j = 0; j < yImage / 4; j++) { // Lecture par colonne
                    if (pixelTransparent(i, j) == false) {
                        if (i < debutX) debutX = i;
                        if (j < debutY) debutY = j;
                        if (i > finX) finX = i;
                        if (j > finY) finY = j;
                    }
                }
            }
        }
        list[0] = debutX;
        list[1] = debutY;
        list[2] = finX-debutX;
        list[3] = finY-debutY;
        return list;
    }


        public ImageView skinBloc(Rectangle2D bloc){
            ImageView blocView = new ImageView(lesBlocs);
            blocView.setViewport(bloc);
            return blocView;
        }

        public static void placerBloc(int quantiteBloc,int placementBloc,String typeBloc, Group groupNiveau){
            if (quantiteBloc == 1){
                BlocsDeConstruction bloc = new BlocsDeConstruction(BlocsDeConstruction.recupBlocs(typeBloc));
                bloc.skin.setX((bloc.bloc.getMaxX()-bloc.bloc.getMinX())*(placementBloc));
                bloc.skin.setY(630);
                groupNiveau.getChildren().add(bloc.skin);
            }

            else {
                ArrayList <BlocsDeConstruction> lesBlocs = new ArrayList<>();
                for (int i = 0; i < quantiteBloc;i++){
                    lesBlocs.add(i,new BlocsDeConstruction(BlocsDeConstruction.recupBlocs(typeBloc)));
                    lesBlocs.get(i).skin.setX((lesBlocs.get(i).bloc.getMaxX()-lesBlocs.get(i).bloc.getMinX())*(i+placementBloc));
                    lesBlocs.get(i).skin.setY(630);
                    groupNiveau.getChildren().add(lesBlocs.get(i).skin);
                }
            }
        }


    }

