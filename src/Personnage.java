import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Personnage extends Entite {

    Image image;
    int countObjet;
    double masse;
    double v;
    double a;




    Personnage(){
        super();
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    @Override
    public Image getImage() {
        return new Image("SpriteDinoCorrige/Idle_1.png",50,53,false, false);
    }

    public void deplacePerso(KeyCode keycode){
        if (keycode == KeyCode.D){
            setPositionX(getPositionX()+2);
        }
    }

    /** Permet de placer le personnage dans un groupe à la position définie
     * La liste permet d'encadrer le personnage dans l'image créée*/
/*    public static Personnage placerPerso(Group groupNiveau, double X, double Y){
        Image image = new Image("SpriteDino/Idle1.png");
        int [] list= new int [4];
        list[0] = 5;
        list[1] = 31;
        list[2] = 371;
        list[3] = 395;
        Personnage perso = new Personnage(list,image);

        perso.positionX = X;
        perso.positionY = Y;
        perso.image.setX(X);
        perso.image.setY(Y);
        perso.image.setPreserveRatio(true);
        perso.image.setFitHeight(100);
        perso.image.setFitWidth(100);
        groupNiveau.getChildren().add(perso.image);
        return perso;
    }*/

}

   /*          Personnage perso = new Personnage(Entite.determineHitBox(image),image);*/