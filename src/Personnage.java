import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Personnage extends Entite {

    int countObjet;
    double masse;
    double v;
    double a;


    private Personnage(int [] list, Image image){
        super(list,image);
    }



    public static Personnage placerPerso(Group groupNiveau, double X, double Y){
        Image image = new Image("SpriteDino/Idle1.png");
        int [] list= new int [4];
        list[0] = 5;
        list[1] = 31;
        list[2] = 371;
        list[3] = 395;
        Personnage perso = new Personnage(list,image);

        perso.image.setX(X);
        perso.image.setY(Y);
        perso.image.setPreserveRatio(true);
        perso.image.setFitHeight(100);
        perso.image.setFitWidth(100);
        groupNiveau.getChildren().add(perso.image);
        return perso;
    }

}

   /*          Personnage perso = new Personnage(Entite.determineHitBox(image),image);*/